package exceptions;

public class InventoryFullException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "Inventory is full !!";

	public InventoryFullException() {
		super(MESSAGE);
	}

}
