package com.servico.global;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private ServicoRepository repository;

	@GetMapping("/servicos")
	public List<ServicoModel> index() {
		return repository.findAll();
	}

	@PostMapping("/servicos")
	public ServicoModel create(@RequestBody ServicoModel servico) {
		return repository.save(servico);
	}
	
	@GetMapping("/servicos/nome/{nome}")
	public List<ServicoModel> findByName(@PathVariable String nome) {
		return repository.findByNome(nome);
	}
	
	@PutMapping("/servicos/{id}")
	public ServicoModel update(@PathVariable Long id, @RequestBody ServicoModel servico) {
		servico.setId(id);
		return repository.save(servico);
	}
	
	@DeleteMapping("/servicos/{id}")
	public String delete(@PathVariable Long id) {
		repository.deleteById(id);
		return "Serviço deletado";
	}
}
