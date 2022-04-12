package br.com.bankslife.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.bankslife.backend.domains.Categoria;
import br.com.bankslife.backend.repositories.CategoriaRepository;
import br.com.bankslife.backend.services.exceptions.DataIntegrityException;
import br.com.bankslife.backend.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insereCategoria(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria atualizaCategoria(Categoria obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}
	
	public void apagaCategoria(Integer id) {
		buscar(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possua produtos");
		}
		
	}
	
	public List<Categoria> buscaTodasCategorias(){
		return repo.findAll();
	}

}
