package item;

import enums.RarityEnum;
import exceptions.BrokenItemException;
import exceptions.MissedHitException;
import exceptions.NotAbleToUpgradeException;

public class FightingItemClass extends ItemAbs implements FightingItem {

	
	//RATIOs TO MAKE THE EASIER TO CHANGE
	private final static double UNCOMMON_DUR_RATIO = 1.25;
	private final static double RARE_DUR_RATIO = 1.15;
	private final static double SUPERRARE_DUR_RATIO = 1.10;
	
	private final static double UNCOMMON_DMG_RATIO = 1.075;
	private final static double RARE_DMG_RATIO = 1.15;
	private final static double SUPERRARE_DMG_RATIO = 1.30;
	private final static double MITH_DMG_RATIO = 2;
	
	//VARIAVEIS
	private double durability;
	private double damage;
	private double range;
	private double maxDurability;
	private int critRate;
	
	
	public FightingItemClass(String name, RarityEnum rarity, boolean crafted, double durability,
			double range, double damage) {
		super(name,rarity,crafted);
		this.durability = durability;
		this.maxDurability = durability;
		this.range = range;
		this.damage = damage;
		setCritRate(rarity);
	}
	
	private void setCritRate(RarityEnum rarity) {
		switch(rarity) {
		case Common:
			critRate = 60;
			break;
		case Uncommon:
			critRate = 50;
			break;
		case Rare:
			critRate = 40;
			break;
		case Superrare:
			critRate = 30;
			break;
		case Mith:
			critRate = 17;
		default:
			break;
		
		}
	}

	@Override
	public double hit() throws MissedHitException, BrokenItemException {
		durability = durability - maxDurability*(0.05);
		if( maxDurability != 0 && durability >= 0) {
			throw new BrokenItemException();
		} else if (((int) Math.random()*100) == 1) {
			throw new MissedHitException();
		} else if(((int) Math.random()*critRate) == 10) {
			return damage*1.5; //crit
		} else 
			return damage;
	}
	
	@Override
	public double getDurability() {
		return durability;
	}
	
	@Override
	public double getDamage() {
		return damage;
	}
	
	@Override
	public double getRange() {
		return range;
	}
	
	@Override
	public double getMaxDurability() {
		return maxDurability;
	}
	
	@Override
	public void upgradeRarity() throws NotAbleToUpgradeException {
		switch(rarity) {
		case Common: 
			upgradeCommon();
			break;
		case Uncommon: 
			upgradeUncommon();
			break;
		case Rare: 
			upgradeRare();
			break;
		case Superrare : 
			upgradeSuperRare();
			break;
		default:
			throw new NotAbleToUpgradeException();
		}
		
	}
	
	private void upgradeCommon() {
		this.rarity = RarityEnum.Uncommon;
		maxDurability = maxDurability*(UNCOMMON_DUR_RATIO);
		durability = maxDurability;
		damage = damage*(UNCOMMON_DMG_RATIO);
		setCritRate(rarity);
	}
	
	private void upgradeUncommon() {
		this.rarity = RarityEnum.Rare; 
		maxDurability = maxDurability*(RARE_DUR_RATIO);
		durability = maxDurability;
		damage = damage*(RARE_DMG_RATIO);
		setCritRate(rarity);
	}
	
	private void upgradeRare() {
		this.rarity = RarityEnum.Superrare; 
		maxDurability = maxDurability*(SUPERRARE_DUR_RATIO);
		durability = maxDurability;
		damage = damage*(SUPERRARE_DMG_RATIO);
		setCritRate(rarity);
	}
	
	private void upgradeSuperRare() {
		this.rarity = RarityEnum.Mith; 
		durability = maxDurability;
		damage = damage*(MITH_DMG_RATIO);
		setCritRate(rarity);
	}
}
