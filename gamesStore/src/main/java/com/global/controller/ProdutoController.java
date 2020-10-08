package com.global.controller;

import java.util.List;

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

import com.global.model.Produto;
import com.global.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findByIdCategoria(@PathVariable Long id) {
		return repository.findById(id)
				.map(produto -> ResponseEntity.ok(produto))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/produto/{produto}")
	public ResponseEntity<List<Produto>> getByDescricaoCategoria(@PathVariable String produto) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(produto));
	}
	
	@PostMapping
	public ResponseEntity<Produto> postProduto(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> putProduto(@PathVariable Long id, @RequestBody Produto produto) {
		produto.setId(id);
		return ResponseEntity.ok(repository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
