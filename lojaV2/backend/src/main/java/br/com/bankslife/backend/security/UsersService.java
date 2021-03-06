package br.com.bankslife.backend.security;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository repository;

	@CrossOrigin
	@GetMapping
	public List<Users> findAll(){
		return repository.findAll();
	}
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private String senhaComHash;
	
	@CrossOrigin
	public Users findById(@PathVariable long id){
		Optional<Users> obj = repository.findById(id);
		return obj.get();
	}
	
	@CrossOrigin
	@PostMapping
	public Users create(@RequestBody Users users) {
		this.senhaComHash = passwordEncoder.encode(users.getPassword());
		users.setPassword(this.senhaComHash);
		return repository.save(users);
	}
	
	@CrossOrigin
	@RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
	public Users update(@RequestBody Users users, @PathVariable long id) {
		users.setId(id);
		return repository.save(users);
	}
	
	@CrossOrigin
	public ResponseEntity<?> delete (@PathVariable long id){
		repository.deleteById(id);
		return null;
	}
	
	
}
