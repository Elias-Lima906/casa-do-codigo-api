package br.com.api.cdc.state;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.api.cdc.country.Country;

@Entity
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false)
	private String name;

	@NotNull
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	@Deprecated
	public State() {
	}
	
	public State(@NotBlank String name, @NotNull Country country) {
		this.name = name;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Country getCountry() {
		return country;
	}
	
	public Long getIdCountry() {
		return country.getId();
	}

}
