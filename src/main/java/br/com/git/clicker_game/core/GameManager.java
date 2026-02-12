package br.com.git.clicker_game.core;

import javafx.stage.Stage;

public class GameManager {

    private static Stage mainStage;
    private static Stage shopStage;
    private static Stage betStage;
    private static Stage achievementStage;
    private static AchievementManager achievementManager = new AchievementManager();

    public static void setMainStage(Stage stage) {
        mainStage = stage;
    }

    public static void setShopScreen(Stage stage) {
        shopStage = stage;
    }

    public static void setBetScreen(Stage stage) {
        betStage = stage;
    }

    public static void setAchievementScreen(Stage stage) {
        achievementStage = stage;
    }

    public static void closeShopScreen() {
        if (shopStage != null) {
            shopStage.close();
            shopStage = null;
        }
    }

    public static void closeBetScreen() {
        if (betStage != null) {
            betStage.close();
            betStage = null;
        }
    }

    public static void closeAchievementScreen() {
        if (achievementStage != null) {
            achievementStage.close();
            achievementStage = null;
        }
    }

    public static void exitGame() {
        if (mainStage != null) {
            mainStage.close();
        }
    }

    public static Stage getMainStage() {
        return mainStage;
    }

    public static AchievementManager getAchievementManager() {
        return achievementManager;
    }
}
