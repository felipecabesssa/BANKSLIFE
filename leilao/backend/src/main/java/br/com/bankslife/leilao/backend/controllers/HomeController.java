package br.com.bankslife.leilao.backend.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.bankslife.leilao.backend.domains.Pedido;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Shape Fluido");
		pedido.setUrlImagem("https://cdn.shopify.com/s/files/1/0410/5361/8342/products/IMG_2569.jpg?v=1644329135");
		pedido.setUrlProduto("https://overstreet.com.br/products/shape-fluido-3?_pos=1&_psq=shape%20fluido&_ss=e&_v=1.0");
		pedido.setDescricao("Construção com 7 lâminas de marfim selecionadas e calibradas");
		
		List<Pedido> listaPedidos = Arrays.asList(pedido);
		model.addAttribute("listaPedidos", listaPedidos);
		
		return "home";
	}

}
