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

    public double getMouseX() {
        if(mouseP == null) {
            mouseP = new Location(0,0);
        }
        return mouseP.getX();
    }

    public double getMouseY() {
        if(mouseP == null) {
            mouseP = new Location(0,0);
        }
        return mouseP.getY();
    }

    public Location getMouseP() {
        if(mouseP == null) {
            mouseP = new Location(0,0);
        }
        return mouseP;
    }
}
