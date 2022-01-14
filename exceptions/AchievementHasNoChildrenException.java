package exceptions;

public class AchievementHasNoChildrenException extends Exception{

    private static final String MESSAGE = "This achievement has no children!";

    public AchievementHasNoChildrenException(){
        super(MESSAGE);
    }
}
