package br.com.bankslife.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bankslife.backend.domains.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
