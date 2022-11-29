package br.edu.fatec.projetoec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatec.projetoec.model.Ong;
import br.edu.fatec.projetoec.model.Pet;
import br.edu.fatec.projetoec.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {
	
	@Autowired
	private PetService petService;
		
	@GetMapping	
	public ResponseEntity<List<Pet>> findALL(){
		
		List<Pet> list = petService.findALL();
		return ResponseEntity.ok(list);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Pet> find(@PathVariable(name = "id") Integer id){
		Optional<Pet> ong = this.petService.findById(id);
		if (ong.isPresent()) {
			return ResponseEntity.ok(ong.get());
		} else {
			return ResponseEntity.notFound().build();		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pet> edit(@PathVariable(name = "id") Integer id, @RequestBody Pet pet){
		  Optional<Pet> petActual = this.petService.findById(id);
		  if(petActual.isPresent()) {
			  petActual.get().setNome(pet.getNome());
			  petActual.get().setIdade(pet.getIdade());
			  petActual.get().setSexo(pet.getSexo());
			  petActual.get().setRaca(pet.getRaca());
			  petActual.get().setCor(pet.getCor());
			  petActual.get().setVacinado(pet.getVacinado());
			  petActual.get().setVermifugado(pet.getVermifugado());
			  petActual.get().setCastrado(pet.getCastrado());
			  petActual.get().setObsHistorico(pet.getObsHistorico());
			  return ResponseEntity.ok(this.petService.save(petActual.get()));
		  } else {
			  return ResponseEntity.notFound().build();
		  }
	 }
	
	  @PostMapping
	  public ResponseEntity<Pet> creat(@RequestBody Pet pet) {
		  Pet petCreated = petService.save(pet);
		  
		  return ResponseEntity.status(HttpStatus.CREATED).body(petCreated);
	  }
	  
	  @DeleteMapping("/{id}")
	  public ResponseEntity<?> delete(@PathVariable(name = "id") Integer id){
		  Optional<Pet> petActual = this.petService.findById(id);
		  if(petActual.isPresent()) {
			  petService.delete(id);
			  return ResponseEntity.ok(null);
		  } else {
			  return ResponseEntity.notFound().build();
		  }
	  }

}
