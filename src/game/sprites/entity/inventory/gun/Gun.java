package game.sprites.entity.inventory.gun;

import game.sprites.entity.inventory.Item;

import java.awt.*;

public abstract class Gun extends Item {

    public void useOne() {
        fire();
    }

    public abstract void fire();

    public abstract void render(Graphics g, double angle);

}