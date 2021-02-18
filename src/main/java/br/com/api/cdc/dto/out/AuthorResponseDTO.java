package br.com.api.cdc.dto.out;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.api.cdc.entity.Author;

public class AuthorResponseDTO {

	private String name;
	private String description;
	private String dateTimeSignUp;

	public AuthorResponseDTO() {

	}

	public AuthorResponseDTO(Author author) {
		this.name = author.getName();
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
	
	private String convertToString(LocalDateTime dateTimeSignUp) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		
		String formatDateTime = dateTimeSignUp.format(formatter);
		
		return formatDateTime;
	}
	

}
