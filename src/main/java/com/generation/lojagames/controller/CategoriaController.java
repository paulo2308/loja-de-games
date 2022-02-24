package com.generation.lojagames.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.lojagames.model.CategoriaModel;
import com.generation.lojagames.repository.CategoriaRepository;

@RestController
@RequestMapping("/todascategorias")
public class CategoriaController {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> getAll(){
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> getById(@PathVariable Long id){
		return categoriaRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<CategoriaModel> getByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(categoriaRepository.findByDescricao(descricao));
	}
	
	@PostMapping
	public ResponseEntity<CategoriaModel> postCategoria(@Valid @RequestBody CategoriaModel categoriaModel){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(categoriaRepository.save(categoriaModel));
		
	}
	
	@PutMapping
	public ResponseEntity<CategoriaModel> putCategoria(@Valid @RequestBody CategoriaModel categoriaModel){
		return ResponseEntity.status(HttpStatus.OK)
				.body(categoriaRepository.save(categoriaModel));
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable Long id) {
		Optional<CategoriaModel> categoriaModel = categoriaRepository.findById(id);
		if(categoriaModel.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		categoriaRepository.deleteById(id);
		
	}
	
	
}
