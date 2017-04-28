package exh3y.telebot.exceptions;

public class InvalidApiKeyException extends Exception {

	private static final long serialVersionUID = 2291013950076605675L;

	public InvalidApiKeyException() {
		// Nothing to do here
	}

	public InvalidApiKeyException(String message) {

		super(message);
	}

}
