package br.com.api.cdc.dto.out;

import br.com.api.cdc.entity.Category;

public class CategoryResponseDTO {

	private String name;

	public CategoryResponseDTO(Category category) {
		super();
		this.name = category.getName();
	}

	public String getName() {
		return name;
	}

}
