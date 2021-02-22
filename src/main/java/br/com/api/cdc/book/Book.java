package br.com.api.cdc.book;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.api.cdc.author.Author;
import br.com.api.cdc.category.Category;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	@NotBlank
	private String title;

	@Column(columnDefinition = "TEXT", nullable = false)
	@NotBlank
	private String summary;

	@Column(nullable = false, length = 500)
	@NotBlank
	private String brief;

	@Column(nullable = false)
	@NotNull
	private BigDecimal price;

	@Column(nullable = false)
	@NotNull
	private Integer pageNumber;

	@Column(nullable = false, unique = true)
	@NotBlank
	private String isbn;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate pubDate;

	@ManyToOne
	private Category category;

	@ManyToOne
	private Author author;

	@Deprecated
	public Book() {
	}

	private Book(String title, String summary, String brief, BigDecimal price, Integer pageNumber, String isbn,
			LocalDate pubDate, Category category, Author author) {
		super();
		this.title = title;
		this.summary = summary;
		this.brief = brief;
		this.price = price;
		this.pageNumber = pageNumber;
		this.isbn = isbn;
		this.pubDate = pubDate;
		this.category = category;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getSummary() {
		return summary;
	}

	public String getBrief() {
		return brief;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getPubDate() {
		return pubDate;
	}
	
	public Author getAuthor() {
		return this.author;
	}
	
	public String getCategoryName() {
		return category.getName();
	}
	
	public String getAuthorName() {
		return author.getName();
	}
	
	public static List<Book> findAll(EntityManager manager) {
		Query query = manager.createQuery("SELECT b FROM Book b");
		return query.getResultList();
	}

	
	public static class BookBuilder {

		private String title;
		private String summary;
		private String brief;
		private BigDecimal price;
		private Integer pageNumber;
		private String isbn;
		private LocalDate pubDate;
		private Category category;
		private Author author;

		public BookBuilder title(String title) {
			this.title = title;
			return this;
		}

		public BookBuilder summary(String summary) {
			this.summary = summary;
			return this;
		}

		public BookBuilder brief(String brief) {
			this.brief = brief;
			return this;
		}

		public BookBuilder price(BigDecimal price) {
			this.price = price;
			return this;
		}

		public BookBuilder pageNumber(Integer pageNumber) {
			this.pageNumber = pageNumber;
			return this;
		}

		public BookBuilder isbn(String isbn) {
			this.isbn = isbn;
			return this;
		}

		public BookBuilder pubDate(LocalDate pubDate) {
			this.pubDate = pubDate;
			return this;
		}

		public BookBuilder category(Category category) {
			this.category = category;
			return this;
		}

		public BookBuilder author(Author author) {
			this.author = author;
			return this;
		}

		public Book build() {
			return new Book(title, summary, brief, price, pageNumber, isbn, pubDate, category, author);
		}
	}

}
