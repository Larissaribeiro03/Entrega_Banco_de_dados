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

import br.edu.fatec.projetoec.model.EnderecoOng;
import br.edu.fatec.projetoec.service.EndOngservice;


@RestController
@RequestMapping("/andress")
public class EndOngController {
	
	@Autowired
	private EndOngservice endOngService;
		
		
	@GetMapping	
	public ResponseEntity<List<EnderecoOng>> findALL(){
		
		List<EnderecoOng> list = endOngService.findALL();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EnderecoOng> find(@PathVariable(name = "id") Integer id){
		Optional<EnderecoOng> endOng = this.endOngService.findById(id);
		if (endOng.isPresent()) {
			return ResponseEntity.ok(endOng.get());
		} else {
			return ResponseEntity.notFound().build();		
			}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EnderecoOng> edit(@PathVariable(name = "id") Integer id, @RequestBody EnderecoOng endOng){
		  Optional<EnderecoOng> endOngActual = this.endOngService.findById(id);
		  if(endOngActual.isPresent()) {
			  endOngActual.get().setBairro(endOng.getBairro());
			  endOngActual.get().setCep(endOng.getCep());
			  endOngActual.get().setCidade(endOng.getCidade());
			  return ResponseEntity.ok(this.endOngService.save(endOngActual.get()));
		  } else {
			  return ResponseEntity.notFound().build();
		  }
	 }
	
	  @PostMapping
	  public ResponseEntity<EnderecoOng> creat(@RequestBody EnderecoOng ong) {
		  EnderecoOng endOngCreated = endOngService.save(ong);
		  
		  return ResponseEntity.status(HttpStatus.CREATED).body(endOngCreated);
	  }
	  
	  @DeleteMapping("/{id}")
	  public ResponseEntity<?> delete(@PathVariable(name = "id") Integer id){
		  Optional<EnderecoOng> endOngActual = this.endOngService.findById(id);
		  if(endOngActual.isPresent()) {
			  endOngService.delete(id);
			  return ResponseEntity.ok(null);
		  } else {
			  return ResponseEntity.notFound().build();
		  }
	  }

}
