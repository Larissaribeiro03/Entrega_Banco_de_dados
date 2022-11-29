package br.edu.fatec.projetoec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatec.projetoec.model.OngTest;

@Repository
public interface OngTestRepository extends JpaRepository<OngTest, Integer>{

}
