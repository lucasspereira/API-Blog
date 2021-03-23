package com.lucaspereira.meuBlog.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_temas")
public class ModelTemas {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String descricao;
	
	@OneToMany (mappedBy = "tema", cascade = CascadeType.ALL)
	@JsonIgnoreProperties ("tema")
	private List<postagens> postagem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<postagens> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<postagens> postagem) {
		this.postagem = postagem;
	}
	
	
	}
