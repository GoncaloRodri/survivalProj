package backEndGame;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import Creatures.Person;
import Creatures.PersonClass;
import Creatures.PersonOut;
import exceptions.*;

public class DataBaseSystemClass implements DataBaseSystem {

	//population
	
	SortedMap<String ,Person> population;
	
	public DataBaseSystemClass() {
		population = new TreeMap<String, Person>();
	}

	private void giveBasicStarter(String fname){
		Person p = population.get(fname);
		p.receiveItem(new ItemClass);
	}
	
	@Override
	public Iterator<Person> peopleIterator() throws NoPopulationException {
		if(population.isEmpty()) throw new NoPopulationException();
		return  population.values().iterator();
	}

	@Override
	public void addPerson(String firstName, String lastName, int age, String gender) throws NameAlreadyExistsException {
		Person p = new PersonClass(firstName,lastName,age,gender);
		if(hasPerson(p)) throw new NameAlreadyExistsException();
		population.put(firstName, p);
	}

	private boolean hasPerson(Person p) {
		return population.containsValue(p);
	}
	

	@Override
	public void addPerson(String firstName, String lastName, int age, String gender, int health, int stamina, int speed,
			int attack, int defence) {
		
	}

	@Override
	public int getPopSize() {
		return population.size();
	}

	@Override
	public PersonOut getPerson(String fname, String sname) throws PersonNotFoundException {
		if (!population.containsKey(fname)) throw new PersonNotFoundException(fname);
		return population.get(fname);
	}

}
