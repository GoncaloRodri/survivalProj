package Creatures;

import java.util.List;

import enums.RarityEnum;
import enums.Status;
import exceptions.BrokenItemException;
import exceptions.CanNotMoveException;
import exceptions.InventoryFullException;
import exceptions.ItemNotFoundInventoryException;
import exceptions.MaxLevelReachedException;
import exceptions.MissedHitException;
import exceptions.NotEnoughStaminaException;
import exceptions.PersonDiedException;
import item.FightingItem;
import item.FightingItemClass;
import item.Item;
import item.MiningItem;
import item.MiningItemClass;
import map.GameMap;
import map.Place;

public class PersonClass implements Person {

	private static final String HAND = "Hand";

	private static final int MAXLVL = 20;

	private static final int INV_SIZE = 30;

	// data
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private int level;
	private boolean dead; // pode ter que ser definido no construtor
	private double exp;
	private FightingItem fightWeapon;
	private MiningItem mineWeapon;
	private double currentHealth; // por defininr
	private double currentStamina; // por definir
	private Status status;
	

	private List<Item> inventory; // por trabalhar

	private GameMap place;

	// status

	// min 1 and max 1000
	private int maxHealth;
	private int maxStamina;

	// min 1 and max 100
	private int speed;
	private int defence;
	private int attack;

	// levels

	private int healthLvl;
	private int staminaLvl;
	private int speedLvl;
	private int defenceLvl;
	private int attackLvl;

	// Gera habilidades aleatorias
	public PersonClass(String firstName, String lastName, int age, String gender) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.status = Status.Wandering;
		exp = 0;
		level = 0;

