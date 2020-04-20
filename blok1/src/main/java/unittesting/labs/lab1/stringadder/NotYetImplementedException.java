package unittesting.labs.lab1.stringadder;

public class NotYetImplementedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotYetImplementedException(String message) {
		super(message);
	}

	public NotYetImplementedException(String message, Exception cause) {
		super(message,cause);
	}

}

