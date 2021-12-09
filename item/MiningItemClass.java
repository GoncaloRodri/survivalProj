package item;

import java.time.LocalDateTime;

import enums.RarityEnum;
import exceptions.BrokenItemException;
import exceptions.NotAbleToUpgradeException;

public class MiningItemClass extends ItemAbs implements MiningItem {

	private final static double UNCOMMON_DUR_RATIO = 1.25;
	private final static double RARE_DUR_RATIO = 1.15;
	private final static double SUPERRARE_DUR_RATIO = 1.10;
	
	private static final double UNCOMMON_SPD_RATIO = 0.10;
	private static final double RARE_SPD_RATIO = 0.13;
	private static final double SUPERRARE_SPD_RATIO = 0.25;
	private static final double MITH_SPD_RATIO = 0.50;
	
	
	private double speed;
	private double durability;
	private double maxDurability;

	public MiningItemClass(String name, RarityEnum rarity, boolean crafted, double speed, double durability) {
		super(name, rarity, crafted);
		this.speed = speed;
		this.durability = durability;
		maxDurability = durability;		
	}
	
	public double mine() throws BrokenItemException {
		durability = durability - maxDurability*(0.05);
		if( maxDurability != 0 && durability >= 0) {
			throw new BrokenItemException();
		}
		boolean off = false;
		LocalDateTime start =LocalDateTime.now().plusSeconds((long) this.speed); //speed determina o tempo de espera
		do {
			LocalDateTime finish = LocalDateTime.now();
			if(finish.isAfter(start)) { off = true; }
		} while(off);
		//TODO meter o temporizador mais acima se necessario, caso contrario retirar o return se nao for necessario.
		return speed;
	}

	
	public double getSpeed() {
		return speed;
	}

	
	public double getDurability() {
		return durability;
	}
	

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
		rarity = RarityEnum.Uncommon;
		maxDurability = maxDurability * UNCOMMON_DUR_RATIO;
		durability = maxDurability;
		speed = speed * UNCOMMON_SPD_RATIO;
	}
	
	private void upgradeUncommon() {
		rarity = RarityEnum.Rare;
		maxDurability = maxDurability * RARE_DUR_RATIO;
		durability = maxDurability;
		speed = speed * RARE_SPD_RATIO;
	}
	
	private void upgradeRare() {
		rarity = RarityEnum.Superrare;
		maxDurability = maxDurability * SUPERRARE_DUR_RATIO;
		durability = maxDurability;
		speed = speed * SUPERRARE_SPD_RATIO;
	}
	
	private void upgradeSuperRare() {
		rarity = RarityEnum.Mith;
		durability = maxDurability;
		speed = speed * MITH_SPD_RATIO;
	}

}
