package br.edu.fatec.projetoec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.fatec.projetoec.model.Pet;
import br.edu.fatec.projetoec.repository.PetRepository;

@Service
public class PetService {
	
	private final PetRepository petRepository;
	
	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}
	
	public Pet save(Pet pet) {
		return this.petRepository.save(pet);
	}
	
	public List<Pet> findALL(){
		return this.petRepository.findAll();
	}

	public Optional<Pet> findById(Integer id) {
		return this.petRepository.findById(id);
	}

	public void delete(Integer id) {
		petRepository.deleteById(id);
	}

}
