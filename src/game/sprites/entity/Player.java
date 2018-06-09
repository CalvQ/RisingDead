package game.sprites.entity;

import game.sprites.Location;
import game.sprites.environment.Map;

import java.awt.*;

public class Player extends Entity {

    private String name;
    private Location loc;

    public Player(String n) {
        this.health = 100;
        this.angle = -1.57;
        this.loc = new Location(Map.WIDTH/2,Map.HEIGHT/2);
        name = n;
    }

    public void render(Graphics g) {

    }
}
