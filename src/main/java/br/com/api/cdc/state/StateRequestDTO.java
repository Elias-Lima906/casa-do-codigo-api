package br.com.api.cdc.state;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import br.com.api.cdc.country.Country;
import br.com.api.cdc.validation.ExistsById;

public class StateRequestDTO {

	@NotBlank(message = "O campo nome não pode estar vazio!")
	private String name;

	@ExistsById(domainName = Country.class, fieldName = "id", message = "Id inexistente! O estado precisa obrigatoriamente de um país exiestente para ser salvo!")
	private Long idCountry;

	public StateRequestDTO(@NotBlank String name, Long idCountry) {
		this.name = name;
		this.idCountry = idCountry;
	}
	
	public boolean checkIfStatesNameExistsInCountry(EntityManager manager) {
		
		Query query = manager.createQuery("SELECT s FROM State s WHERE s.name = :name AND s.country.id = :idCountry");
	
		query.setParameter("name", name);
		query.setParameter("idCountry", idCountry);
		
		List<?> list = query.getResultList();
		
		return !list.isEmpty();
	}

	public State toModel(EntityManager manager) {

		@Valid Country country = manager.find(Country.class, idCountry);

		return new State(name, country);
	}
}
