package exceptions;

public class NoPopulationException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoPopulationException() {
		super("No population.");
	}
}
