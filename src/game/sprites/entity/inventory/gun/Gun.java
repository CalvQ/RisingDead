package game.sprites.entity.inventory.gun;

import game.sprites.entity.inventory.Item;

import java.awt.*;

public abstract class Gun extends Item {

    int cd;

    static Image gun, icon;

    public void useOne() {
        fire();
    }

    public abstract void tick();

    public abstract void fire();

    public abstract void render(Graphics g, double angle);

    public Image getIcon() {
        return icon;
    }

}