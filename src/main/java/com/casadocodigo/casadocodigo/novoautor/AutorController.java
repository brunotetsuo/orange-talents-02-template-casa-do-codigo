package com.casadocodigo.casadocodigo.novoautor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutorController {
	
	@Autowired
	private AutorRepository repository;
	
	@Autowired
	private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEmailDuplicadoAutorValidator);
	}

	@PostMapping(value = "/autores")
	public String cria(@RequestBody @Valid AutorDto autorDto) {
		Autor autor = autorDto.toModel();
		repository.save(autor);
		return autor.toString();
	}
}
