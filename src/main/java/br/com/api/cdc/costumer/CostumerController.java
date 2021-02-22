package br.com.api.cdc.costumer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.cdc.exception.GlobalException;

@RestController
@RequestMapping("/costumers")
public class CostumerController {

	@PersistenceContext
	EntityManager manager;

	@PostMapping
	@Transactional
	public CostumerResponseDTO postMethodName(@RequestBody @Valid CostumerRequestDTO request) throws GlobalException {

		@Valid Costumer costumer = request.toModel(manager);

		manager.persist(costumer);

		return new CostumerResponseDTO(costumer);
	}

}
