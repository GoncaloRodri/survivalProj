package exceptions;

public class AchievementHasNoParentException extends Exception{

    private static final String MESSAGE = "This achievement has no parents!";

    public AchievementHasNoParentException(){
        super(MESSAGE);
    }

}
