package com.lucaspereira.meuBlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

import com.lucaspereira.meuBlog.model.postagens;
import com.lucaspereira.meuBlog.repository.postagemRepository;

@RestController                                          
@RequestMapping("/postagens")                           
@CrossOrigin("*")                                        
public class postagensController {
	                                               
	
	@Autowired 	                                        

	private postagemRepository repository;
	
	@GetMapping
	private ResponseEntity<List<postagens>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
		
	}

}
