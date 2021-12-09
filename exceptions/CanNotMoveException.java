package exceptions;

public class CanNotMoveException extends Exception {


	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "Enable to move !!";

	public CanNotMoveException() {
		super(MESSAGE);
	}
}
