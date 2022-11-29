package br.edu.fatec.projetoec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatec.projetoec.model.Adotante;
import br.edu.fatec.projetoec.service.AdotanteService;

@RestController
@RequestMapping("/adotantes")
public class AdotanteController {
	
	@Autowired
	private AdotanteService adotanteService;
		
	@GetMapping	
	public ResponseEntity<List<Adotante>> findALL(){
		
		List<Adotante> list = adotanteService.findALL();
		return ResponseEntity.ok(list);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Adotante> find(@PathVariable(name = "id") Integer id){
		Optional<Adotante> adotante = this.adotanteService.findById(id);
		if (adotante.isPresent()) {
			return ResponseEntity.ok(adotante.get());
		} else {
			return ResponseEntity.notFound().build();		
			}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Adotante> edit(@PathVariable(name = "id") Integer id, @RequestBody Adotante adotante){
		  Optional<Adotante> adotanteActual = this.adotanteService.findById(id);
		  if(adotanteActual.isPresent()) {
			  adotanteActual.get().setNome(adotante.getNome());
			  adotanteActual.get().setUsuario(adotante.getUsuario());
			  adotanteActual.get().setTelefone(adotante.getTelefone());
			  return ResponseEntity.ok(this.adotanteService.save(adotanteActual.get()));
		  } else {
			  return ResponseEntity.notFound().build();
		  }
	 }
	
	@PostMapping
	public ResponseEntity<Adotante> creat(@RequestBody Adotante adotante) {
		  Adotante adotanteCreated = adotanteService.save(adotante);
		  
		  return ResponseEntity.status(HttpStatus.CREATED).body(adotanteCreated);
	}

}
