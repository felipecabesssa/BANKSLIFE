package br.com.bankslife.leilao.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bankslife.leilao.backend.domains.Pedido;
import br.com.bankslife.leilao.backend.enums.StatusPedido;
import br.com.bankslife.leilao.backend.repositories.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository daoPedido;
	
	@GetMapping
	public String home(Model model) {
			
		List<Pedido> listaPedidos = daoPedido.findAll();
		model.addAttribute("listaPedidos", listaPedidos);
		
		return "home";
	}
	
	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {
			
		List<Pedido> listaPedidos = daoPedido.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("listaPedidos", listaPedidos);
		model.addAttribute("status", status);
		
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}

}
