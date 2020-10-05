package com.escola.controller;

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

import com.escola.model.Aluno;
import com.escola.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	AlunoRepository repository;

	@GetMapping
	public ResponseEntity<List<Aluno>> findAllAluno() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> findByIdAluno(@PathVariable Long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping 
	public ResponseEntity<Aluno> postAluno(@RequestBody Aluno aluno) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(aluno));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aluno> putAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
		aluno.setId(id);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(aluno));
	}	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
