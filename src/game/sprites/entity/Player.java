package game.sprites.entity;

import game.main.Game;
import game.main.GameInfo;
import game.sprites.Location;
import game.sprites.environment.Map;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Player extends Entity {

    private String name;
    private Location loc;
    private Image circle, gun;

    public Player(String n) {
        if (circle == null) {
            try {
                circle = ImageIO.read(getClass().getResource("/circle.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (gun == null) {
            try {
                gun = ImageIO.read(getClass().getResource("/ClipGun.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.health = 100;
        this.angle = -1.57;
        this.loc = new Location(Map.WIDTH/2,Map.HEIGHT/2);
        name = n;
    }

    public Location getLoc() {
        return loc;
    }

    public void moveX(int dx) {
        loc.setX(loc.getX() + dx);
    }

    public void moveY(int dy) {
        loc.setY(loc.getY() + dy);
    }

    public void tick() {
        angle = Math.atan2(GameInfo.getInstance().getMouseY() - Game.HEIGHT/2, GameInfo.getInstance().getMouseX() - Game.WIDTH/2);
    }

    private void drawGun(Graphics g) {
        g.translate(Game.WIDTH/2, Game.HEIGHT/2);
        ((Graphics2D)g).rotate(this.angle);
        g.drawImage(gun, 10, -3, 60, 7, null);
        ((Graphics2D)g).rotate(-this.angle);
        g.translate(-Game.WIDTH/2, -Game.HEIGHT/2);
    }

    public void render(Graphics g, Location l) {
        g.drawImage(circle, Game.WIDTH/2 - 25, Game.HEIGHT/2 - 25, 50, 50, null);
        drawGun(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        g.drawString(name, Game.WIDTH/2 - (3*name.length()), Game.HEIGHT/2 - 27);
    }
}
