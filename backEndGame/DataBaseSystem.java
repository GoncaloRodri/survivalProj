package backEndGame;

import java.util.Iterator;

import Creatures.Person;
import exceptions.NameAlreadyExistsException;
import exceptions.NoPopulationException;

public interface DataBaseSystem {

	void addPerson(String firstName, String lastName, int age, String gender) throws NameAlreadyExistsException;

	void addPerson(String firstName, String lastName, int age, String gender, int health, int stamina,
	int speed, int attack, int defence) throws NameAlreadyExistsException;
	
	int getPopSize();
	
	Iterator<Person> peopleIterator() throws NoPopulationException;

}
