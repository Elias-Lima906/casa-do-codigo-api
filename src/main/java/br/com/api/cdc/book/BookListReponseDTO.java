package br.com.api.cdc.book;

public class BookListReponseDTO {

	private Long id;
	private String title;

	public BookListReponseDTO(Book book) {
		this.id = book.getId();
		this.title = book.getTitle();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

}
