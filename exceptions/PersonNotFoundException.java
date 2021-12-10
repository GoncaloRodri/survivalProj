package exceptions;

public class PersonNotFoundException extends Exception {
  
  
    public PersonNotFoundException(String name){
        super(toString(name));
    }

    private static String toString(String name){
        return "No Person named " + name + " found!";
    }
}