		giveRandomAtributes();
		giveHand();
		this.currentHealth = (double) maxHealth;
		this.currentStamina = (double) maxStamina;
		// moveTo(0,0);
	}

	private void giveRandomAtributes() {
		this.maxHealth = (int) (Math.random() + 1) * 500;
		this.maxStamina = (int) (Math.random() + 1) * 500;
		this.attack = (int) Math.random() * 50;
		this.defence = (int) Math.random() * 50;
		this.speed = (int) Math.random() * 50;
	}

	private void giveHand() {
		fightWeapon = new FightingItemClass(HAND, RarityEnum.Common, false, 0, 1, 5);
		mineWeapon = new MiningItemClass(HAND, RarityEnum.Common, false, 2.5, 0);

	}

	public PersonClass(String firstName, String lastName, int age, String gender, int health, int stamina, int speed,
			int attack, int defence) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.maxHealth = health;
		this.maxStamina = stamina;
		this.speed = speed;
		this.defence = defence;
		this.attack = attack;
		exp = 0;
		level = 0;
		giveHand();
	}

	@Override
	public void addHealth(int amount) {
		this.currentHealth += amount;
		if (currentHealth > maxHealth)
			currentHealth = maxHealth;

	}

	@Override
	public void addStamina(int amount) {
		this.currentStamina += amount;
		if (currentStamina > maxStamina)
			currentStamina = maxStamina;

	}

	// General getters

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public double getTotalExp() {
		return exp;
	}

	@Override
	public double getCurrentHealth() {
		return currentHealth;
	}

	@Override
	public Status getStatus() {
		return status;
	}

	@Override
	public int getAttack() {
		return attack;
	}

	@Override
	public int getDefence() {
		return defence;
	}

	@Override
	public double getCurrentStamina() {
		return currentStamina;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public int getMaxHealth() {
		return maxHealth;
	}

	@Override
	public int getMaxStamina() {
		return maxStamina;
	}

	
	@Override
	public int getHealthLvl() {
		return healthLvl;
	}

	@Override
	public int getStamminaLvl() {
		return staminaLvl;
	}

	@Override
	public int getAttackLvl() {
		return attackLvl;
	}

	@Override
	public int getDefenceLvl() {
		return defenceLvl;
	}

	@Override
	public int getSpeedLvl() {
		return speedLvl;
	}

	// lvlUps

	@Override
	public void lvlUpHealth() throws MaxLevelReachedException, PersonDiedException {
		if (dead)
			throw new PersonDiedException();

		if (healthLvl == MAXLVL)
			throw new MaxLevelReachedException();

		healthLvl++;
	}

	@Override
	public void lvlUpSpeed() throws MaxLevelReachedException, PersonDiedException {
		if (dead)
			throw new PersonDiedException();

		if (speedLvl == MAXLVL)
			throw new MaxLevelReachedException();

		speedLvl++;

	}

	@Override
	public void lvlUpStamina() throws MaxLevelReachedException, PersonDiedException {
		if (dead)
			throw new PersonDiedException();

		if (staminaLvl == MAXLVL)
			throw new MaxLevelReachedException();

		staminaLvl++;

	}

	@Override
	public void lvlUpAttack() throws MaxLevelReachedException, PersonDiedException {
		if (dead)
			throw new PersonDiedException();

		if (attackLvl == MAXLVL)
			throw new MaxLevelReachedException();

		attackLvl++;

	}

	@Override
	public void lvlUpDefence() throws MaxLevelReachedException, PersonDiedException {
		if (dead)
			throw new PersonDiedException();

		if (defenceLvl == MAXLVL)
			throw new MaxLevelReachedException();

		defenceLvl++;
	}

	@Override
	public void loseHealth(double amount) throws PersonDiedException {
		if (dead || currentHealth - amount < 0) {
			dead = true;
			throw new PersonDiedException();
		} else {
			currentHealth = -amount;
		}
	}

	@Override
	public void useStamina(double amount) throws NotEnoughStaminaException, PersonDiedException {
		if (dead)
			throw new PersonDiedException();

		if ((currentStamina - amount) < 0)
			throw new NotEnoughStaminaException();

		currentStamina = -amount;
	}

	// Weapons

	@Override
	public FightingItem getFigthWeapon() {
		return fightWeapon;
	}

	@Override
	public MiningItem getMiningWeapon() {
		return mineWeapon;
	}

	@Override
	public void changeFightWeapon(FightingItem weapon) throws InventoryFullException {
		if (inventory.size() == INV_SIZE)
			throw new InventoryFullException();
		inventory.add(fightWeapon);
		this.fightWeapon = weapon;
	}

	@Override
	public void changeMiningWeapon(MiningItem weapon) throws InventoryFullException {
		if (inventory.size() == INV_SIZE)
			throw new InventoryFullException();
		inventory.add(mineWeapon);
		this.mineWeapon = weapon;
	}

	@Override
	public void changeFightWeapon(FightingItem weapon, int inventoryIndex) throws InventoryFullException {
		if (inventory.size() == INV_SIZE)
			throw new InventoryFullException();
		inventory.add(inventoryIndex, fightWeapon);
		this.fightWeapon = weapon;
	}

	@Override
	public void changeMiningWeapon(MiningItem weapon, int inventoryIndex) throws InventoryFullException {
		if (inventory.size() == INV_SIZE)
			throw new InventoryFullException();
		inventory.add(inventoryIndex, mineWeapon);
		this.mineWeapon = weapon;
	}

	// Actions

	@Override
	public void dropItem(Item item) throws ItemNotFoundInventoryException {
		int i = inventory.indexOf(item);
		if (i == -1)
			throw new ItemNotFoundInventoryException(item.getName());
		inventory.remove(inventory.indexOf(item));
		place.itemDropped(item);
	}

	@Override
	public void harvestItem(Item item) throws InventoryFullException {
		if (inventory.size() == INV_SIZE)
			throw new InventoryFullException();
		inventory.add(item);

		// possivel retirar um objeto do chao, mas para melhor flexibilidade, tambem e
		// possivel fazer mais acima para casos que nao esteja no chao

	}

	@Override
	public void moveTo(int i, int j) throws CanNotMoveException {
		place.move(i, j);
	}

	@Override
	public double hit() throws MissedHitException, BrokenItemException {
		return fightWeapon.hit();
	}

	@Override
	public double harvest() throws BrokenItemException {
		return mineWeapon.mine();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PersonClass)) {
			return false;
		}
		PersonClass other = (PersonClass) obj;
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		return true;
	}

}
