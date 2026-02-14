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
        achievements.add(new Achievement("Doing Well", "Reach 1.000 money", false));
        achievements.add(new Achievement("Almost There", "Reach 100.000 money", false));
        achievements.add(new Achievement("Became Millionaire", "Reach 1.000.000 money", false));
        achievements.add(new Achievement("BBBillionaire", "Reach 1.000.000.000 money", false));
        achievements.add(new Achievement("Jackpot", "Win the bet", false));
        achievements.add(new Achievement("Jackpot for You", "Win 7 bets in a row", false));
    }

    public ObservableList<Achievement> getAchievements() {
        return achievements;
    }

}
