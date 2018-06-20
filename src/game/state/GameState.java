package game.state;

import game.main.Game;
import game.main.Music;
import game.sprites.entity.Player;
import game.sprites.environment.Map;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameState extends State {

    private Player player;
    private boolean left, up, right, down;
    private Map m;

    public GameState(String name) {
        player = new Player(name);
        m = new Map(player);
    }

    public void genTerrain() {
        m.genTerrain();
    }

    private void drawInv(Graphics g) {
        player.drawInv(g);

        //draw squares
        g.setColor(Color.BLACK);

        g.fillRect(Game.WIDTH - 262, Game.HEIGHT - 54, 262, 2);
        g.fillRect(Game.WIDTH - 262, Game.HEIGHT - 2, 262, 2);

        //label and draw squares
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
        int temp;

        for(int i=0; i<6; i++) {
            g.fillRect(Game.WIDTH - 262 + (i * 52), Game.HEIGHT - 52, 2, 50);
            if(i < 5) {
                temp = i+1;
                g.drawString(temp + "", Game.WIDTH - 258 + (i * 52), Game.HEIGHT - 43);
            }
        }
    }

    private void drawBloom(Graphics g) {

    }

    public void render(Graphics g) {
        player.render(g, player.getLoc());
        m.render(g, player.getLoc());
        drawInv(g);
        drawBloom(g);
    }

    public void tick() {
        player.tick();

        if(left) {
            player.moveX(-1);
        }
        if(right) {
            player.moveX(1);
        }
        if(up) {
            player.moveY(-1);
        }
        if(down) {
            player.moveY(1);
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
            case 81:
                player.shiftInvDown();
                break;
            case 69:
                player.shiftInvUp();
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
