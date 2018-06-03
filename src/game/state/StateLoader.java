package game.state;

import java.awt.*;

public class StateLoader {

    private State state;

    public StateLoader(State s) {
        this.state = s;
    }

    public void loadState(State s) {
        this.state = s;
    }

    public void render(Graphics g) {
        state.render(g);
    }

    public void tick() {
        state.tick();
    }

}
