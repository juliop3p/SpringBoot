package com.product.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goals")
public class HelloController {

	@GetMapping
	public String goals() {
		return "Interagir com as informações do banco de dados pelas rotas";
	}
}
