package me.manestricker.starfighter.motion;//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -


import java.awt.Graphics;

public abstract class MovingThing implements Moveable {
    private int xPos;
    private int yPos;
    private int width;
    private int height;

    public MovingThing(int x, int y) {
        xPos = x;
        yPos = y;
        width = 10;
        height = 10;
    }

    public MovingThing(int x, int y, int w, int h) {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
    }

    public void setPos(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public void setX(int x) {
        xPos = x;
    }

    public void setY(int y) {
        yPos = y;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public void setWidth(int w) {
        width = w;
    }

    public void setHeight(int h) {
        height = h;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public abstract void move(String direction);

    public abstract void draw(Graphics window);

    @Override
    public String toString() {
        return "Ship[x:" + xPos + ", y=" + yPos + ", height=" + height + ", width=" + width + "]";
    }
}