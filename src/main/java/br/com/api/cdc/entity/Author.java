package br.com.api.cdc.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo nome não pode estar em branco!")
	@Column(nullable = false)
	private String name;
	
	@NotBlank(message = "O campo email não pode estar em branco!")
	@Email(message = "O campo email deve ser válido!")
	@Column(nullable = false)
	private String email;
	
	@NotBlank(message = "O campo descrição não pode estar em branco!")
	@Size(max = 400)
	@Column(nullable = false)
	private String description;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime dateTimeSignUp = LocalDateTime.now();

	public Author() {
	}

	public Author(String name, String description, String email) {
		this.name = name;
		this.description = description;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public LocalDateTime getDateTimeSignUp() {
		return dateTimeSignUp;
	}

	public String getEmail() {
		return email;
	}

}
