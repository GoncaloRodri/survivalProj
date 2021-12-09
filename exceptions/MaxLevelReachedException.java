package exceptions;

public class MaxLevelReachedException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Max Level reached!";

	public MaxLevelReachedException() {
		super(MESSAGE);
	}

}
