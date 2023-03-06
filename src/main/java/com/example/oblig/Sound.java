package com.example.oblig;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound() {

        soundURL[0] = getClass().getResource("/sound/intro.mp3");
        soundURL[1] = getClass().getResource("/sound/waka.mp3");
        soundURL[2] = getClass().getResource("/sound/powerup.mp3");
        soundURL[3] = getClass().getResource("/sound/death.mp3");

    }

    public void play() {
        clip.start();
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            FloatControl gainControl =
                    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-30.0f);

        } catch (Exception e) {
        }
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    public void stop() {
        clip.stop();
    }
}