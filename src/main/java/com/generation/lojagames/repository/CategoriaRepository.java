package com.generation.lojagames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.lojagames.model.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{

	
	CategoriaModel findByDescricao(String descricao);
}
