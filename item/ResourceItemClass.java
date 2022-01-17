package item;

import enums.RarityEnum;
import exceptions.NotAbleToUpgradeException;

private int size;

public class ResourceItemClass extends ItemAbs implements ResourceItem  {

    public ResourceItemClass(String name, RarityEnum rarity, boolean crafted) {
        super(name, rarity, crafted);
        //TODO Auto-generated constructor stub
    }

    @Override
    public int size() {
        return this.size();
    }

    @Override
    public void reStock(int stockToAdd) {
        size += stockToAdd;
        
    }

    @Override
    public void upgradeRarity() throws NotAbleToUpgradeException {
        // TODO Auto-generated method stub
        
    }
    
}
