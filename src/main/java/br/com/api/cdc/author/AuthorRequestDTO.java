package br.com.api.cdc.author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.api.cdc.generic_validation.UniqueValue;

public class AuthorRequestDTO {

	@NotBlank(message = "O campo nome não pode estar em branco!")
	private String name;

	@NotBlank(message = "O campo email não pode estar em branco!")
	@Email(message = "O campo email deve ser válido!")
	@UniqueValue(domainName = Author.class, fieldName = "email", message = "O email já consta na nossa base de dados!")
	private String email;

	@NotBlank(message = "O campo descrição não pode estar em branco!")
	@Size(max = 400)
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Author toModel() {

		return new Author(this.name, this.description, this.email);
	}

}
