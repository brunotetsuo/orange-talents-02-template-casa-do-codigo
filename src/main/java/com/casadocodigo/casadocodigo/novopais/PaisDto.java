package com.casadocodigo.casadocodigo.novopais;

import javax.validation.constraints.NotBlank;

import com.casadocodigo.casadocodigo.validador.UniqueValue;

public class PaisDto {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "País já cadastrado")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
