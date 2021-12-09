package exceptions;

public class NotAbleToUpgradeException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Not able to upgrade!";

	public NotAbleToUpgradeException() {
		super(MESSAGE);
	}
}
