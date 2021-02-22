package br.com.api.cdc.country;

import javax.validation.constraints.NotBlank;

import br.com.api.cdc.generic_validation.UniqueValue;

public class CountryRequestDTO {

	@NotBlank(message = "O campo nome não pode estar vazio!")
	@UniqueValue(domainName = Country.class, fieldName = "name", message = "Este País já consta na nossa base de dados!")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
