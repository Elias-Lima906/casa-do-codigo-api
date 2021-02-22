package br.com.api.cdc.state;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import br.com.api.cdc.country.Country;
import br.com.api.cdc.generic_validation.ExistsById;
import br.com.api.cdc.generic_validation.UniqueValue;

public class StateRequestDTO {

	@NotBlank(message = "O campo nome não pode estar vazio!")
	@UniqueValue(domainName = State.class, fieldName = "name", message = "Já existe uma cidade com este nomena base de dados!")
	private String name;

	@ExistsById(domainName = Country.class, fieldName = "id", message = "Id inexistente! O estado precisa obrigatoriamente de um país exiestente para ser salvo!")
	private Long idCountry;

	public StateRequestDTO(@NotBlank String name, Long idCountry) {
		this.name = name;
		this.idCountry = idCountry;
	}

	public State toModel(EntityManager manager) {

		@Valid
		Country country = manager.find(Country.class, idCountry);

		return new State(name, country);
	}
}
