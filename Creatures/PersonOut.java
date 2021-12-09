package Creatures;
import item.FightingItem;
import item.MiningItem;

public interface PersonOut {

	String getFirstName();
	
	String getLastName();
	
	int getAge();
	
	String getGender();
	
	int getLevel();
	
	double getTotalExp();
	
	double getCurrentHealth();
	
	int getAttack();
	
	int getDefence();
	
	double getCurrentStamina();
	
	int getSpeed();
	
	int getMaxHealth();
	
	int getMaxStamina();
	
	FightingItem getFigthWeapon();
	
	MiningItem getMiningWeapon();
	
	
}
