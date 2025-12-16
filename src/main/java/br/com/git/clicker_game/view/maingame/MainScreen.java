package br.com.git.clicker_game.view.maingame;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class MainScreen {

    String filePath = "src/main/resources/assets/sounds/sfx/wind.wav";
    AudioInputStream audioInputStream;

    public MainScreen() {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
            audioInputStream = null;
        }
    }

    public Scene createScene() {
    
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: black;");

        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);

        Clip clip;
        try {
            if (audioInputStream != null) {
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return scene;
    }



}
