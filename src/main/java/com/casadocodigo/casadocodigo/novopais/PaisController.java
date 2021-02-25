package com.casadocodigo.casadocodigo.novopais;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaisController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping(value = "/paises")
	@Transactional
	public String criaPais(@RequestBody @Valid PaisDto paisDto) {
		Pais novoPais = new Pais(paisDto.getNome());
		manager.persist(novoPais);
		return novoPais.toString();
	}
	

}
