package game.main;

import game.sprites.Location;
import game.state.State;
import game.state.StateLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends Canvas {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 750;

    private boolean running;
    private StateLoader loader;

    private void start(){
        loader = new StateLoader(new MenuState());
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {}

            @Override
            public void mouseMoved(MouseEvent e) {
                GameInfo.getInstance().setMouseP(new Location(e.getX(), e.getY()));
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loader.processMouseEvent(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                loader.processKeyEventPress(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                loader.processKeyEventRelease(e);
            }
        });
        running = true;
        run();
    }

    public static void loadState(State s){
        loader.load(s);
    }

    private void run(){
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int ticks = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                loader.tick();
                ticks++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("TICKS: " + ticks + ", FPS: " + frames);
                ticks = 0;
                frames = 0;
            }
        }
    }

    public static void main(String[] args){
        System.setProperty("sun.java2d.opengl", "true");
        JFrame frame = new JFrame("Last Stand");
        Main main = new Main();
        main.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        main.setBackground(new Color(117, 214, 57));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(main);
        frame.pack();
        frame.setVisible(true);
        main.start();
    }

}
