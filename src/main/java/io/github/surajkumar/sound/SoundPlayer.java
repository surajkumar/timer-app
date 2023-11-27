package io.github.surajkumar.sound;

import javax.sound.sampled.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class SoundPlayer {
    private static final URL SOUND_FILE = SoundPlayer.class
            .getClassLoader()
            .getResource("timeup-sound.wav");

    public static void playSound() {
        try {
            if(SOUND_FILE != null) {
                try (InputStream inputStream = SOUND_FILE.openStream()) {
                    byte[] buffer = inputStream.readAllBytes();
                    try (InputStream byteArrayInputStream = new ByteArrayInputStream(buffer)) {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(byteArrayInputStream);
                        try {
                            Clip clip = AudioSystem.getClip();
                            clip.open(audioInputStream);
                            clip.addLineListener(event -> {
                                if (event.getType() == LineEvent.Type.STOP) {
                                    clip.close();
                                }
                            });
                            clip.start();
                        } catch (LineUnavailableException | IOException e) {
                            System.err.println("Unable to play sound: " + e.getMessage());
                        }
                    }
                }
            }
        } catch (IOException | UnsupportedAudioFileException e) {
            System.err.println("Unable to load sound: " + e.getMessage());
        }
    }
}
