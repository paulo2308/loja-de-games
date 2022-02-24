package com.generation.lojagames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity //usa o banco de dados informado no application.properties
@Table(name = "tb_categoria")
public class CategoriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY
	private Long id;
	
	@NotBlank(message = "Você precisa informar uma categoria")
	@Size(message = "A categoria esta fora dos padrões", min = 3, max = 50)
	private String nome;
	
	@NotBlank(message = "Você precisa informar uma descricao")
	@Size(message = "A categoria esta fora dos padrões", min = 3, max = 255)
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
