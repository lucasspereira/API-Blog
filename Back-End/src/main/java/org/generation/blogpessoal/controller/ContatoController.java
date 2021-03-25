package org.generation.blogpessoal.controller;

import java.util.List;

import org.generation.blogpessoal.model.ContatoModel;
import org.generation.blogpessoal.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contato")
@CrossOrigin("*")
public class ContatoController {

	@Autowired ContatoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<ContatoModel>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ContatoModel> getById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<ContatoModel> post (@RequestBody ContatoModel contato){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(contato));
	}
	
	@PutMapping
	public ResponseEntity<ContatoModel> put (@RequestBody ContatoModel contato){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(contato));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		repository.deleteById(id);
	}
}
