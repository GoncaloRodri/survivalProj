package progressTrees;

import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;

import exceptions.AchievementHasNoChildrenException;
import exceptions.AchievementHasNoParentException;

public class Achievement {
    
    private String name;
    private String descripton;
    private int level;
    private boolean unlocked;

    //private ImageIcon icon;
    private List<Achievement> parents;
    private List<Achievement> children;


    public Achievement(String name, String description, 
    List<Achievement> parents, List<Achievement> children){
        this.name = name;
        this.descripton = description;
        this.parents = parents;
        this.children = children;
        this.unlocked = false;
        setLevel();
    }

    protected void setLevel(){
        Iterator<Achievement> it = parents.iterator();
        int itlvl = 0;
        this.level = 0;
        while(it.hasNext()){
            itlvl = it.next().getLevel();
            if(level <= itlvl){
                level = itlvl++; 
            } 

        }
    }

    public int getLevel(){
        return level;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return descripton;
    }

    public boolean isUnlocked(){
        return unlocked;
    }

    public void unlock(){
        unlocked = true;
    }

    public Iterator<Achievement> getChildren() throws AchievementHasNoChildrenException{
        if(children.isEmpty()) throw new AchievementHasNoChildrenException();
        return children.iterator();
    }

    public Iterator<Achievement> getParents()throws AchievementHasNoParentException{
        if(parents.isEmpty()) throw new AchievementHasNoParentException();
        return parents.iterator();
    }

    public boolean hasChildren(){
        return !children.isEmpty();
    }

    public boolean hasParents(){
        return !parents.isEmpty();
    }
}
