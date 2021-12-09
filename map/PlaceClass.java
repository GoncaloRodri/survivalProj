package map;

import java.util.ArrayList;
import java.util.List;

import item.Item;

public class PlaceClass implements Place {

	protected boolean crossable;
	protected boolean constructable;
	protected boolean swimmable;
	protected boolean harvestable;
	
	private List<Item> itemsFloor;
	
	
	public PlaceClass() {
		crossable = true;
		constructable = true;
		swimmable = false;
		harvestable = false;
		itemsFloor = new ArrayList<Item>();
	}

	@Override
	public void addToPlace(Item item) {
		itemsFloor.add(item);
		
	}

}
