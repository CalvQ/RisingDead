package game.state;

import game.sprites.Empty;
import game.sprites.Location;
import game.sprites.entity.Player;
import game.sprites.environment.Map;
import game.sprites.environment.Rock;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameState extends State {

    private Player player;
    private Image bodyP, bodyE;
    private Image[] guns = new Image[0];//Get number of guns?
    private Map m;

    public GameState(String name) {
        player = new Player(name);
        m = new Map(player);
    }

    public static void initImages() {

    }

    public void genTerrain() {
        m.genTerrain();
    }

    public void render(Graphics g) {

    }

    public void tick() {

    }

    public void processMouseEvent(MouseEvent me) {

    }

    public void processKeyEventPress(KeyEvent ke) {

    }

    public void processKeyEventRelease(KeyEvent ke) {

    }

    public void processMouseHold(MouseEvent e) {

    }

    public void processMouseRelease(MouseEvent e) {

    }

}
