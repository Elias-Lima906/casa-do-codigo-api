package br.com.api.validation.anotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.api.validation.validator.EmailValidation;

@Documented
@Constraint(validatedBy = EmailValidation.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {

	String message() default "{br.com.api.validation.anotation.UniqueEmail}";
	
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default { };
}
