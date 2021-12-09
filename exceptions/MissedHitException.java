package exceptions;

public class MissedHitException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "Missed!!";

	public MissedHitException() {
		super(MESSAGE);
	}
	
}
