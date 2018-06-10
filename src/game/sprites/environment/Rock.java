package game.sprites.environment;

import game.sprites.Location;

public class Rock {

    public enum Size{
        SMALL, MEDIUM, LARGE
    }

    private Location loc;
    private Size size;

    public Location getLoc() {
        return loc;
    }

    public Size getSize() {
        return size;
    }

    public Rock(Size s, Location l) {
        loc = l;
        size = s;
    }
}
