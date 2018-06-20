package game.sprites.entity;

import game.main.Game;
import game.main.GameInfo;
import game.sprites.Location;
import game.sprites.entity.inventory.Item;
import game.sprites.entity.inventory.gun.AWP;
import game.sprites.entity.inventory.gun.TestGun;
import game.sprites.environment.Map;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Player extends Entity {

    private String name;
    private Location loc;
    private static Image circle;
    private static Image light;
    private double moveSpeed = 5.0;

    private Item[] inventory = new Item[5];
    private int invSelection = 0;

    public Player(String n) {
        if (circle == null) {
            try {
                circle = ImageIO.read(getClass().getResource("/circle.png"));
                light = ImageIO.read(getClass().getResource("/itemLight.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.health = 100;
        this.angle = -1.57;
        this.loc = new Location(Map.WIDTH/2,Map.HEIGHT/2);
        name = n;

        //TODO - REMOVE
        inventory[0] = new TestGun();
    }

    public Location getLoc() {
        return loc;
    }

    public void moveX(double mult) {
        loc.setX(loc.getX() + (moveSpeed * mult));
    }

    public void moveY(double mult) {
        loc.setY(loc.getY() + (moveSpeed * mult));
    }

    public void setInventory(int inv) {
        invSelection = inv;
    }

    public void shiftInvUp() {
        if(invSelection < 4) {
            invSelection++;
        }else {
            invSelection = 0;
        }
    }

    public void shiftInvDown() {
        if(invSelection > 0) {
            invSelection--;
        }else {
            invSelection = 4;
        }
    }

    public void tick() {
        angle = Math.atan2(GameInfo.getInstance().getMouseY() - Game.HEIGHT/2, GameInfo.getInstance().getMouseX() - Game.WIDTH/2);
    }

    private void drawHand(Graphics g) {
        if(inventory[invSelection] == null) {
            //draw empty hands TODO
            return;
        }
        inventory[invSelection].render(g, this.angle);
    }

    public void drawInv(Graphics g) {
        for(int i=0; i<5; i++) {
            if(inventory[i] != null) {
                g.drawImage(inventory[i].getIcon(), Game.WIDTH - 260 + (i * 52), Game.HEIGHT - 52, 50, 50, null);
            }
        }

        g.drawImage(light, Game.WIDTH - 260 + (invSelection * 52), Game.HEIGHT - 52, 50, 50, null);
    }

    public void render(Graphics g, Location l) {
        g.drawImage(circle, Game.WIDTH/2 - 25, Game.HEIGHT/2 - 25, 50, 50, null);
        drawHand(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        g.drawString(name, Game.WIDTH/2 - (3*name.length()), Game.HEIGHT/2 - 27);
    }
}
