package br.com.api.cdc.exception;

public class ErrorDTO {

	private String message;

	public ErrorDTO(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
