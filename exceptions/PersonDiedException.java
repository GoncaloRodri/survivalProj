package exceptions;

public class PersonDiedException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "You're dead!!";

	public PersonDiedException() {
		super(MESSAGE);
	}

}
