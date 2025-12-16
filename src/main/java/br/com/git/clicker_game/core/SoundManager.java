package br.com.git.clicker_game.core;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundManager {

    public static Clip playSfx(String path, boolean loop) {
        try {
            URL resource = SoundManager.class.getResource(path);

            if (resource == null) {
                System.err.println("Áudio não encontrado: " + path);
                return null;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(resource);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            setVolume(clip, 0.8f);

            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.start();
            }

            clip.addLineListener(event -> {
                if (!loop && event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                    try {
                        audioStream.close();
                    } catch (IOException ignored) {}
                }
            });

            return clip;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void setVolume(Clip clip, float volume) {
        if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl gain = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float) (Math.log10(volume <= 0.0 ? 0.0001 : volume) * 20.0);
            gain.setValue(dB);
        }
    }
}
