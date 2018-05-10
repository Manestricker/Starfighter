package me.manestricker.starfighter.gameobjects.alien;//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import me.manestricker.starfighter.motion.MovingThing;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

public class Alien extends MovingThing {
    private int speed;
    private boolean bool;
    private Image image;

    public Alien() {
        this(10, 10, 30, 30, 2, false);
    }

    public Alien(int x, int y) {
        this(x, y, 30, 30, 2, false);
    }

    public Alien(int x, int y, int s) {
        this(x, y, 30, 30, s, false);
    }

    public Alien(int x, int y, int w, int h, int s, Boolean a) {
        super(x, y, w, h);
        speed = s;
        bool = a;
        try {
            URL url = this.getClass().getResource("/img/alien.JPG");
            image = ImageIO.read(url);
        } catch (Exception e) {
            e.printStackTrace();
            //feel free to do something here
        }
    }

    public void setBool(Boolean b) {
        bool = b;
    }

    public boolean getBool() {
        return bool;
    }

    public void setSpeed(int s) {
        speed = s;
    }

    public int getSpeed() {
        return speed;
    }

    public void move(String direction) {
        if (direction.equals("UP")) {
            super.setY(super.getY() + speed);
        }
        if (direction.equals("DOWN")) {
            super.setY(super.getY() - speed);
        }
        if (direction.equals("RIGHT")) {
            super.setX(getX() + speed);
        }
        if (direction.equals("LEFT")) {
            super.setX(getX() - speed);
        }
    }

    public void draw(Graphics window) {
        window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
    }

    public String toString() {
        return "";
    }
}
