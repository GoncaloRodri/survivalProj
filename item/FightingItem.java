package item;

import exceptions.BrokenItemException;
import exceptions.MissedHitException;

public interface FightingItem extends Item {
	
	double hit() throws MissedHitException, BrokenItemException;

	/**Devolve a durabilidade atual da arma.
	 * @return durabilidade atual
	 */
	double getDurability();

	/** Devolve o dano da arma.
	 * @return dano
	 */
	double getDamage();

	/** Devolve o alcance da arma.
	 * @return alcance
	 */
	double getRange();

	/** Devolve a durabilidade maxima da arma
	 * @return durabilidade maxima
	 */
	double getMaxDurability();
	
}
