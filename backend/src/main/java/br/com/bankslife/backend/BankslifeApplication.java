package br.com.bankslife.backend;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.bankslife.backend.domains.Categoria;
import br.com.bankslife.backend.domains.Cidade;
import br.com.bankslife.backend.domains.Cliente;
import br.com.bankslife.backend.domains.Endereco;
import br.com.bankslife.backend.domains.Estado;
import br.com.bankslife.backend.domains.Produto;
import br.com.bankslife.backend.domains.enums.TipoCliente;
import br.com.bankslife.backend.repositories.CategoriaRepository;
import br.com.bankslife.backend.repositories.CidadeRepository;
import br.com.bankslife.backend.repositories.ClienteRepository;
import br.com.bankslife.backend.repositories.EnderecoRepository;
import br.com.bankslife.backend.repositories.EstadoRepository;
import br.com.bankslife.backend.repositories.ProdutoRepository;

@SpringBootApplication
public class BankslifeApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BankslifeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Shape");
		Categoria cat2 = new Categoria(null, "Roupa");
		Categoria cat3 = new Categoria(null, "PecasAcessorios");
		
		Produto p1 = new Produto(null, "Shape Fluido Boizada", 200.00);
		Produto p2 = new Produto(null, "Shape Lehi Leite Hondar", 250.00);
		Produto p3 = new Produto(null, "Shape PlanB Felipe G", 500.00);
		Produto p4 = new Produto(null, "Regata Lehi Leite - Hocks", 100.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p4));
		cat3.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat3));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		Estado est1 = new Estado(null, "Brasília");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "DF", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Italo Vinicius", "boi@bankslife.com.br", "36378912377", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "QNL", null, "Rua 9", "Jardim Botanico", "70000", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 80", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}
