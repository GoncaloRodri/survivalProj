package item;

import enums.RarityEnum;
import exceptions.NotAbleToUpgradeException;

public interface Item {

	/** Devolve o nome do item.
	 * @return nome do item
	 */
	String getName();
	
	/** Devolve a raridade do item.
	 * @return raridade do item
	 */
	RarityEnum getRarity();
	
	/** Devolve se o item e craftado.
	 * @return se o item e craftado
	 */
	boolean isCrafted();
	
	/** Muda o nome do item.
	 * @param name
	 */
	void setName(String name);
	
	/**
	 *  Muda a raridade do item.
	 * @throws NotAbleToUpgradeException 
	 */
	abstract void upgradeRarity() throws NotAbleToUpgradeException;
}
