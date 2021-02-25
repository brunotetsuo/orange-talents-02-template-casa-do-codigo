package com.casadocodigo.casadocodigo.novopais;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.casadocodigo.casadocodigo.novoestado.Estado;

@Entity
@Table(name = "paises")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(unique = true)
	private String nome;

	@OneToMany(mappedBy = "pais")
	private List<Estado> estados = new ArrayList<>();

	@Deprecated
	public Pais() {
	}

	public Pais(@NotBlank String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + "]";
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Estado> getEstados() {
		return estados;
	}

}
