package br.com.api.cdc.country;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {

	@PersistenceContext
	EntityManager manager;

	@PostMapping
	@Transactional
	public CountryResponseDTO postMethodName(@RequestBody @Valid CountryRequestDTO request) {

		@Valid
		Country country = new Country(request.getName());
		manager.persist(country);
		return new CountryResponseDTO(country);
	}

	@GetMapping
	public List<Country> findAllCountries() {

		return Country.findAllCountries(manager);

	}

}
