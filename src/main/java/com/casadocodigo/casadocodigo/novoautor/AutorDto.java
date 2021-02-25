package com.casadocodigo.casadocodigo.novoautor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorDto {

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	@Size(max = 400)
	private String descricao;

	public AutorDto(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {

		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}

	public String getEmail() {
		return this.email;
	}

}
