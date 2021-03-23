package com.lucaspereira.meuBlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaspereira.meuBlog.model.ModelTemas;

public interface RepositoryTemas extends JpaRepository<ModelTemas, Long> {
	public List<ModelTemas> findAllByDescricaoContainingIgnoreCase(String descricao);
	
}
