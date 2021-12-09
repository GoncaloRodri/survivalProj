package map;

import java.util.ArrayList;
import java.util.List;

import exceptions.CanNotMoveException;
import item.Item;

public class GameMap {
	
	private int maxX;
	private int maxY;
	
	private int currentX;
	private int currentY;
	
	private int[][] intMap; 
	private List<List<Place>> map;
	
	public GameMap(int maxX,int maxY) {
		intMap = new int[maxX][maxY];
		this.maxX = maxX;
		this.maxY = maxY;
		map = new ArrayList<List<Place>>(maxX);
	}
		
	public void move(int i, int j) throws CanNotMoveException {
		this.currentX = i;
		this.currentY = j;
		
	}

	public void itemDropped(Item item) {
		map.get(currentX).get(currentY).addToPlace(item);
		
	}
	
	

}
