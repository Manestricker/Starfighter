package me.manestricker.starfighter.util;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sounds {
    private static Sounds instance;

    private Sounds() {
    }

    public static Sounds getInstance() {
        if (instance == null) {
            instance = new Sounds();
            return instance;
        } else {
            return instance;
        }
    }

    private Clip background;
    private Clip shoot;
    private Clip hit;

    public void background() {
        background.loop(Clip.LOOP_CONTINUOUSLY);
        background.start();
    }

    public void hit() {
        hit.start();
    }

    public void shoot() {
        shoot.start();
    }

    public void stopSounds() {
        background.stop();
        shoot.stop();
        hit.stop();
    }

    public void preloadSounds() {
        background = loadSound("Main.wav");
        hit = loadSound("Roblox.wav");
        shoot = loadSound("Yeet.wav");
    }

    private Clip loadSound(String name) {
        try {
            URL url = getClass().getClassLoader().getResource("sounds/" + name);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            return clip;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
