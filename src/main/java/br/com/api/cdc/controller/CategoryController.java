package br.com.api.cdc.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.cdc.dto.in.CategoryRequestDTO;
import br.com.api.cdc.dto.out.CategoryResponseDTO;
import br.com.api.cdc.entity.Category;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping()
	@Transactional
	public CategoryResponseDTO postMethodName(@RequestBody @Valid CategoryRequestDTO categoryRequest) {
		
		Category category = categoryRequest.toModel();
		
		manager.persist(category);
		 
		return new CategoryResponseDTO(category);
	}

}
