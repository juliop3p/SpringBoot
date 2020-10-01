package com.servico.global;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicos")
public class Controller {

	@Autowired
	private ServicoRepository repository;

	@GetMapping
	public List<ServicoModel> index() {
		return repository.findAll();
	}

	@PostMapping
	public ServicoModel create(@RequestBody ServicoModel servico) {
		return repository.save(servico);
	}
	
	@PutMapping
	public ServicoModel update(@RequestBody ServicoModel servico) {
		return repository.save(servico);
	}
	
	@DeleteMapping
	public String delete(@RequestBody ServicoModel servico) {
		repository.delete(servico);
		return "Serviço deletado";
	}
}
