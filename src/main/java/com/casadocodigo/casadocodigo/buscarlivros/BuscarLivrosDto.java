package com.casadocodigo.casadocodigo.buscarlivros;

import com.casadocodigo.casadocodigo.novolivro.Livro;

public class BuscarLivrosDto {

	private Long id;
	private String nome;

	public BuscarLivrosDto(Livro obj) {
		id = obj.getId();
		nome = obj.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
