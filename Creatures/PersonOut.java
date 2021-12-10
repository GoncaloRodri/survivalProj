package Creatures;
import enums.Status;
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

	int getHealthLvl();

	int getStamminaLvl();

	int getAttackLvl();

	int getDefenceLvl();

	int getSpeedLvl();
	
	FightingItem getFigthWeapon();
	
	MiningItem getMiningWeapon();

    Status getStatus();
	
	
}
