package br.com.bankslife.backend.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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

	@GetMapping
	public List<Users> findAll(){
		return repository.findAll();
	}
	
	public ResponseEntity<?> findById(@PathVariable long id){
		return repository.findById(id).map(response -> ResponseEntity.ok().body(response)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Users create(@RequestBody Users users) {
		return repository.save(users);
	}
	
	@RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
	public Users update(@RequestBody Users users, @PathVariable long id) {
		users.setId(id);
		return repository.save(users);
	}
	
	public ResponseEntity<?> delete (@PathVariable long id){
		repository.deleteById(id);
		return null;
	}
	
	
}
