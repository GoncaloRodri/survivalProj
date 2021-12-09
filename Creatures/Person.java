package Creatures;

import exceptions.BrokenItemException;
import exceptions.CanNotMoveException;
import exceptions.InventoryFullException;
import exceptions.ItemNotFoundInventoryException;
import exceptions.MaxLevelReachedException;
import exceptions.MissedHitException;
import exceptions.NotEnoughStaminaException;
import exceptions.PersonDiedException;
import item.FightingItem;
import item.Item;
import item.MiningItem;

public interface Person extends PersonOut{

	void addHealth(int amount);

	void lvlUpHealth() throws MaxLevelReachedException, PersonDiedException;

	void lvlUpSpeed() throws MaxLevelReachedException, PersonDiedException;

	void addStamina(int amount);

	void lvlUpStamina() throws MaxLevelReachedException, PersonDiedException;

	void lvlUpAttack() throws MaxLevelReachedException, PersonDiedException;

	void lvlUpDefence() throws MaxLevelReachedException, PersonDiedException;

	void loseHealth(double amount) throws PersonDiedException;

	void useStamina(double amount) throws NotEnoughStaminaException, PersonDiedException;

	void changeFightWeapon(FightingItem weapon) throws InventoryFullException;

	void changeFightWeapon(FightingItem weapon, int inventoryIndex) throws InventoryFullException;

	void changeMiningWeapon(MiningItem weapon) throws InventoryFullException;

	void changeMiningWeapon(MiningItem weapon, int inventoryIndex) throws InventoryFullException;

	void dropItem(Item item) throws ItemNotFoundInventoryException;

	void harvestItem(Item item) throws InventoryFullException;

	void moveTo(int x, int y) throws CanNotMoveException;

	double hit() throws /* NoTargetException, */ MissedHitException, BrokenItemException; // <-- devolve o dano dado

	double harvest() throws BrokenItemException; // <-- devolve o tempo/velocidade da acao

}
