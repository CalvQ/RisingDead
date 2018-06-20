package game.sprites.entity.inventory;

import game.sprites.entity.inventory.gun.*;

import java.awt.*;

public abstract class Item {

    private static final Item[] items = {new AWP(), new TestGun()};

    public abstract void initImage();

    public abstract void useOne();

    public abstract void render(Graphics g, double angle);

    public abstract Image getIcon();

    public static Item randItem() {
        return items[(int) (Math.random() * items.length)];
    }

    public static void initImages() {
        for(Item i:items) {
            i.initImage();
        }
    }
}
