package exceptions;

public class NotEnoughStaminaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "Not enough stamina !!";

	public NotEnoughStaminaException() {
		super(MESSAGE);
	}

}
