package br.com.api.cdc.dto.in;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.api.cdc.entity.Author;

public class AuthorFormDTO {

	@NotBlank(message = "O campo nome não pode estar em branco!")
	private String name;

	@NotBlank(message = "O campo email não pode estar em branco!")
	@Email(message = "O campo email deve ser válido!")
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

		@Valid Author author = new Author(this.name, this.email, this.description);

		return author;
	}

}
