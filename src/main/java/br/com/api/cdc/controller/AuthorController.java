package br.com.api.cdc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.cdc.dto.in.AuthorFormDTO;
import br.com.api.cdc.dto.out.AuthorResponseDTO;
import br.com.api.cdc.entity.Author;
import br.com.api.cdc.repository.AuthorRepository;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	AuthorRepository authorRepository;

	@PostMapping
	public AuthorResponseDTO saveAuthor(@RequestBody @Valid AuthorFormDTO authorDto) {

		@Valid Author author = authorDto.toModel();

		authorRepository.save(author);

		System.out.println(author.getName() + author.getDateTimeSignUp());

		AuthorResponseDTO authorResponse = new AuthorResponseDTO(author);

		return authorResponse;
	}
}
