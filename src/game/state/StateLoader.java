package game.state;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class StateLoader {

    private State currentState;

    public StateLoader(State s) {
        currentState = s;
    }

    public void loadState(State s) {
        currentState = s;
    }

    public void render(Graphics g) {
        currentState.render(g);
    }

    public void tick() {
        currentState.tick();
    }

    public void processMouseEvent(MouseEvent me) {
        currentState.processMouseEvent(me);
    }

    public void processKeyEventPress(KeyEvent ke) {
        currentState.processKeyEventPress(ke);
    }
    public void processKeyEventRelease(KeyEvent ke) {
        currentState.processKeyEventRelease(ke);
    }

    public void processMouseHold(MouseEvent e) {
        currentState.processMouseHold(e);
    }
    public void processMouseRelease(MouseEvent e) {
        currentState.processMouseRelease(e);
    }
}
