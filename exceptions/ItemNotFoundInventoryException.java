package exceptions;

public class ItemNotFoundInventoryException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static final String ITEM = "Item ";
	
	private static final String MESSAGE = " not found in the inventory !";

	public ItemNotFoundInventoryException(String itemName) {
		super(toString(itemName));
	}
	
	private static String toString(String itemName) {
		return ITEM + itemName + MESSAGE;
	}
}
