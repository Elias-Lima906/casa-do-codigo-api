package br.com.api.cdc.book;

import java.math.BigDecimal;

import br.com.api.cdc.author.AuthorResponseDTO;

public class BookResponsePageDetailDTO {

	private String title;

	private String brief;

	private String summary;

	private BigDecimal price;

	private Integer pageNumber;

	private String isbn;

	private AuthorResponseDTO author;

	public BookResponsePageDetailDTO(Book book) {
		this.title = book.getTitle();
		this.brief = book.getBrief();
		this.summary = book.getSummary();
		this.price = book.getPrice();
		this.pageNumber = book.getPageNumber();
		this.isbn = book.getIsbn();
		this.author = new AuthorResponseDTO(book.getAuthor());
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

	public AuthorResponseDTO getAuthor() {
		return author;
	}

}
