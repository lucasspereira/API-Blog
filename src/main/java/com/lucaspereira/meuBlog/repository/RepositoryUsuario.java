package com.lucaspereira.meuBlog.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaspereira.meuBlog.model.ModelUsuario;

public interface RepositoryUsuario extends JpaRepository<ModelUsuario, Long> { // extendendo o JPA Repository
	
	@Autowired																// trazer todos os elementos da interface
	public Optional<ModelUsuario> findByUsuario (String usuario);			// método criado para encontrar na tabela pelo usuario(username)
	
}
