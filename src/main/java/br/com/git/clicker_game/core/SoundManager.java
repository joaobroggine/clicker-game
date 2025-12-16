package br.com.git.clicker_game.core;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

public class SoundManager {

    public static void playSfx(String path) {
        URL resource = SoundManager.class.getResource(path);

        if (resource == null) {
            System.err.println("Audio not found: " + path);
            return;
        }

        Media media = new Media(resource.toExternalForm());
        MediaPlayer player = new MediaPlayer(media);

        player.setVolume(0.8);
        player.setOnEndOfMedia(player::dispose);
        player.play();
    }
}
