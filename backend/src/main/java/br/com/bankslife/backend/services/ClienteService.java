package br.com.bankslife.backend.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bankslife.backend.domains.Cliente;
import br.com.bankslife.backend.repositories.ClienteRepository;
import br.com.bankslife.backend.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Cliente.class.getName()));
	}

}
