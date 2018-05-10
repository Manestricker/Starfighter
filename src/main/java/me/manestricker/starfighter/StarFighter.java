package me.manestricker.starfighter;

import me.manestricker.starfighter.util.Sounds;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StarFighter extends JFrame {
    private static final long serialVersionUID = -3023850751464671081L;

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private StarFighter() {
        super("STARFIGHTER");
        setSize(WIDTH, HEIGHT);

        OuterSpace theGame = new OuterSpace(WIDTH, HEIGHT);
        theGame.setFocusable(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Sounds.getInstance().stopSounds();
                System.exit(0);
            }
        });

        getContentPane().add(theGame);

        setVisible(true);
    }

    public static void main(String args[]) {
        System.out.println("howdy");
        new StarFighter();

        Sounds.getInstance().preloadSounds();
        Sounds.getInstance().background();
    }
}