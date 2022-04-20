package br.com.bankslife.leilao.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bankslife.leilao.backend.domains.Pedido;
import br.com.bankslife.leilao.backend.dtos.RequisicaoNovoPedidoDTO;
import br.com.bankslife.leilao.backend.repositories.PedidoRepository;

@Controller
@CrossOrigin
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository daoPedido;
	
	@GetMapping("formulario")
	public String formulario() {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(RequisicaoNovoPedidoDTO requisicao) {
		
		Pedido pedido = requisicao.toPedido();
		daoPedido.save(pedido);
		
		return "pedido/formulario";
	}

}