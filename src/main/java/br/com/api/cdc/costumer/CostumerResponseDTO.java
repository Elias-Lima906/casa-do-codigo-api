package br.com.api.cdc.costumer;

import br.com.api.cdc.country.Country;

public class CostumerResponseDTO {

	private String name;
	private String lastName;
	private String email;
	private String address;
	private String complement;
	private String city;
	private String phoneNumber;
	private String zipCode;
	private Country country;

	public CostumerResponseDTO(Costumer costumer) {
		this.name = costumer.getName();
		this.lastName = costumer.getLastName();
		this.email = costumer.getEmail();
		this.address = costumer.getAddress();
		this.complement = costumer.getComplement();
		this.city = costumer.getCity();
		this.phoneNumber = costumer.getPhoneNumber();
		this.zipCode = costumer.getZipCode();
		this.country = costumer.getCountry();
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getComplement() {
		return complement;
	}

	public String getCity() {
		return city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public Country getCountry() {
		return country;
	}

}