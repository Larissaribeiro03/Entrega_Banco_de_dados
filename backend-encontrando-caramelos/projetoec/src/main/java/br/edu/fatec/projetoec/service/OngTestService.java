package br.edu.fatec.projetoec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.fatec.projetoec.model.OngTest;
import br.edu.fatec.projetoec.repository.OngTestRepository;

@Service
public class OngTestService {
	
	private final OngTestRepository ongTestRepository;
	
	public OngTestService(OngTestRepository ongTestRepository) {
		this.ongTestRepository = ongTestRepository;
	}
	
	public OngTest save(OngTest ongtest) {
		return this.ongTestRepository.save(ongtest);
	}
	
	public List<OngTest> findALL(){
		return this.ongTestRepository.findAll();
	}

	public Optional<OngTest> findById(Integer id) {
		return this.ongTestRepository.findById(id);
	}

	public void delete(Integer id) {
		ongTestRepository.deleteById(id);
	}

}
