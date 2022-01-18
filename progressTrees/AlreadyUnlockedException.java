package progressTrees;

public class AlreadyUnlockedException extends Exception {

    private static final String MESSAGE = "Achievement already unlocked!";

    public AlreadyUnlockedException(){
        super(MESSAGE);
    }
}
