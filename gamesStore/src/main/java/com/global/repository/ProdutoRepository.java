package com.global.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.global.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public List<Produto> findAllByNomeContainingIgnoreCase(String produto);
}
