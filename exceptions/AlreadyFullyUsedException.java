package exceptions;

public class AlreadyFullyUsedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "Consumable fully used!!";

	public AlreadyFullyUsedException() {
		super(MESSAGE);
	}
}
