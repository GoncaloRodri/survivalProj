package progressTrees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import exceptions.AchievementHasNoChildrenException;

public class ProgressTreeClass implements AbsProgressTree{

    private String name;

    private List<Achievement>[] availableAchievements;

    public ProgressTreeClass(String name){
        this.name = name;
        availableAchievements = new List[15];


    }

    @Override
    public Iterator<Achievement> getAvailableAchievements() {
        return availableAchieves();
    }

    protected Iterator<Achievement> availableAchieves() {
        List<Achievement> ret = new LinkedList<>();
        for(int i = 0; i < availableAchievements.length; i++){
            if(availableAchievements[i] != null && !availableAchievements[i].isEmpty() ){
                ret.addAll(availableAchievements[i]);
            }
        }
        return ret.iterator();
    }

    @Override
    public Iterator<Achievement> getTree() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void unlockAchievement(Achievement a) throws AlreadyUnlockedException {
        a.unlock();
        availableAchievements[a.getLevel()].remove(a);
        addChildrenToAvailable(a);

        
        
    }

    private void addChildrenToAvailable(Achievement a) {
        try {
            Iterator<Achievement> it = a.getChildren();
            while(it.hasNext()){
                Achievement ach = it.next();
                List<Achievement> list = availableAchievements[ach.getLevel()];
                if(list == null){
                    list = new LinkedList<Achievement>();
                }
                list.add(ach);
            }
        } catch (AchievementHasNoChildrenException e) {
            System.out.println("Congratulation! You ended this branched! Keep the good job!");
        }
        
    }

    @Override
    public String getTreeName() {
        return name;
    }
    
}