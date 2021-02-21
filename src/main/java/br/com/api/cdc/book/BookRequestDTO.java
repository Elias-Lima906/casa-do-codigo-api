package br.com.api.cdc.book;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.api.cdc.author.Author;
import br.com.api.cdc.category.Category;
import br.com.api.cdc.generic_validation.ExistsById;
import br.com.api.cdc.generic_validation.UniqueValue;

public class BookRequestDTO {

	@NotBlank(message = "O campo titulo não pode estar em branco!")
	@UniqueValue(domainName = Book.class, fieldName = "title", message = "O titulo já consta na nossa base de dados!")
	private String title;

	@NotBlank(message = "O campo resumo não pode estar em branco!")
	@Size(max = 500)
	private String brief;

	@NotBlank(message = "O campo sumário não pode estar em branco!")
	private String summary;

	@NotNull(message = "O campo preço não pode estar em branco!")
	@Min(20)
	private BigDecimal price;

	@NotNull(message = "O campo número de páginas não pode estar em branco!")
	@Min(100)
	private Integer pageNumber;

	@NotBlank(message = "O campo ISBN não pode estar em branco!")
	@UniqueValue(domainName = Book.class, fieldName = "isbn", message = "O ISBN já consta na nossa base de dados!")
	private String isbn;

	@Future
	@NotNull(message = "O campo data de publicação não pode estar em branco!")
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate pubDate;

	@NotNull(message = "O Id da Categoria não pode ser nulo!")
	@ExistsById(domainName = Category.class, fieldName = "id", message = "Não foi encontrado uma CATEGORIA pelo id inofrmado!")
	private Long idCategory;

	@NotNull(message = "O Id do Autor não pode ser nulo!")
	@ExistsById(domainName = Author.class, fieldName = "id", message = "Não foi encontrado um AUTOR pelo id inofrmado!")
	private Long idAuthor;

	public BookRequestDTO(@NotBlank String title, @NotBlank @Size(max = 500) String brief, String summary,
			@NotNull @Min(20) BigDecimal price, @NotNull @Min(100) Integer pageNumber, @NotBlank String isbn,
			@NotNull Long idCategory, @NotNull Long idAuthor) {
		super();
		this.title = title;
		this.brief = brief;
		this.summary = summary;
		this.price = price;
		this.pageNumber = pageNumber;
		this.isbn = isbn;
		this.idCategory = idCategory;
		this.idAuthor = idAuthor;
	}

	/*
	 * This setter is present here to provide the Jackson API, a way to be able to
	 * deserialize the date, as it is not working via the constructor parameter.
	 */
	public void setPubDate(LocalDate pubDate) {
		this.pubDate = pubDate;
	}

	public Book toModel(EntityManager manager) {

		Category category = manager.find(Category.class, idCategory);
		Author author = manager.find(Author.class, idAuthor);

		return new Book.BookBuilder()
				.title(this.title)
				.summary(this.summary)
				.brief(this.brief)
				.price(this.price)
				.pageNumber(this.pageNumber)
				.isbn(this.isbn)
				.pubDate(pubDate)
				.category(category)
				.author(author)
				.build();
	}

}