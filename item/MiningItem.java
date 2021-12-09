package item;

import exceptions.BrokenItemException;

public interface MiningItem extends Item {

	double mine() throws BrokenItemException;
	
	double getSpeed();
	
	double getDurability();
	
	double getMaxDurability();
}
