package br.com.bankslife.backend.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class JwtAuthenticateController {

	private List<Users> usuarios = new ArrayList<>();
	
	@Autowired
	private UsersRepository repository;
	
	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String createAuthenticeToken(@RequestBody Users authenticateRequest) {
		usuarios = repository.findAll();
		for(Users usuario: usuarios) {
			if(usuario.getUsername().equals(authenticateRequest.getUsername())
					&& usuario.getPassword().equals(authenticateRequest.getPassword())) {
				return usuario.getUsername() + " OK! ";
			}
		}
		
		return "Error";
	}
}
