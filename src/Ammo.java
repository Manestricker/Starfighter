//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
	private int speed;
	private Image image;

	public Ammo()
	{
		this(10,10,5);
	}

	public Ammo(int x, int y)
	{
		this(x,y,1);
	}

	public Ammo(int x, int y, int s)
	{
		super(x,y);
		speed = s;
		try
		{
			URL url = getClass().getResource("/ok.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here
		}
	}

	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		//bullet width and height are set here
	   	window.drawImage(image,getX(),getY(),25,25,null);
	}
	
	
	public void move(String direction)
	{
		if(direction.equals("UP")){
			super.setY(super.getY()-speed);
		}
		if(direction.equals("DOWN")){
			super.setY(super.getY()+speed);
		}
		if(direction.equals("RIGHT")){
			super.setX(getX()+speed);
		}
		if(direction.equals("LEFT")){
			super.setX(getX()-speed);
		}
	}
	public void moveUp(){
		this.move("UP");
	}
	public String toString()
	{
		return "";
	}
}
