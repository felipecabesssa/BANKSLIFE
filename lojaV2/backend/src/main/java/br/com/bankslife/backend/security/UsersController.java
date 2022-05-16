package br.com.bankslife.backend.security;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.bankslife.backend.dtos.UserDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins ="*" )
@RequestMapping({"/users"})
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	@ApiOperation(value="Retorna todos Userss")
	@GetMapping
	public List<UserDto> findAll(){
		service.findAll();
		return service.findAll().stream()
				.map(user -> new UserDto(user))
				.collect(Collectors.toList());
	}
	
	@ApiOperation(value="Busca Users por id")
	@GetMapping(path = {"/{id}"})
	public UserDto findById(@PathVariable Long id){
		Users user = service.findById(id);
		UserDto userdto = new UserDto(user);
		return userdto;
	}
	
	@ApiOperation(value="Insere Users")
	@PostMapping
	public ResponseEntity<Users> create(@RequestBody Users users){
		users = service.create(users);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(users.getId()).toUri();
		return ResponseEntity.created(uri).body(users);
	}
	
	@ApiOperation(value="Atualiza Users")
	@RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
	public ResponseEntity<Users> update(@RequestBody Users users, @PathVariable Long id){
		users = service.update(users, id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Remove Users")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Código inexistente") }) //Mensagem de resposta especifica ao invés de Global
	@DeleteMapping(value = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
