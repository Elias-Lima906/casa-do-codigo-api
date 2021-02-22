package br.com.api.cdc.country;

public class CountryResponseDTO {

	private String name;

	public CountryResponseDTO(Country country) {
		this.name = country.getName();
	}

	public String getName() {
		return name;
	}

}
