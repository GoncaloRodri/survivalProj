package backEndGame;

import java.util.Iterator;
import java.util.Scanner;

import Creatures.Person;
import Creatures.PersonOut;
import exceptions.NameAlreadyExistsException;
import exceptions.NoPopulationException;

public class Main {

	public static void main(String args[]) {
		processCommand();
	}

	public enum Commands {
		LIST_PEOPLE,ADD_PERSON, EXIT
	}

	private static void processCommand() {
		Scanner in = new Scanner(System.in);
		DataBaseSystem dbs = new DataBaseSystemClass();
		Commands com = getCommand(in);
		while (!com.equals(Commands.EXIT)) {
			switch (com) {

			case LIST_PEOPLE:
				processListPeople(dbs);
				break;
				
			case ADD_PERSON:
				processAddPerson(dbs,in);
				break;
				
			case EXIT:
				break;
				
			default:
				System.out.println("ERROR");
			/* case MOVE:
				// verificar se o bloco permite que a personagem se coloque la

				// verificar se o caminho ate ao bloco e permitido

				// mover a personagem
				break;
			case SELECT_BLOCK:

				// verificar se o bloco e valido

				/*
				 * demostrar quais as opcoes de acoes dadas no/pelo bloco, das quais podem ser:
				 * 1 atacar, so aparece disponivel se aparacer uma criatura no bloco;
				 * 
				 * 2 minerar, so aparece disponivel se aparacer uma minerio no bloco;
				 * 
				 * 3 construir, so aparece disponivel se for possivel construir no bloco e so
				 * aparecem as construcoes que sao permitidas, baseadas em espa�o
				 * permitido/usado e nivel?!?!
				 * 
				 *
				break;
			case CHECK_STATS:

				/*
				 * mostra as qualidades de : personagem : barras de vida,stamina e exp. Mostra
				 * os niveis de vida,stamina,defesa, ataque e velocidade , imagem da
				 * personagem?!?!
				 * 
				 * criatura: barra de vida, stats
				 * 
				 * constru�ao: vida, nivel, descri�ao
				 * 
				 * bloco: o q contem
				 * 
				 *
				break;
			case OPTIONS_MENU:

				/*
				 						 
				 *
				break;*/
			}
		com = getCommand(in);
		}
	}

	private static void processAddPerson(DataBaseSystem dbs, Scanner in) {
		try {
			String fname = in.next();
			String lname = in.next();
			int age = in.nextInt();
			String gender = in.nextLine().trim();
			dbs.addPerson(fname, lname, age, gender);
			System.out.println("Person Created");
		} catch( NameAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void processListPeople(DataBaseSystem dbs) {
		try {
			Iterator<Person> it = dbs.peopleIterator();
			System.out.printf("Population: %d,\n", dbs.getPopSize());
			
			while (it.hasNext()) {
				PersonOut p = it.next();
				System.out.println();
				System.out.printf("Name: %s %s,\n", p.getFirstName(), p.getLastName());
				System.out.printf("Age: %d,\n", p.getAge());
				System.out.printf("Level %d,\n", p.getLevel());
				System.out.printf("XP: %.2f,\n", p.getTotalExp());
				System.out.printf("Health: %.1f/%d,\n", p.getCurrentHealth(), p.getMaxHealth());
				System.out.printf("Stamina: %.1f/%d,\n\n", p.getCurrentStamina(), p.getMaxStamina());
			}
		} catch (NoPopulationException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Devolve um enumerado Command com o comando.
	 * 
	 * @param in - Scanner
	 * @return enumerado Command com o comando
	 * @throws InvalidCommandException 
	 */
	private static Commands getCommand(Scanner in) {
		Commands com = Commands.valueOf(in.next().trim().toUpperCase());
		
		return com;
	}

}
