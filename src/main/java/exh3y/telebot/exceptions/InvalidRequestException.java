package exh3y.telebot.exceptions;

public class InvalidRequestException extends Exception {

	private static final long serialVersionUID = 8467133742599156579L;

	public InvalidRequestException() {
		// Nothing to do here
	}

	public InvalidRequestException(String message) {

		super(message);
	}

}
