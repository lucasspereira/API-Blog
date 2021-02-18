package com.lucaspereira.meuBlog.controller;

import java.util.List;

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

import com.lucaspereira.meuBlog.model.postagens;
import com.lucaspereira.meuBlog.repository.postagensRepository;

@RestController														// informa para o Spring que essa classe é uma controladora
@RequestMapping("/postagens")										// informa que essa requisição vai consumir a classe "postagens"
@CrossOrigin("*")													// para aceitar requisições de qualquer origem
public class postagensController {
	
	@Autowired														// inicializa uma interface
	private postagensRepository repository;							// incluindo a classe de repositório no contrlador
	
	@GetMapping
	public ResponseEntity<List<postagens>> GettAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping ("/{id}")
	public ResponseEntity<postagens> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		
	}
	@GetMapping ("/titulo/{titulo}")
	public ResponseEntity<List<postagens>> GetBytitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllBytituloContainingIgnoreCase(titulo));
	}
	@PostMapping
	public ResponseEntity<postagens> post (@RequestBody postagens postagens){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagens));
	}
	
	@PutMapping
	public ResponseEntity<postagens> put (@RequestBody postagens postagens){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagens));
	}
	
	@DeleteMapping ("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
}
