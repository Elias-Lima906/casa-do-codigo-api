package br.com.api.cdc.category;

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
