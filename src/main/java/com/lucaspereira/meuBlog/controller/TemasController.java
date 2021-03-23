package com.lucaspereira.meuBlog.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.boot.model.source.internal.hbm.RootEntitySourceImpl;
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

import com.lucaspereira.meuBlog.model.ModelTemas;
import com.lucaspereira.meuBlog.repository.RepositoryTemas;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tema")
public class TemasController {
	
	@Autowired
	private RepositoryTemas repository;
	
	@GetMapping
	public ResponseEntity<List<ModelTemas>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ModelTemas> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ModelTemas>> getByName(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<ModelTemas> post (@Valid @RequestBody ModelTemas tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<ModelTemas> put (@Valid @RequestBody ModelTemas tema) {
		return ResponseEntity.ok(repository.save(tema));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@Valid @PathVariable long id) {
		repository.deleteById(id);
	}
}
