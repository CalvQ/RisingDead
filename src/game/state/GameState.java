package game.state;

import game.main.Music;
import game.sprites.entity.Player;
import game.sprites.environment.Map;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameState extends State {

    private Player player;
    private boolean left, up, right, down;
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
        player.render(g, player.getLoc());
        m.render(g, player.getLoc());
    }

    public void tick() {
        player.tick();

        if(left) {
            player.moveX(-5);
        }
        if(right) {
            player.moveX(5);
        }
        if(up) {
            player.moveY(-5);
        }
        if(down) {
            player.moveY(5);
        }

        if(Music.isNotRunning()) {
            Music.playMusic();
        }
    }

    public void processMouseEvent(MouseEvent me) {

    }

    public void processKeyEventPress(KeyEvent ke) {
        int code = ke.getKeyCode();
        switch (code){
            case 65:
                left = true;
                break;
            case 87:
                up = true;
                break;
            case 68:
                right = true;
                break;
            case 83:
                down = true;
                break;
        }
    }

    public void processKeyEventRelease(KeyEvent ke) {
        int code = ke.getKeyCode();
        switch (code){
            case 65:
                left = false;
                break;
            case 87:
                up = false;
                break;
            case 68:
                right = false;
                break;
            case 83:
                down = false;
                break;
        }
    }

    public void processMouseHold(MouseEvent e) {

    }

    public void processMouseRelease(MouseEvent e) {

    }

}
