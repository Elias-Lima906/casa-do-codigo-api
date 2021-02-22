package br.com.api.cdc.author;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String name;
	
	@NotBlank @Size(max = 400)
	@Column(nullable = false, length = 400)
	private String description;

	@NotBlank
	@Column(nullable = false,  unique = true)
	private String email;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime dateTimeSignUp = LocalDateTime.now();
	
	public Author() {
	}

	public Author(@NotBlank String name, @NotBlank @Size(max = 400) String description, @NotBlank String email) {
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
