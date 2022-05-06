package br.com.bankslife.backend.controllers;

import java.net.URI;
import java.util.List;

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

import br.com.bankslife.backend.entities.Categoria;
import br.com.bankslife.backend.services.CategoriaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins ="*" )
@RequestMapping({"/categorias"})
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@ApiOperation(value="Retorna todas categorias")
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(){
		List<Categoria> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value="Busca Categoria por id")
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable Long id){
		Categoria list = service.findById(id);
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value="Insere categoria")
	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
		categoria = service.save(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).body(categoria);
	}
	
	@ApiOperation(value="Atualiza categoria")
	@RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
	public ResponseEntity<Categoria> update(@RequestBody Categoria categoria, @PathVariable Long id){
		categoria = service.update(categoria, id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Remove Categoria")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Não é possível excluir uma categoria que possui produtos"), //Só disponivel com tratamento de exceção (try catch) na exclusão de categoria
			@ApiResponse(code = 404, message = "Código inexistente") }) //Mensagem de resposta especifica ao invés de Global
	@DeleteMapping(value = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
