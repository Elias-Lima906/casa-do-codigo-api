package br.com.api.cdc.state;

import br.com.api.cdc.country.CountryResponseDTO;

public class StateResponseDTO {

	private String name;

	private CountryResponseDTO country;

	public StateResponseDTO(State state) {
		this.name = state.getName();
		this.country = new CountryResponseDTO(state.getCountry());
	}

	public String getName() {
		return name;
	}

	public CountryResponseDTO getCountry() {
		return country;
	}

}
