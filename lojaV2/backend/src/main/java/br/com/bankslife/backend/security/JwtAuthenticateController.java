package br.com.bankslife.backend.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class JwtAuthenticateController {

	private List<Users> usuarios = new ArrayList<>();
	private String token;
	
	@Autowired
	private UsersRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String createAuthenticeToken(@RequestBody Users authenticateRequest) {
		usuarios = repository.findAll();
		for(Users usuario: usuarios) {
			if(usuario.getUsername().equals(authenticateRequest.getUsername()) && 
					passwordEncoder.matches(authenticateRequest.getPassword(), usuario.getPassword())) {
				
				//O matches compara pela referencia, e nao pelo conteudo, os sysos abaixo testam e mostram isso
				
//				var testeRequest = passwordEncoder.encode(authenticateRequest.getPassword());
//				
//				System.out.println(testeRequest);
//				System.out.println(usuario.getPassword());
				
				final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(
						authenticateRequest.getUsername());
				
//				System.out.println(userDetails);
//				return usuario.getUsername() + " OK! ";
				
				this.token = jwtTokenUtil.generateToken(userDetails);
				
				return this.token;				

			}
		}
		
		return "Error";
	}
}
