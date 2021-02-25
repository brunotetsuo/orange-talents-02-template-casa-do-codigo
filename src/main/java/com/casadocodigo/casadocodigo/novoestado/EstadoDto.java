package com.casadocodigo.casadocodigo.novoestado;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.casadocodigo.casadocodigo.novopais.Pais;
import com.casadocodigo.casadocodigo.validador.ExistsId;
import com.casadocodigo.casadocodigo.validador.UniqueValues;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

@UniqueValues(domainClass = Estado.class, fields = { "nome", "idPais" }, aliases = { "nome",
		"pais.id" }, message = "Estado já cadastrado")
public class EstadoDto {

	@NotBlank
	private String nome;

	@JsonProperty("id_pais")
	@ExistsId(domainClass = Pais.class, fieldName = "id", message = "País inválido")
	private Long idPais;

	public EstadoDto(@NotBlank String nome, @NotNull @Valid Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

	public Estado toModel(EntityManager manager) {
		@NotNull
		Pais pais = manager.find(Pais.class, idPais);

		if (pais == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return new Estado(nome, manager.find(Pais.class, idPais));
	}

	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}

}
