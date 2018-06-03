package game.state;

import game.main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;

public abstract class State {

    private static HashMap<String, Image> backgrounds = new HashMap<>();

    public abstract void render(Graphics g);

    public abstract void tick();

    public abstract void processMouseEvent(MouseEvent me);

    public abstract void processKeyEventPress(KeyEvent ke);

    public abstract void processKeyEventRelease(KeyEvent ke);

    private static void initImages() {
        try {
            backgrounds.put("grey", ImageIO.read(State.class.getResource("/grey.png")));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void drawBackground(Graphics g, String color) {
        if(backgrounds.get(color) == null) {
            initImages();
        }
        g.drawImage(backgrounds.get(color), 0, 0, null);
    }
}
