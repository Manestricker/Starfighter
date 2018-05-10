package me.manestricker.starfighter.gameobjects.bullet;

import me.manestricker.starfighter.motion.MovingThing;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

public class Ammo extends MovingThing {
    private int speed;
    private Image image;

    public Ammo(int x, int y) {
        this(x, y, 1);
    }

    public Ammo(int x, int y, int speed) {
        super(x, y);
        this.speed = speed;
        try {
            URL url = getClass().getResource("/img/ok.jpg");
            image = ImageIO.read(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int s) {
        speed = s;
    }

    public void draw(Graphics window) {
        window.drawImage(image, getX(), getY(), 25, 25, null);
    }


    public void move(String direction) {
        if (direction.equals("UP")) {
            super.setY(super.getY() - speed);
        }
        if (direction.equals("DOWN")) {
            super.setY(super.getY() + speed);
        }
        if (direction.equals("RIGHT")) {
            super.setX(getX() + speed);
        }
        if (direction.equals("LEFT")) {
            super.setX(getX() - speed);
        }
    }
}
