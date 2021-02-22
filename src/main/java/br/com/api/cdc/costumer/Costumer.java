package br.com.api.cdc.costumer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.api.cdc.country.Country;
import br.com.api.cdc.state.State;

@Entity
public class Costumer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Email
	@Column(nullable = false, unique = true)
	private String email;

	@NotBlank
	@Column(nullable = false)
	private String name;

	@NotBlank
	@Column(nullable = false)
	private String lastName;

	@NotBlank
	@Column(nullable = false, unique = true)
	private String document;

	@NotBlank
	@Column(nullable = false)
	private String address;

	@NotBlank
	@Column(nullable = false)
	private String complement;

	@NotBlank
	@Column(nullable = false)
	private String city;

	@NotBlank
	@Column(nullable = false)
	private String phoneNumber;

	@NotBlank
	@Column(nullable = false)
	private String zipCode;

	@NotNull
	@OneToOne
	private Country country;

	@OneToOne
	private State state;

	@Deprecated
	public Costumer() {
	}

	private Costumer(@NotBlank String email, @NotBlank @Email String name, @NotBlank String lastName,
			@NotBlank String document, @NotBlank String address, @NotBlank String complement, @NotBlank String city,
			@NotBlank String phoneNumber, @NotBlank String zipCode, @NotNull Country country, @NotNull State state) {
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.document = document;
		this.address = address;
		this.complement = complement;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.zipCode = zipCode;
		this.country = country;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDocument() {
		return document;
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

	public State getState() {
		return state;
	}

	public static class CoustumerBuilder {

		private String name;
		private String lastName;
		private String email;
		private String document;
		private String address;
		private String complement;
		private String city;
		private String phoneNumber;
		private String zipCode;
		private Country country;
		private State state;

		public CoustumerBuilder name(String name) {
			this.name = name;
			return this;
		}

		public CoustumerBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public CoustumerBuilder email(String email) {
			this.email = email;
			return this;
		}

		public CoustumerBuilder document(String document) {
			this.document = document;
			return this;
		}

		public CoustumerBuilder address(String address) {
			this.address = address;
			return this;
		}

		public CoustumerBuilder complement(String complement) {
			this.complement = complement;
			return this;
		}

		public CoustumerBuilder city(String city) {
			this.city = city;
			return this;
		}

		public CoustumerBuilder phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public CoustumerBuilder zipCode(String zipCode) {
			this.zipCode = zipCode;
			return this;
		}

		public CoustumerBuilder state(State state) {
			this.state = state;
			return this;
		}

		public CoustumerBuilder country(Country country) {
			this.country = country;
			return this;
		}

		public Costumer build() {
			return new Costumer(email, name, lastName, document, address, complement, city, phoneNumber, zipCode,
					country, state);
		}
	}

}
