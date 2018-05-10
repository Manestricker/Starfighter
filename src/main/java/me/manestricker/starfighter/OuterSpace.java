package me.manestricker.starfighter;

import me.manestricker.starfighter.gameobjects.Ship;
import me.manestricker.starfighter.gameobjects.alien.Alien;
import me.manestricker.starfighter.gameobjects.alien.AlienHorde;
import me.manestricker.starfighter.gameobjects.bullet.Ammo;
import me.manestricker.starfighter.gameobjects.bullet.Bullets;
import me.manestricker.starfighter.util.Sounds;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;


public class OuterSpace extends Canvas implements KeyListener, Runnable {
    private static final long serialVersionUID = -7317053773365958771L;

    private Ship ship;
    private Sounds sound;

    private Bullets shots;
    private AlienHorde horde;


    private boolean[] keys;
    private BufferedImage back;

    OuterSpace(int width, int height) {
        setBackground(Color.black);

        keys = new boolean[5];

        sound = Sounds.getInstance();
        ship = new Ship(400, 400);
        shots = new Bullets();
        horde = new AlienHorde();

        Alien[] aliens = new Alien[10];
        for (int i = 0; i < aliens.length; i++) {
            aliens[i] = new Alien(random(0, width), random(0, height - 300), random(2, 4));
            horde.add(aliens[i]);
        }

        addKeyListener(this);
        new Thread(this).start();

        setVisible(true);
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        //set up the double buffering to make the game animation nice and smooth
        Graphics2D twoDGraph = (Graphics2D) window;

        //take a snap shop of the current screen and same it as an image
        //that is the exact same width and height as the current screen
        if (back == null)
            back = (BufferedImage) createImage(getWidth(), getHeight());

        //create a graphics reference to the back ground image
        //we will draw all changes on the background image
        Graphics graphToBack = back.createGraphics();

        graphToBack.setColor(Color.BLUE);
        graphToBack.drawString("me.manestricker.starfighter.StarFighter ", 25, 50);
        graphToBack.setColor(Color.BLACK);
        graphToBack.fillRect(0, 0, 800, 600);

        if (keys[0]) {
            ship.move("LEFT");
        }
        if (keys[1]) {
            ship.move("RIGHT");
        }
        if (keys[2]) {
            ship.move("DOWN");
        }
        if (keys[3]) {
            ship.move("UP");
        }
        if (keys[4]) {
            shots.add(new Ammo(ship.getX(), ship.getY()));
            sound.shoot();
            keys[4] = false;
        }


        //add code to move me.manestricker.starfighter.gameobjects.Ship, me.manestricker.starfighter.gameobjects.alien.Alien, etc.

        if (ship.getX() < 0) {
            ship.setX(0);
        }
        if (ship.getX() > 800 - ship.getWidth()) {
            ship.setX(800 - ship.getWidth());
        }
        if (ship.getY() < 0) {
            ship.setY(0);
        }
        if (ship.getY() > 600 - ship.getHeight()) {
            ship.setY(600 - ship.getHeight());
        }

        ship.draw(graphToBack);
        shots.drawEmAll(graphToBack);
        shots.moveEmAll();
        shots.cleanEmUp();
        horde.drawEmAll(graphToBack);
        horde.moveEmAll();

        twoDGraph.drawImage(back, null, 0, 0);

        //Collision Detection
//		if(shots.collision(alienOne)){
//			alienOne.setPos(-100, -100);;
//		}
//		if(shots.collision(alienTwo)){
//			alienTwo.setPos(-100, -100);;
//		}
//		if(shots.collision(alienThree)){
//			alienOne.setPos(-100, -100);;
//		}
//		if(shots.collision(alienFour)){
//			alienTwo.setPos(-100, -100);;
//		}
//		if(shots.collision(alienFive)){
//			alienOne.setPos(-100, -100);;
//		}
//		if(shots.collision(alienSix)){
//			alienTwo.setPos(-100, -100);;
//		}
//		if(shots.collision(alienSeven)){
//			alienOne.setPos(-100, -100);;
//		}
//		if(shots.collision(alienEight)){
//			alienTwo.setPos(-100, -100);;
//		}
//		if(shots.collision(alienNine)){
//			alienOne.setPos(-100, -100);;
//		}
//		if(shots.collision(alienTen)){
//			alienTwo.setPos(-100, -100);;
//		}
        //horde.removeDeadOnes(shots.collision(horde.aliens));
        for (Alien a : horde.aliens) {
            horde.removeDeadOnes(shots.collision(a), a);
        }
    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            keys[0] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            keys[1] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            keys[2] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            keys[3] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            keys[4] = true;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            keys[0] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            keys[1] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            keys[2] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            keys[3] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            keys[4] = false;
        }
        repaint();
    }

    public void keyTyped(KeyEvent e) {
    }

    public void run() {
        boolean running = true;

        while (running) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                running = false;
                e.printStackTrace();
            }

            repaint();
        }
    }

    private int random(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }
}
