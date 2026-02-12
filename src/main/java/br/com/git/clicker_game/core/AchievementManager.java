package br.com.git.clicker_game.core;

import br.com.git.clicker_game.model.Achievement;
import javafx.collections.ObservableList;

public class AchievementManager {
    
    private final ObservableList<Achievement> achievements = 
        javafx.collections.FXCollections.observableArrayList();

    public AchievementManager() {
        achievements.add(new Achievement("Welcome", "Make your first click", false));
        achievements.add(new Achievement("Getting Bigger", "Make 100 clicks", false));
        achievements.add(new Achievement("Iron Finger", "Make 1000 clicks", false));  
    }

    public ObservableList<Achievement> getAchievements() {
        return achievements;
    }

}
