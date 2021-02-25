package com.casadocodigo.casadocodigo.novacategoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/categorias")
	@Transactional
	public String cria(@RequestBody @Valid CategoriaDto categoriaDto) {

		Categoria novaCategoria = new Categoria(categoriaDto.getNome());
		manager.persist(novaCategoria);

		return novaCategoria.toString();
	}

}
