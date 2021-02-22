package br.com.api.cdc.country;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.api.cdc.state.State;

@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false, unique = true)
	private String name;

	@JsonManagedReference
	@OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
	private List<State> states = Arrays.asList();

	@Deprecated
	public Country() {
	}

	public Country(@NotBlank String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public static void addState(@Valid State state, EntityManager manager) {

		Country country = manager.find(Country.class, state.getIdCountry());

		country.setStates(Arrays.asList(state));
	}

	public static List<Country> findAllCountries(EntityManager manager) {
		Query query = manager.createQuery("SELECT c FROM Country c");
		return query.getResultList();
	}

}
