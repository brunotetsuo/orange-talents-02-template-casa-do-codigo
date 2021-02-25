package com.casadocodigo.casadocodigo.cadastrocliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.casadocodigo.casadocodigo.novoestado.Estado;
import com.casadocodigo.casadocodigo.novopais.Pais;
import com.sun.istack.NotNull;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Email
	@Column(unique = true)
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	@Column(unique = true)
	private String cpfCnpj;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull
	@ManyToOne
	private Pais pais;

	@NotNull
	@ManyToOne
	private Estado estado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	@Deprecated
	public Cliente() {
	}

	public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String cpfCnpj, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade,
			@NotNull Pais pais, @NotNull Estado estado, @NotBlank String telefone, @NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpfCnpj = cpfCnpj;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}
	
	

}
