package br.com.bankslife.leilao.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.bankslife.leilao.backend.domains.Pedido;
import br.com.bankslife.leilao.backend.repositories.PedidoRepository;

@Controller
public class HomeController {
	
	@Autowired
	private PedidoRepository daoPedido;
	
	@GetMapping("/home")
	public String home(Model model) {
			
		List<Pedido> listaPedidos = daoPedido.recuperaTodosOsPedidos();
		model.addAttribute("listaPedidos", listaPedidos);
		
		return "home";
	}

}
