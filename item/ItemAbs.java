package item;

import enums.RarityEnum;
import exceptions.NotAbleToUpgradeException;

public abstract class ItemAbs implements Item {

	private boolean crafted;
	private String name;
	protected RarityEnum rarity;
	
	public ItemAbs(String name,RarityEnum rarity,boolean crafted) {
		this.crafted = crafted;
		this.name = name;
		this.rarity = rarity;
	}

	public String getName() {
		return name;
	}

	public RarityEnum getRarity() {
		return rarity;
	}
	
	public boolean isCrafted() {
		return crafted;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void upgradeRarity() throws NotAbleToUpgradeException;
	
	
//	public void upgradeRarity() {
//		switch(rarity) {
//		case Common: rarity = RarityEnum.Uncommon; break;
//		case Uncommon: rarity = RarityEnum.Rare; break;
//		case Rare: rarity = RarityEnum.Superrare; break;
//		case Superrare : rarity = RarityEnum.Mith; break;
//		default:
//			break;
//		}
//	}
	
	
}
