package br.edu.fatec.projetoec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatec.projetoec.model.EnderecoOng;
import br.edu.fatec.projetoec.repository.EndOngRepository;

@Service
public class EndOngservice {
	
	@Autowired
	private EndOngRepository endOngRepository;
	
	public EnderecoOng save(EnderecoOng endOng) {
		return this.endOngRepository.save(endOng);
	}
	
	public List<EnderecoOng> findALL(){
		return this.endOngRepository.findAll();
	}

	public Optional<EnderecoOng> findById(Integer id) {
		return this.endOngRepository.findById(id);
	}

	public void delete(Integer id) {
		endOngRepository.deleteById(id);
	}

}
