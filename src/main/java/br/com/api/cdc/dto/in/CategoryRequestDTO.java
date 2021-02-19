package br.com.api.cdc.dto.in;

import javax.validation.constraints.NotBlank;

import br.com.api.cdc.entity.Category;
import br.com.api.validation.anotation.UniqueValue;

public class CategoryRequestDTO {

	@NotBlank(message = "O campo nome não pode estar vazio!")
	@UniqueValue(domainName = Category.class, fieldName = "name", message = "Já existe um campo nome na nossa base de dados!")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category toModel() {
		return new Category(this.name);
	}

}
