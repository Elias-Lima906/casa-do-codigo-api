package br.com.api.cdc.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.cdc.dto.in.AuthorFormDTO;
import br.com.api.cdc.dto.out.AuthorResponseDTO;
import br.com.api.cdc.entity.Author;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping
	public AuthorResponseDTO saveAuthor(@RequestBody @Valid AuthorFormDTO authorDto) {

		Author author = authorDto.toModel();

		manager.persist(author);

		return new AuthorResponseDTO(author);
	}
}
