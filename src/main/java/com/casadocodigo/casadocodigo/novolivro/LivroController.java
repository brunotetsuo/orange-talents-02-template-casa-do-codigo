package com.casadocodigo.casadocodigo.novolivro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/livros")
	@Transactional
	public String cria(@RequestBody @Valid LivroDto livroDto) {
		Livro novoLivro = livroDto.toModel(manager);
		manager.persist(novoLivro);
		return novoLivro.toString();
	}

}
