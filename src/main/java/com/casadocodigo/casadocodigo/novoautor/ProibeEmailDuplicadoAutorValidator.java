package com.casadocodigo.casadocodigo.novoautor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		AutorDto autorDto = (AutorDto) target;

		Optional<Autor> possivelAutor = autorRepository.findByEmail(autorDto.getEmail());

		if (possivelAutor.isPresent()) {
			errors.rejectValue("email", null, "Já existe um(a) outro(a) autor(a) com o mesmo email " + autorDto.getEmail());
		}

	}

}
