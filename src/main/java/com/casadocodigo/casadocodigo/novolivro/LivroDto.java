package com.casadocodigo.casadocodigo.novolivro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.casadocodigo.casadocodigo.novacategoria.Categoria;
import com.casadocodigo.casadocodigo.novoautor.Autor;
import com.casadocodigo.casadocodigo.validador.ExistsId;
import com.casadocodigo.casadocodigo.validador.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.sun.istack.NotNull;

public class LivroDto {

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Título já cadastrado")
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String resumo;
	@NotBlank
	private String sumario;

	@NotNull
    @Min(value = 20, message = "Preço mínimo de 20,00")
	private BigDecimal preco;

	@Min(value = 100, message = "Mínimo de 100 páginas")
	private int numeroDePaginas;

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "Isbn já cadastrado")
	private String isbn;

	@Future
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataDePublicacao;

	@NotNull
	@ExistsId(domainClass = Categoria.class, fieldName = "id", message = "Categoria não existe")
	private Long idCategoria;

	@NotNull
	@ExistsId(domainClass = Autor.class, fieldName = "id", message = "Autor não existe")
	private Long idAutor;

	public LivroDto(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@Min(20) BigDecimal preco, @Min(100) int numeroDePaginas, @NotBlank String isbn, @NotNull Long idCategoria,
			@NotNull Long idAutor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	// Setter criado pq o Jackson não estava sendo capaz de desserializar o json com
	// a data no parâmetro pelo construtor.
	public void setDataDePublicacao(LocalDate dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}

	public Livro toModel(EntityManager manager) {
		@NotNull Autor autor = manager.find(Autor.class, idAutor);
		@NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);
		
		return new Livro(titulo, resumo, sumario, preco, numeroDePaginas, isbn, dataDePublicacao, autor, categoria);
	}

}
