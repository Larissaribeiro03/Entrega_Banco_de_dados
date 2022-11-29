package br.edu.fatec.projetoec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.fatec.projetoec.model.Adotante;
import br.edu.fatec.projetoec.repository.AdotanteRepository;


@Service
public class AdotanteService {
	
	private final  AdotanteRepository adotanteRepository;
	
	public AdotanteService(AdotanteRepository adotanteRepository) {
		this.adotanteRepository = adotanteRepository;
	}
	
	public Adotante save(Adotante adotante) {
		return this.adotanteRepository.save(adotante);
	}
	
	public List<Adotante> findALL(){
		return this.adotanteRepository.findAll();
	}

	public Optional<Adotante> findById(Integer id) {
		return this.adotanteRepository.findById(id);
	}

	public void delete(Integer id) {
		adotanteRepository.deleteById(id);
	}

}
