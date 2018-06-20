package game.state;

import game.main.Game;
import game.main.GameInfo;
import game.main.Music;
import game.sprites.entity.inventory.Item;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ConnectState extends State{

    private String name = "";
    private static Image arrow, arrowR, title, skull;
    private boolean highL, highR;
    private boolean loading = false;
    private boolean cont = false;

    private void initImages() {
        try {
            arrow = ImageIO.read(getClass().getResource("/arrow.png"));
            arrowR = ImageIO.read(getClass().getResource("/arrowR.png"));
            title = ImageIO.read(getClass().getResource("/title.png"));
            skull = ImageIO.read(getClass().getResource("/skull.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ConnectState() {
        initImages();
    }

    public void render(Graphics g) {
        State.drawBackground(g, "grey");

        g.drawImage(title, Game.WIDTH/2 - 100, 0, 200, 75, null);

        //draw box
        g.setColor(Color.WHITE);
        g.drawRect(Game.WIDTH/2 - 100, Game.HEIGHT/2 - 15, 200, 30);

        //draw text
        g.setColor(new Color(200,34, 34));
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        g.drawString(name, Game.WIDTH/2 - (name.length()*5), Game.HEIGHT/2 + 5);

        //Draw arrow labels
        g.setColor(Color.WHITE);
        g.setFont(new Font("Silon", Font.PLAIN, 18));
        g.drawString("Back", 6, 44);
        g.drawString("Play", Game.WIDTH-40, 44);

        //Draw arrows & highlight
        if(highL) {
            g.drawImage(arrowR, 0, 0, 45, 30, null);
        }else {
            g.drawImage(arrow, 0, 0, 45, 30, null);
        }

        if(highR) {
            g.drawImage(arrowR, Game.WIDTH, 0, -45, 30, null);
        }else {
            g.drawImage(arrow, Game.WIDTH, 0, -45, 30, null);
        }

        if(loading) {
            //draw loading screen
            g.clearRect(0,0,Game.WIDTH, Game.HEIGHT);
            State.drawBackground(g, "grey");
            g.drawImage(title, Game.WIDTH/2 - 400, Game.HEIGHT/2 + 70, 800, 300, null);
            g.drawImage(skull, Game.WIDTH/2 - 136, 50, 272, 320, null);
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            g.drawString("Loading...", Game.WIDTH/2 - 50, Game.HEIGHT/2 + 50);
            cont = true;
        }
    }

    public void tick() {
        int x = (int) GameInfo.getInstance().getMouseX();
        int y = (int) GameInfo.getInstance().getMouseY();

        highL = x >= 0 && x <= 36 && y >= 0 && y <= 30;
        highR = x >= Game.WIDTH - 36 && x <= Game.WIDTH && y >= 0 && y <= 30;

        if(Music.isNotRunning()) {
            Music.playMusic();
        }

        if(cont) {
//            GameState.initImages(); TODO
            GameState gs = new GameState(name);
            gs.genTerrain();
            Item.initImages();
            Game.loadState(gs);
            Music.setMode(Music.Mode.GAME);
        }
    }

    public void processMouseEvent(MouseEvent me) {
        if(highL) {
            Game.loadState(new MenuState());
        }
        if(highR) {
            loading = true;
        }
    }

    public void processKeyEventPress(KeyEvent ke) {
        if(name.length() < 10) {
            if((ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z') || (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')) {
                name += ke.getKeyChar();
            }
        }
        if(ke.getKeyCode() == 8 && name.length()>0) {
            name = name.substring(0, name.length()-1);
        }
        if(ke.getKeyCode() == 10 && name.length() != 0) {
            loading = true;
        }
    }

    public void processKeyEventRelease(KeyEvent ke) {

    }

    public void processMouseHold(MouseEvent e) {

    }

    public void processMouseRelease(MouseEvent e) {

    }

}
