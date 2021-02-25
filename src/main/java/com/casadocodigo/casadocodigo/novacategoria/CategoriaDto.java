package com.casadocodigo.casadocodigo.novacategoria;

import javax.validation.constraints.NotBlank;

import com.casadocodigo.casadocodigo.validador.UniqueValue;

public class CategoriaDto {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Nome já cadastrado")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
