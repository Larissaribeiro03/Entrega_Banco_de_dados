package br.edu.fatec.projetoec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatec.projetoec.model.EnderecoAdotantes;
import br.edu.fatec.projetoec.repository.EndAdotanteRepository;

@Service
public class EndAdotanteService {
	@Autowired
	private EndAdotanteRepository endAdotanteRepository;
	
	public EnderecoAdotantes save(EnderecoAdotantes endAdotante) {
		return this.endAdotanteRepository.save(endAdotante);
	}
	
	
	public List<EnderecoAdotantes> findALL(){
		return this.endAdotanteRepository.findAll();
	}

	public Optional<EnderecoAdotantes> findById(Integer id) {
		return this.endAdotanteRepository.findById(id);
	}

	public void delete(Integer id) {
		endAdotanteRepository.deleteById(id);
	}

}
