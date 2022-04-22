package br.com.bankslife.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bankslife.backend.entities.Categoria;
import br.com.bankslife.backend.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria findById(Long id){
		Optional<Categoria> obj = repository.findById(id);
		return obj.get();
	}
	
	public Categoria save(Categoria categoria) {
		return repository.save(categoria);
	}
	
	public Categoria update(Categoria categoria, Long id) {
		categoria.setId(id);
		return repository.save(categoria);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
