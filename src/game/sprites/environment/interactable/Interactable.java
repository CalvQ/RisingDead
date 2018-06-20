package game.sprites.environment.interactable;

import game.sprites.Location;

public interface Interactable{

    public boolean inProx(Location l);
    public void interact();

}
