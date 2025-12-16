package br.com.git.clicker_game.core;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameManager {

    private static Stage mainStage;
    private static Stage shopStage;

    public static void setMainStage(Stage stage) {
        mainStage = stage;
    }

    public static void changeScene(Scene scene) {
        if (mainStage == null) {
            throw new IllegalStateException("Main Stage not set in GameManager");
        }
        mainStage.setScene(scene);
        mainStage.setFullScreen(true);

    }

    public static void setShopScreen(Stage stage) {
        shopStage = stage;
    }

    public static void closeShopScreen() {
        if (shopStage != null) {
            shopStage.close();
            shopStage = null;
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
}
