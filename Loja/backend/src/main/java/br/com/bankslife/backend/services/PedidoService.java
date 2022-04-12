package br.com.bankslife.backend.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bankslife.backend.domains.Pedido;
import br.com.bankslife.backend.repositories.PedidoRepository;
import br.com.bankslife.backend.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Pedido.class.getName()));
	}

}
