package backEndGame;

import java.util.Iterator;

import Creatures.Person;
import Creatures.PersonOut;
import exceptions.NameAlreadyExistsException;
import exceptions.NoPopulationException;
import exceptions.PersonNotFoundException;

public interface DataBaseSystem {

	void addPerson(String firstName, String lastName, int age, String gender) throws NameAlreadyExistsException;

	void addPerson(String firstName, String lastName, int age, String gender, int health, int stamina,
	int speed, int attack, int defence) throws NameAlreadyExistsException;
	
	int getPopSize();
	
	Iterator<Person> peopleIterator() throws NoPopulationException;

    PersonOut getPerson(String fname, String sname) throws PersonNotFoundException;

}
