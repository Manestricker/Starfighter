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

public class Bullets
{
	private List<Ammo> ammo;

	public Bullets()
	{
		ammo = new ArrayList<Ammo>();
	}

	public void add(Ammo al)
	{
		ammo.add(al);
	}

	//post - draw each Ammo
	public void drawEmAll( Graphics window )
	{
		for(Ammo a: ammo){
			a.draw(window);
		}
	}

	public void moveEmAll()
	{
		if (ammo.size() > 0) {
			for(Ammo b: ammo){
				b.move("UP");
			}
		}
	}
	public boolean collision(Alien a){
		if(ammo.size() > 0){
			for(Ammo c: ammo){
				//if((c.getX()<a.getX())&&(c.getX()>a.getX()-a.getHeight())&&(c.getY()<a.getY())&&(c.getY()>a.getY()-a.getWidth())){
				if((c.getY()>a.getY())&&(c.getY()<a.getY()+a.getHeight())&&(c.getX()>a.getX())&&(c.getX()<a.getX()+a.getWidth())){
					return true;
				}
			}
		}
		return false;
	}

	public void cleanEmUp()
	{
		if (ammo.size() > 0) {
			for(Ammo d: ammo){
				if(d.getY()<-1){
					d.setPos(0, -1);
				}
			}
		}
	}

	public List<Ammo> getList()
	{
		return ammo;
	}

	public String toString()
	{
		return "";
	}
}
