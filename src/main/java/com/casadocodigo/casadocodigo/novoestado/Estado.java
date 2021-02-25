package com.casadocodigo.casadocodigo.novoestado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.casadocodigo.casadocodigo.novopais.Pais;
import com.sun.istack.NotNull;

@Entity
@Table(name = "estados", uniqueConstraints = @UniqueConstraint(columnNames = {"nome", "pais_id"}))
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;

	@ManyToOne
	private @NotNull @Valid Pais pais;

	@Deprecated
	public Estado() {
	}

	public Estado(@NotBlank String nome, @NotNull @Valid Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado(Long id, @NotBlank String nome, @Valid Pais pais) {
		this.id = id;
		this.nome = nome;
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", pais=" + pais + "]";
	}

}
