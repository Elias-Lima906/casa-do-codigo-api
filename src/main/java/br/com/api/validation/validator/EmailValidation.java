package br.com.api.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.api.cdc.repository.AuthorRepository;
import br.com.api.validation.anotation.UniqueEmail;

public class EmailValidation implements ConstraintValidator<UniqueEmail, String> {

	@Autowired
	private AuthorRepository authorRepository;

	public EmailValidation() {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !authorRepository.findByEmail(value).isPresent();
	}

}
