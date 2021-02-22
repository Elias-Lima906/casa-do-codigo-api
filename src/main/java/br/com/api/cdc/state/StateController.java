package br.com.api.cdc.state;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.cdc.country.Country;

@RestController
@RequestMapping("/states")
public class StateController {
	
	@PersistenceContext
	EntityManager manager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<StateResponseDTO> saveState(@RequestBody @Valid StateRequestDTO request) {

		if(request.checkIfStatesNameExistsInCountry(manager)) {
			return ResponseEntity.badRequest().build();
		}

		@Valid State state = request.toModel(manager);
		manager.persist(state);
		Country.addState(state, manager);
		return ResponseEntity.ok(new StateResponseDTO(state));
	}

}
