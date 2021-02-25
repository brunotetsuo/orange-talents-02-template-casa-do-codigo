package com.casadocodigo.casadocodigo.novoestado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstadoController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping(value = "/estados")
	@Transactional
	public String criaEstado(@RequestBody @Valid EstadoDto estadoDto) {
		
		Estado novoEstado = estadoDto.toModel(manager);
		manager.persist(novoEstado);
		return novoEstado.toString();
	}

}
