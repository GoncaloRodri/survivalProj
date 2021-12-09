package exceptions;

public class BrokenItemException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "This item is broke";

	public BrokenItemException() {
		super(MESSAGE);
	}

}
