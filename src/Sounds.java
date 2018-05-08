import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sounds {
	public Sounds(){
	}
	
	
	public void playBackground(){
		try {
	    	URL url = this.getClass().getClassLoader().getResource("Main.wav");
	    	AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioIn);
	        clip.start();
	        clip.loop(10);
		} catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public void playOof(){
		try {
	    	URL url = this.getClass().getClassLoader().getResource("Roblox.wav");
	    	AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioIn);
	        clip.start();
	        clip.loop(1);
		} catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	public void playFire(){
		try {
	    	URL url = this.getClass().getClassLoader().getResource("Yeet.wav");
	    	AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioIn);
	        clip.start();
		} catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
}
