package br.com.api.cdc.author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@PersistenceContext
	private EntityManager manager;

	@PostMapping
	@Transactional
	public AuthorResponseDTO saveAuthor(@RequestBody @Valid AuthorRequestDTO authorDto) {

		@Valid Author author = authorDto.toModel();

		manager.persist(author);

		return new AuthorResponseDTO(author);
	}
}
