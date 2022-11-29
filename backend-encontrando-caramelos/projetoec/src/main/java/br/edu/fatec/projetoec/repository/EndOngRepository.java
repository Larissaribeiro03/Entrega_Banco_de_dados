package br.edu.fatec.projetoec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatec.projetoec.model.EnderecoOng;

@Repository
public interface EndOngRepository extends JpaRepository<EnderecoOng, Integer>{

}
