package com.generation.lojagames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.lojagames.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{

	
}
