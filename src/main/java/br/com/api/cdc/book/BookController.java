package br.com.api.cdc.book;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public BookResponseDTO postMethodName(@RequestBody @Valid BookRequestDTO bookRequest) {
		
		@Valid Book book = bookRequest.toModel(manager);
		
		manager.persist(book);
		
		return new BookResponseDTO(book);
	}
	
	@GetMapping
	public List<BookListReponseDTO> listAll() {
		
		List<Book> books = Book.findAll(manager);
		
		List<BookListReponseDTO> responseBooks = new ArrayList<BookListReponseDTO>();
		
		books.forEach(book -> responseBooks.add(new BookListReponseDTO(book)));
		
		return responseBooks;
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<BookResponsePageDetailDTO> findById(@PathVariable Long id) {
		
		Book book = manager.find(Book.class, id);
		
		if(book == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(new BookResponsePageDetailDTO(book));
	}


}
