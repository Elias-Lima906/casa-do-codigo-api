package br.com.api.cdc.author;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuthorResponseDTO {

	private String name;
	private String email;
	private String description;
	private String dateTimeSignUp;

	public AuthorResponseDTO() {

	}

	public AuthorResponseDTO(Author author) {
		this.name = author.getName();
		this.email = author.getEmail();
		this.description = author.getDescription();
		this.dateTimeSignUp = this.convertToString(author.getDateTimeSignUp());
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getDateTimeSignUp() {
		return dateTimeSignUp;
	}

	public String getEmail() {
		return email;
	}

	private String convertToString(LocalDateTime dateTimeSignUp) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

		String formatDateTime = dateTimeSignUp.format(formatter);

		return formatDateTime;
	}

}
