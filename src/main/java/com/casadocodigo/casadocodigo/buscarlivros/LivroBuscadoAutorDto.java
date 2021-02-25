package com.casadocodigo.casadocodigo.buscarlivros;

import com.casadocodigo.casadocodigo.novoautor.Autor;

public class LivroBuscadoAutorDto {

	private String nome;
	private String descricao;

	public LivroBuscadoAutorDto(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
