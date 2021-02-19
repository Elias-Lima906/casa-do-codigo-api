package br.com.api.cdc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.cdc.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

	Optional<Author> findByEmail(String email);
}
