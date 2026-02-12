package br.com.git.clicker_game.core;

import br.com.git.clicker_game.model.Achievement;
import javafx.collections.ObservableList;

public class AchievementManager {
    
    private final ObservableList<Achievement> achievements = 
        javafx.collections.FXCollections.observableArrayList();

    public AchievementManager() {
        achievements.add(new Achievement("Welcome!", "Make your first click"));
        
    }

    public ObservableList<Achievement> getAchievements() {
        return achievements;
    }

}
