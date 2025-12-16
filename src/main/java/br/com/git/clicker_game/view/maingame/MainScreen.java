package br.com.git.clicker_game.view.maingame;

import br.com.git.clicker_game.core.SoundManager;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class MainScreen {

    public Scene createScene() {
    
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: black;");

        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);

        SoundManager.playSfx("/assets/sounds/sfx/wind.wav", true);

        return scene;
    }



}
