package com.casadocodigo.casadocodigo.novolivro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.casadocodigo.casadocodigo.novacategoria.Categoria;
import com.casadocodigo.casadocodigo.novoautor.Autor;

@Entity
@Table(name = "livros")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private @NotBlank String titulo;
	private @NotBlank @Size(max = 500) String resumo;
	private @NotBlank String sumario;
	private @Min(20) BigDecimal preco;
	private @Min(100) int numeroDePaginas;
	@Column(unique = true)
	private @NotBlank String isbn;
	@NotNull
	private @Future LocalDate dataDePublicacao;
	@ManyToOne
	private Autor autor;
	@ManyToOne
	private Categoria categoria;

	@Deprecated
	public Livro() {
	}

	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@Min(20) BigDecimal preco, @Min(100) int numeroDePaginas, @NotBlank String isbn,
			@Future @NotNull LocalDate dataDePublicacao, Autor autor,
			Categoria categoria) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.dataDePublicacao = dataDePublicacao;
		this.autor = autor;
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco="
				+ preco + ", numeroDePaginas=" + numeroDePaginas + ", isbn=" + isbn + ", dataDePublicacao="
				+ dataDePublicacao + ", autor=" + autor + ", categoria=" + categoria + "]";
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
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

	public LocalDate getDataDePublicacao() {
		return dataDePublicacao;
	}

	public Autor getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

}
