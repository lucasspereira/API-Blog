package com.lucaspereira.meuBlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lucaspereira.meuBlog.model.postagens;

@Repository 
public interface postagemRepository extends JpaRepository<postagens, Long> {
	public List<postagens> findAllTituloContainingIgnoreCase (String titulo);

}
