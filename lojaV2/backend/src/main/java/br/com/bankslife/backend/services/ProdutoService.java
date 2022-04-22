package br.com.bankslife.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bankslife.backend.entities.Produto;
import br.com.bankslife.backend.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> findAll(){
		return repository.findAll();
	}
	
	public Produto findById(Long id){
		Optional<Produto> obj = repository.findById(id);
		return obj.get();
	}
	
	public Produto save(Produto produto) {
		return repository.save(produto);
	}
	
	public Produto update(Produto produto, Long id) {
		produto.setId(id);
		return repository.save(produto);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}