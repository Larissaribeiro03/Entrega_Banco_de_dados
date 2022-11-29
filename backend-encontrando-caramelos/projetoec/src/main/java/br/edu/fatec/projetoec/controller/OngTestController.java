package br.edu.fatec.projetoec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatec.projetoec.model.OngTest;
import br.edu.fatec.projetoec.service.OngTestService;

@RestController
@RequestMapping("/ongstest")
public class OngTestController {
	
		@Autowired
		private OngTestService ongTestService;
		
		
	@GetMapping	
	public ResponseEntity<List<OngTest>> findALL(){
		
		List<OngTest> list = ongTestService.findALL();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OngTest> find(@PathVariable(name = "id") Integer id){
		Optional<OngTest> ongtest = this.ongTestService.findById(id);
		if (ongtest.isPresent()) {
			return ResponseEntity.ok(ongtest.get());
		} else {
			return ResponseEntity.notFound().build();		
			}
	}
	
	
	  @PostMapping
	  public ResponseEntity<OngTest> creat(@RequestBody OngTest ongTest) {
		  OngTest ongCreated = ongTestService.save(ongTest);
		  
		  return ResponseEntity.status(HttpStatus.CREATED).body(ongCreated);
	  }

}
