package game.state;

import game.main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MenuState extends State {

    private Image play, tutorial, title;

    private void initImages() {
        if(title == null) {
            try {
                title = ImageIO.read(getClass().getResource("/title.png"));
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(play == null) {
            try {
                play = ImageIO.read(getClass().getResource("/play.png"));
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(tutorial == null) {
            try {
                tutorial = ImageIO.read(getClass().getResource("/tutorial.png"));
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public MenuState() {
        initImages();
    }

    public void render(Graphics g) {
        State.drawBackground(g, "grey");

        g.drawImage(title, Game.WIDTH/2 - 400, 50, 800, 300, null);

        g.drawImage(play, Game.WIDTH/2 - 125, Game.HEIGHT/2 - 40, 250, 200, null);
        g.drawImage(tutorial, Game.WIDTH/2 - 222, Game.HEIGHT/2 + 100, 445, 200, null);
    }

    public void tick() {

    }

    public void processMouseEvent(MouseEvent me) {

    }

    public void processKeyEventPress(KeyEvent ke) {

    }

    public void processKeyEventRelease(KeyEvent ke) {

    }

}
