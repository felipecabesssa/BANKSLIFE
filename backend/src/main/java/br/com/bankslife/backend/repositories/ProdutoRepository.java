package br.com.bankslife.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bankslife.backend.domains.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
