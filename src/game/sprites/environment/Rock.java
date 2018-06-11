package game.sprites.environment;

import game.main.Game;
import game.sprites.Location;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Rock {

    public enum Size{
        SMALL, MEDIUM, LARGE
    }

    private Location loc;
    private Size size;
    private static Image rock;

    public void render(Graphics g, Location l) {
        if(Math.abs(l.diffX(this.loc)) > Game.WIDTH/2 + 50|| Math.abs(l.diffY(this.loc)) > Game.HEIGHT/2 + 50) {
            return;
        }
        switch (size) {
            case SMALL:
                g.drawImage(rock, Game.WIDTH/2 - 10 - (int) (l.diffX(this.loc)), Game.HEIGHT/2 - 10 - (int) (l.diffY(this.loc)),20, 20, null);
                break;
            case MEDIUM:
                g.drawImage(rock, Game.WIDTH/2 - 15 - (int) (l.diffX(this.loc)), Game.HEIGHT/2 - 15 - (int) (l.diffY(this.loc)),30, 30, null);
                break;
            case LARGE:
                g.drawImage(rock, Game.WIDTH/2 - 25 - (int) (l.diffX(this.loc)), Game.HEIGHT/2 - 25 - (int) (l.diffY(this.loc)),50, 50, null);
                break;
        }
    }

    public Location getLoc() {
        return loc;
    }

    public Size getSize() {
        return size;
    }

    public Rock(Size s, Location l) {
        if(rock == null) {
            try {
                rock = ImageIO.read(getClass().getResource("/rock.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        loc = l;
        size = s;
    }
}
