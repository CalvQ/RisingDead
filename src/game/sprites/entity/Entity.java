package game.sprites.entity;

import java.awt.*;

public abstract class Entity {

    int health;
    double angle;

    public double getAngle() {
        return angle;
    }

    public abstract void render(Graphics g);

}
