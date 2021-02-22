package br.com.api.cdc.costumer;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.api.cdc.country.Country;
import br.com.api.cdc.exception.GlobalException;
import br.com.api.cdc.state.State;
import br.com.api.cdc.validation.CPFCNPJValidator;
import br.com.api.cdc.validation.ExistsById;
import br.com.api.cdc.validation.UniqueValue;

public class CostumerRequestDTO {

	@NotBlank(message = "O campo nome não pode estar vazio!")
	private String name;

	@NotBlank(message = "O campo sobrenome não pode estar vazio!")
	private String lastName;

	@NotBlank(message = "O campo email não pode estar vazio!")
	@Email(message = "O campo email deve estar num formato valido!")
	@UniqueValue(domainName = Costumer.class, fieldName = "email", message = "O email informado no cadastro já consta na nossa base de dados!")
	private String email;

	@NotBlank(message = "O campo documento não pode estar vazio!")
	@UniqueValue(domainName = Costumer.class, fieldName = "document", message = "O documento informado no cadastro já consta na nossa base de dados!")
	@CPFCNPJValidator(message = "O CPF ou CNPJ informado não existe ou está errado!")
	private String document;

	@NotBlank(message = "O campo endereço não pode estar vazio!")
	private String address;

	@NotBlank(message = "O campo complemento não pode estar vazio!")
	private String complement;

	@NotBlank(message = "O campo cidade não pode estar vazio!")
	private String city;

	@NotBlank(message = "O campo telefone não pode estar vazio!")
	private String phoneNumber;

	@NotBlank(message = "O campo cep não pode estar vazio!")
	private String zipCode;

	@NotNull(message = "O campo id do país não pode estar vazio!")
	@ExistsById(domainName = Country.class, fieldName = "id", message = "Não foi encontrado país com o id informado!")
	private Long idCountry;

	private Long idState;

	public CostumerRequestDTO(@NotBlank String name, @NotBlank String lastName, @NotBlank String email,
			@NotBlank String document, @NotBlank String address, @NotBlank String complement, @NotBlank String city,
			@NotBlank String phoneNumber, @NotBlank String zipCode, @NotNull Long idCountry, Long idState) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.document = document;
		this.address = address;
		this.complement = complement;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.zipCode = zipCode;
		this.idCountry = idCountry;
		this.idState = idState;
	}

	
	public Costumer toModel(EntityManager manager) throws GlobalException {

		Country country = manager.find(Country.class, idCountry);
		State state = null;
		
		if (idState == null && !country.getStates().isEmpty()) {
			throw new GlobalException("O país que você adicionou contem estados, então o estado não pode ser nulo!");
		} else if (idState != null){
			
			state = State.findStateById(idState, manager);
		}


		return new Costumer.CoustumerBuilder()
				.name(this.name)
				.lastName(this.lastName)
				.email(this.email)
				.document(this.document)
				.address(this.address).complement(this.complement)
				.city(this.city)
				.phoneNumber(this.phoneNumber)
				.zipCode(this.zipCode)
				.country(country)
				.state(state)
				.build();
	}

}