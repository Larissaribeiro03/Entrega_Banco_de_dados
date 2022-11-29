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
import br.edu.fatec.projetoec.service.OngService;

@RestController
@RequestMapping("/ongs")
public class OngController {
		
	@Autowired
	private OngService ongService;
		
		
	@GetMapping	
	public ResponseEntity<List<Ong>> findALL(){
		
		List<Ong> list = ongService.findALL();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ong> find(@PathVariable(name = "id") Integer id){
		Optional<Ong> ong = this.ongService.findById(id);
		if (ong.isPresent()) {
			return ResponseEntity.ok(ong.get());
		} else {
			return ResponseEntity.notFound().build();		
			}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Ong> edit(@PathVariable(name = "id") Integer id, @RequestBody Ong ong){
		  Optional<Ong> ongActual = this.ongService.findById(id);
		  if(ongActual.isPresent()) {
			  ongActual.get().setNome(ong.getNome());
			  ongActual.get().setTelefone(ong.getTelefone());
			  ongActual.get().setSite(ong.getSite());
			  return ResponseEntity.ok(this.ongService.save(ongActual.get()));
		  } else {
			  return ResponseEntity.notFound().build();
		  }
	 }
	
	  @PostMapping
	  public ResponseEntity<Ong> creat(@RequestBody Ong ong) {
		  Ong ongCreated = ongService.save(ong);
		  
		  return ResponseEntity.status(HttpStatus.CREATED).body(ongCreated);
	  }
	  
//	  @DeleteMapping("/{id}")
//	  public ResponseEntity<?> delete(@PathVariable(name = "id") Integer id){
//		  Optional<Ong> ongActual = this.ongService.findById(id);
//		  if(ongActual.isPresent()) {
//			  ongService.delete(id);
//			  return ResponseEntity.ok(null);
//		  } else {
//			  return ResponseEntity.notFound().build();
//		  }
//	  }
	
}
