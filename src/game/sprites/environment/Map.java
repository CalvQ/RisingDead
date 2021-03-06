package game.sprites.environment;

import game.main.Game;
import game.sprites.Empty;
import game.sprites.Location;
import game.sprites.entity.Player;

import java.awt.*;

public class Map {

    public static final int WIDTH = 10000;
    public static final int HEIGHT = 10000;

    private Player player;
    private Rock[] rocks = new Rock[500];

    public Map(Player p) {
        player = p;
    }

    public void render(Graphics g, Location l) {
        for(Rock r:rocks) {
            r.render(g, l);
        }
    }

    public void genTerrain() {
        Object[][] tiles = new Object[Map.HEIGHT/10][Map.WIDTH/10];

        //generate rocks
        /*Takes about 13500 / 100000000 spaces*/
        Rock.Size size;
        int numRocks = 0;
        int temp = 0;
        while(numRocks < 500) {
            int randR = ((int) (Math.random() * tiles.length));
            int randC = ((int) (Math.random() * tiles[randR].length));
            temp++;
            if(tiles[randR][randC] == null){
                size = Rock.Size.values()[(int) (Math.random()*3)];
                tiles[randR][randC] = new Rock(size, new Location(randC * 10 + 5, randR * 10 + 5));
                rocks[numRocks] = (Rock) tiles[randR][randC];
                switch (size) {
                    case SMALL:
                        for(int r = -1; r < 2; r++) {
                            for(int c = -1; c < 2; c++) {
                                if(r == 0 && c == 0) {
                                    continue;
                                }
                                if(randR + r > -1 && randR + r < tiles.length
                                        && randC + c > -1 && randC + c < tiles[randR].length
                                        && !(tiles[randR + r][randC + c] instanceof Rock)) {
                                    tiles[randR + r][randC + c] = new Empty.Filler();
                                }
                            }
                        }
                        break;
                    case MEDIUM:
                        for(int r = -2; r < 3; r++) {
                            for(int c = -2; c < 3; c++) {
                                if(r == 0 && c == 0) {
                                    continue;
                                }
                                if(randR + r > -1 && randR + r < tiles.length
                                        && randC + c > -1 && randC + c < tiles[randR].length
                                        && !(tiles[randR + r][randC + c] instanceof Rock)) {
                                    tiles[randR + r][randC + c] = new Empty.Filler();
                                }
                            }
                        }
                        break;
                    case LARGE:
                        for(int r = -3; r < 4; r++) {
                            for(int c = -3; c < 4; c++) {
                                if(r == 0 && c == 0) {
                                    continue;
                                }
                                if(randR + r > -1 && randR + r < tiles.length
                                        && randC + c > -1 && randC + c < tiles[randR].length
                                        && !(tiles[randR + r][randC + c] instanceof Rock)) {
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
                if(o instanceof Rock){
                    out++;
                }
            }
        }
        System.out.println(temp + " " + numRocks + " " + out + " " + Map.WIDTH * Map.HEIGHT);
    }
}
