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
        Object[][] tiles = new Object[Map.HEIGHT/10][Map.WIDTH/10];

        //generate rocks
        /*Takes about 13500 / 100000000 spaces*/
        Rock.Size size;
        int numRocks = 0;
        while(numRocks < 500) {
            int randR = ((int) (Math.random() * tiles.length));
            int randC = ((int) (Math.random() * tiles[randR].length));
            if(tiles[randR][randC] == null){
                size = Rock.Size.values()[(int) (Math.random()*3)];
                tiles[randR][randC] = new Rock(size, new Location(randC * 10 + 5, randR * 10 + 5));
                switch (size) {
                    case small:
                        for(int r = -1; r < 2; r++) {
                            for(int c = -1; c < 2; c++) {
                                if(r == 0 && c == 0) {
                                    continue;
                                }
                                if(randR + r > -1 && randR + r < tiles.length
                                        && randC + c > -1 && randC + c < tiles[randR].length) {
                                    tiles[randR + r][randC + c] = new Empty.Filler();
                                }
                            }
                        }
                        break;
                    case medium:
                        for(int r = -2; r < 3; r++) {
                            for(int c = -2; c < 3; c++) {
                                if(r == 0 && c == 0) {
                                    continue;
                                }
                                if(randR + r > -1 && randR + r < tiles.length
                                        && randC + c > -1 && randC + c < tiles[randR].length) {
                                    tiles[randR + r][randC + c] = new Empty.Filler();
                                }
                            }
                        }
                        break;
                    case large:
                        for(int r = -3; r < 4; r++) {
                            for(int c = -3; c < 4; c++) {
                                if(r == 0 && c == 0) {
                                    continue;
                                }
                                if(randR + r > -1 && randR + r < tiles.length
                                        && randC + c > -1 && randC + c < tiles[randR].length) {
                                    tiles[randR + r][randC + c] = new Empty.Filler();
                                }
                            }
                        }
                        break;
                }
                numRocks++;
            }
        }

        int out = 0;

        for(Object[] row:tiles) {
            for(Object o:row) {
                if(o instanceof Empty.Filler){
                    out++;
                }
            }
        }
        System.out.println(numRocks + " " + out + " " + Map.WIDTH * Map.HEIGHT);
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
