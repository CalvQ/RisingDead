package game.main;

import game.sprites.Location;

public class GameInfo {
    private static GameInfo ourInstance = new GameInfo();

    private static float volume = 1.0f; //0.0f-1.0f
    private Location mouseP;

    public static GameInfo getInstance() {
        return ourInstance;
    }

    private GameInfo() {
    }

    public void setVol(float x) {
        volume = x;
        Music.updateVolume();
    }

    public float getVol() {
        return volume;
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
