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

import br.com.bankslife.backend.entities.Produto;
import br.com.bankslife.backend.services.ProdutoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins ="*" )
@RequestMapping({"/produtos"})
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@ApiOperation(value="Retorna todos Produtos")
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value="Busca Produto por id")
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable Long id){
		Produto list = service.findById(id);
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value="Insere Produto")
	@PostMapping
	public ResponseEntity<Produto> create(@RequestBody Produto produto){
		produto = service.save(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(produto);
	}
	
	@ApiOperation(value="Atualiza Produto")
	@RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
	public ResponseEntity<Produto> update(@RequestBody Produto produto, @PathVariable Long id){
		produto = service.update(produto, id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Remove Produto")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Código inexistente") }) //Mensagem de resposta especifica ao invés de Global
	@DeleteMapping(value = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
