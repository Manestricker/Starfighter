//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;

	public Ship()
	{
		this(10,10,50,50,2);
	}

	public Ship(int x, int y)
	{
		this(x,y,50, 50,5);
	}

	public Ship(int x, int y, int s)
	{
		this(x,y,50,50,s);
	}

	public Ship(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		try
		{
			URL url = getClass().getResource("/face.png");
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

	public void move(String direction)
	{
		if(direction.equals("UP")){
			super.setY(super.getY()+speed);
		}
		if(direction.equals("DOWN")){
			super.setY(super.getY()-speed);
		}
		if(direction.equals("RIGHT")){
			super.setX(getX()+speed);
		}
		if(direction.equals("LEFT")){
			super.setX(getX()-speed);
		}
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
