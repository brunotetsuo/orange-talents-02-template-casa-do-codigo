package com.casadocodigo.casadocodigo.novoautor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
public class AutorControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@PersistenceContext
	private EntityManager manager;

	@Test
	@DisplayName("Deve criar um novo autor e deve retornar status 200")
	void deveCriarUmNovoAutor() throws Exception {
		// String json =
		// "{\"nome\":\"Bruno\",\"email\":\"bruno@email.com\",\"descricao\":\"blablablablabla\"}";

		AutorDto autorDto = new AutorDto("Bruno", "bruno@email.com", "blablablablabla");
		mockMvc.perform(post("/autores").contentType(MediaType.APPLICATION_JSON)
				.content(toJson(autorDto))).andExpect(status().isOk());

		List<Autor> autores = manager.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();

		assertTrue(autores.size() == 1);

		Autor autor = autores.get(0);

		assertEquals("bruno@email.com", autor.getEmail());

	}

	private String toJson(AutorDto autorDto) throws JsonProcessingException {
		return objectMapper.writeValueAsString(autorDto);
	}

}
