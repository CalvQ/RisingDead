package game.sprites.entity;

import game.sprites.Location;

import java.awt.*;

public abstract class Entity {

    int health;
    double angle;

    public double getAngle() {
        return angle;
    }

    public abstract void render(Graphics g, Location l);

}
