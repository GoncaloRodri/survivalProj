package backEndGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Creatures.Person;
import Creatures.PersonClass;
import exceptions.*;

public class DataBaseSystemClass implements DataBaseSystem {

	//population
	List<Person> popList;
	
	public DataBaseSystemClass() {
		popList = new ArrayList<Person>();
	}
	
	@Override
	public Iterator<Person> peopleIterator() throws NoPopulationException {
		if(popList.isEmpty()) throw new NoPopulationException();
		return  popList.iterator();
	}

	@Override
	public void addPerson(String firstName, String lastName, int age, String gender) throws NameAlreadyExistsException {
		Person p = new PersonClass(firstName,lastName,age,gender);
		if(hasPerson(p)) throw new NameAlreadyExistsException();
		popList.add(p);
	}

	private boolean hasPerson(Person p) {
		return popList.contains(p);
	}
	

	@Override
	public void addPerson(String firstName, String lastName, int age, String gender, int health, int stamina, int speed,
			int attack, int defence) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPopSize() {
		return popList.size();
	}

}
