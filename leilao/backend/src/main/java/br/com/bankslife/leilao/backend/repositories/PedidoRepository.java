package br.com.bankslife.leilao.backend.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.bankslife.leilao.backend.domains.Pedido;

@Repository
public class PedidoRepository {
	
	@PersistenceContext
	private EntityManager conectaBanco;

	
	public List<Pedido> recuperaTodosOsPedidos(){
		Query query = conectaBanco.createQuery("select p from Pedido p", Pedido.class);
		return query.getResultList();
		
	}

}
