package game.main;

import game.sprites.Location;

public class GameInfo {
    private static GameInfo ourInstance = new GameInfo();

    private Location mouseP;

    public static GameInfo getInstance() {
        return ourInstance;
    }

    private GameInfo() {
    }

    public void setMouseP(Location l) {
        mouseP = l;
    }

    public Location getMouseP() {
        return mouseP;
    }
}
