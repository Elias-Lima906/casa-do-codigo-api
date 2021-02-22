package br.com.api.cdc.state;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.api.cdc.country.Country;
import br.com.api.cdc.exception.GlobalException;

@Entity
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false)
	private String name;

	@NotNull
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	@Deprecated
	public State() {
	}
	
	public State(@NotBlank String name, @NotNull Country country) {
		this.name = name;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Country getCountry() {
		return country;
	}
	
	public Long getIdCountry() {
		return country.getId();
	}
	
	public static State findStateById(Long idState, EntityManager manager) throws GlobalException {
		
		List<?> list = queryResult(idState, manager);
		
		if(list.isEmpty()) {
			throw new GlobalException("O Estado não existe no banco de dados pelo id: " + idState + ", por favor passe um id valido!");
		}
		
		return (State) list.get(0);
	}
	
	private static List<?> queryResult(Long idState, EntityManager manager){
		Query query = manager.createQuery("SELECT s FROM State s WHERE s.id = :idState");	
		query.setParameter("idState", idState);
		return query.getResultList();
	}

}
