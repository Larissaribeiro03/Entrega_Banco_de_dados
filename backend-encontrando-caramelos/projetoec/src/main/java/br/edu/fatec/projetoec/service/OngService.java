package br.edu.fatec.projetoec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.fatec.projetoec.model.Ong;
import br.edu.fatec.projetoec.repository.OngRepository;

@Service
public class OngService {
	
	private final OngRepository ongRepository;
	
	public OngService(OngRepository ongRepository) {
		this.ongRepository = ongRepository;
	}
	
	public Ong save(Ong ong) {
		return this.ongRepository.save(ong);
	}
	
	
	public List<Ong> findALL(){
		return this.ongRepository.findAll();
	}

	public Optional<Ong> findById(Integer id) {
		return this.ongRepository.findById(id);
	}

	public void delete(Integer id) {
		ongRepository.deleteById(id);
	}

}
