//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import java.awt.Component;
import java.net.URL;

public class StarFighter extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3023850751464671081L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	public StarFighter()
	{
		super("STARFIGHTER");
		setSize(WIDTH,HEIGHT);
 
		OuterSpace theGame = new OuterSpace();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main( String args[] )
	{
		System.out.println("howdy");
		StarFighter run = new StarFighter();
		Sounds back = new Sounds();
		back.playBackground();
		
	}
}