package br.com.api.cdc.state;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
public class StateController {
	
	@PersistenceContext
	EntityManager manager;
	
	@PostMapping
	@Transactional
	public StateResponseDTO saveState(@RequestBody @Valid StateRequestDTO request) {

		@Valid State state = request.toModel(manager);
		manager.persist(state);
		return new StateResponseDTO(state);
	}

}
