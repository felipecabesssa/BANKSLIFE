package br.com.bankslife.leilao.backend.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.bankslife.leilao.backend.domains.Pedido;

@Controller
public class HomeController {
	
	@PersistenceContext
	private EntityManager conectaBanco;
	
	@GetMapping("/home")
	public String home(Model model) {
		
		Query query = conectaBanco.createQuery("select p from Pedido p", Pedido.class);
		List<Pedido> listaPedidos = query.getResultList();
		
		model.addAttribute("listaPedidos", listaPedidos);
		
		return "home";
	}

}
