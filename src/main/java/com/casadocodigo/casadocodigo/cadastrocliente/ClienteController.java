package com.casadocodigo.casadocodigo.cadastrocliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping(value = "/clientes")
	@Transactional
	public ResponseEntity<Long> cria(@RequestBody @Valid ClienteDto clienteDto) {
		Cliente cliente = clienteDto.toModel(manager);		

		manager.persist(cliente);
		
		return ResponseEntity.ok().body(cliente.getId());
	}

}
