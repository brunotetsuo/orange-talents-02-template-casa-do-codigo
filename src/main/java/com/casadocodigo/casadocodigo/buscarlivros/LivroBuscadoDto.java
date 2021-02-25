package com.casadocodigo.casadocodigo.buscarlivros;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import com.casadocodigo.casadocodigo.novolivro.Livro;

public class LivroBuscadoDto {

	private String sumario;
	private String resumo;
	private BigDecimal preco;
	private int numeroDePaginas;
	private String isbn;
	private LivroBuscadoAutorDto autor;
	private String titulo;
	private String dataDePublicacao;

	public LivroBuscadoDto(Livro livro) {
		titulo = livro.getTitulo();
		autor = new LivroBuscadoAutorDto(livro.getAutor());
		isbn = livro.getIsbn();
		numeroDePaginas = livro.getNumeroDePaginas();
		preco = livro.getPreco();
		resumo = livro.getResumo();
		sumario = livro.getSumario();
		dataDePublicacao = livro.getDataDePublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public String getDataPublicacao() {
		return dataDePublicacao;
	}

	public String getSumario() {
		return sumario;
	}

	public String getResumo() {
		return resumo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LivroBuscadoAutorDto getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

}
