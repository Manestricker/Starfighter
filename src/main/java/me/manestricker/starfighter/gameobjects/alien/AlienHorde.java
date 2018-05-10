package me.manestricker.starfighter.gameobjects.alien;//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import me.manestricker.starfighter.util.Sounds;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde {
    public List<Alien> aliens = new ArrayList<>();

    public void add(Alien al) {
        aliens.add(al);
    }

    public void drawEmAll(Graphics window) {
        for (Alien a : aliens) {
            a.draw(window);
        }
    }

    public void moveEmAll() {
        for (Alien b : aliens) {
            if (b.getX() == 740) {
                b.setBool(true);
            }
            if (b.getX() == 0) {
                b.setBool(false);
            }
            if (b.getBool()) {
                b.move("LEFT");
            } else {
                b.move("RIGHT");
            }
        }
    }

    public void removeDeadOnes(boolean bool, Alien c) {
        if (bool) {
            c.setPos(-100, -100);
            Sounds play = Sounds.getInstance();
            play.hit();
        }
    }
}
