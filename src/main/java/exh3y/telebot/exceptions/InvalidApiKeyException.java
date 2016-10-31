package exh3y.telebot.exceptions;

public class InvalidApiKeyException extends Exception {

	private static final long serialVersionUID = 2291013950076605675L;

	public InvalidApiKeyException() {
		
	}
	
	public InvalidApiKeyException(String message) {
		
		super(message);
	}
	
}
