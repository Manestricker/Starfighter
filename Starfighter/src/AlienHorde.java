//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
	private List<Alien> aliens;

	public AlienHorde(int size)
	{
		aliens = new ArrayList<Alien>(size);
	}

	public void add(Alien al)
	{
		aliens.add(al);
	}

	public void drawEmAll( Graphics window )
	{
		for(Alien a: aliens){
			a.draw(window);
		}
	}

	public void moveEmAll()
	{
		for(Alien b: aliens){
			b.move("UP");
		}
	}

	public void removeDeadOnes(boolean bool)
	{
		for(Alien c: aliens){
			if(bool){
			c.setPos(-100, -100);
			}
		}
	}

	public String toString()
	{
		return "";
	}
}
