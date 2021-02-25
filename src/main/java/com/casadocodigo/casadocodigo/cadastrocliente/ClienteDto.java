package com.casadocodigo.casadocodigo.cadastrocliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.casadocodigo.casadocodigo.novoestado.Estado;
import com.casadocodigo.casadocodigo.novopais.Pais;
import com.casadocodigo.casadocodigo.validador.CPFOuCNPJ;
import com.casadocodigo.casadocodigo.validador.ExistsId;
import com.casadocodigo.casadocodigo.validador.UniqueValue;
import com.sun.istack.NotNull;

public class ClienteDto {

	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email", message = "Email já cadastrado")
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "cpfCnpj", message = "CPF ou CNPJ já cadastrado")
    @CPFOuCNPJ
	private String cpfCnpj;

	@NotBlank
	private String endereco;

	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id", message = "País não existe")
	private Long idPais;

	@ExistsId(domainClass = Estado.class, fieldName = "id", message = "Estado não existe")
	private Long idEstado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public ClienteDto(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String cpfCnpj, @NotBlank String endereco, String complemento, @NotBlank String cidade,
			Long idPais, Long idEstado, @NotBlank String telefone, @NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpfCnpj = cpfCnpj;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Cliente toModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class, idPais);
		Estado estado = null;
		if (idEstado != null) {
			estado = manager.find(Estado.class, idEstado);
		}

		List<Estado> estados = pais.getEstados();

		if (estados.isEmpty() && idEstado == null) {
			return new Cliente(email, nome, sobrenome, cpfCnpj, endereco, complemento, cidade, pais, estado, telefone,
					cep);
		}
		if (estados.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este País não contém Estados cadastrados");
		}
		if (idEstado == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Estado é obrigatório para este País");
		}
		assert estado != null;
		if (!pais.getId().equals(estado.getPais().getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Não existe esse Estado cadastrado para este País");
		}
		return new Cliente(email, nome, sobrenome, cpfCnpj, endereco, complemento, cidade, pais, estado, telefone, cep);

	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

}
