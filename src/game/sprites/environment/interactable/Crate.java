package game.sprites.environment.interactable;

import game.sprites.Location;
import game.sprites.entity.inventory.Item;

public class Crate implements Interactable{

    private Location loc;
    private Item item;

    public Crate(Location l) {
        loc = l;
    }

    public boolean inProx(Location l) {
        return Math.pow(Math.pow(loc.diffX(l), 2) + Math.pow(loc.diffY(l), 2), 0.5) <= 50;
    }

    public void interact() {

    }
}
