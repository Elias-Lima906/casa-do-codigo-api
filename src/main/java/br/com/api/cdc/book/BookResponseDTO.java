package br.com.api.cdc.book;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookResponseDTO {

	private String title;

	private String brief;

	private String summary;

	private BigDecimal price;

	private Integer pageNumber;

	private String isbn;

	private LocalDate pubDate;

	private String categoryName;

	private String authorName;

	public BookResponseDTO(Book book) {
		super();
		this.title = book.getTitle();
		this.brief = book.getBrief();
		this.summary = book.getSummary();
		this.price = book.getPrice();
		this.pageNumber = book.getPageNumber();
		this.isbn = book.getIsbn();
		this.pubDate = book.getPubDate();
		this.categoryName = book.getCategoryName();
		this.authorName = book.getAuthorName();
	}

	public String getTitle() {
		return title;
	}

	public String getBrief() {
		return brief;
	}

	public String getSummary() {
		return summary;
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

	public String getCategoryName() {
		return categoryName;
	}

	public String getAuthorName() {
		return authorName;
	}

}
