package com.casadocodigo.casadocodigo.buscarlivros;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.casadocodigo.casadocodigo.novolivro.Livro;

@RestController
public class BuscarLivrosController {
	
	@PersistenceContext
	private EntityManager manager;
	
	
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/livros")
	public ResponseEntity<List<BuscarLivrosDto>> listarLivros() {
		List<Livro> listaLivros = manager.createQuery("FROM " + Livro.class.getName()).getResultList();
		List<BuscarLivrosDto> listaLivrosDto = listaLivros.stream().map(obj -> new BuscarLivrosDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(listaLivrosDto);
	}
	
	@GetMapping(value = "/livros/{id}")
	public ResponseEntity<?> buscarLivroId(@PathVariable Long id) {
		Livro livroBuscado = manager.find(Livro.class, id);
		if (livroBuscado == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		LivroBuscadoDto livroBuscadoDto = new LivroBuscadoDto(livroBuscado);
		return ResponseEntity.ok(livroBuscadoDto);
		
	}

}
