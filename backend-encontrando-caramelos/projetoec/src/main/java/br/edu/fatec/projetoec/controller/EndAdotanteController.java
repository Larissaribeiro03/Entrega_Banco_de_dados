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

import br.edu.fatec.projetoec.model.EnderecoAdotantes;
import br.edu.fatec.projetoec.service.EndAdotanteService;

@RestController
@RequestMapping("/andressAdotante")
public class EndAdotanteController {
	@Autowired
	private EndAdotanteService endAdotanteService;

	@GetMapping	
	public ResponseEntity<List<EnderecoAdotantes>> findALL(){
		
		List<EnderecoAdotantes> list = endAdotanteService.findALL();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EnderecoAdotantes> find(@PathVariable(name = "id") Integer id){
		Optional<EnderecoAdotantes> endAdotante = this.endAdotanteService.findById(id);
		if (endAdotante.isPresent()) {
			return ResponseEntity.ok(endAdotante.get());
		} else {
			return ResponseEntity.notFound().build();		
			}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<EnderecoAdotantes> edit(@PathVariable(name = "id") Integer id, @RequestBody EnderecoAdotantes endAdotante){
		  Optional<EnderecoAdotantes> endAdotanteActual = this.endAdotanteService.findById(id);
		  if(endAdotanteActual.isPresent()) {
			  endAdotanteActual.get().setBairro(endAdotante.getBairro());
			  endAdotanteActual.get().setCep(endAdotante.getCep());
			  endAdotanteActual.get().setCidade(endAdotante.getCidade());
			  return ResponseEntity.ok(this.endAdotanteService.save(endAdotanteActual.get()));
		  } else {
			  return ResponseEntity.notFound().build();
		  }
	 }
	
	  @PostMapping
	  public ResponseEntity<EnderecoAdotantes> creat(@RequestBody EnderecoAdotantes adotante) {
		  EnderecoAdotantes endAdotanteCreated = endAdotanteService.save(adotante);
		  
		  return ResponseEntity.status(HttpStatus.CREATED).body(endAdotanteCreated);
	  }
	  
	  @DeleteMapping("/{id}")
	  public ResponseEntity<?> delete(@PathVariable(name = "id") Integer id){
		  Optional<EnderecoAdotantes> endAdotanteActual = this.endAdotanteService.findById(id);
		  if(endAdotanteActual.isPresent()) {
			  endAdotanteService.delete(id);
			  return ResponseEntity.ok(null);
		  } else {
			  return ResponseEntity.notFound().build();
		  }
	  }
}
