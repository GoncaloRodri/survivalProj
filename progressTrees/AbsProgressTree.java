package progressTrees;

import java.util.Iterator;

public interface AbsProgressTree {
    
    public Iterator<Achievement> getAvailableAchievements();

    public Iterator<Achievement> getTree();

    public void unlockAchievement(Achievement a) throws AlreadyUnlockedException;

    public String getTreeName();

}
