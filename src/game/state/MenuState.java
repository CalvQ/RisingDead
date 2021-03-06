package game.state;

import game.main.Game;
import game.main.GameInfo;
import game.main.Music;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MenuState extends State {

    private static Image play, tutorial, title;
    private static Image playH, tutorialH;
    private static Image skull;
    private static Image speakR, speakW;
    private boolean hPlay, hTutorial;
    private boolean hSpeak;

    private void initImages() {
        try {
            play = ImageIO.read(getClass().getResource("/play.png"));
            tutorial = ImageIO.read(getClass().getResource("/tutorial.png"));
            title = ImageIO.read(getClass().getResource("/title.png"));
            playH = ImageIO.read(getClass().getResource("/playH.png"));
            tutorialH = ImageIO.read(getClass().getResource("/tutorialH.png"));
            skull = ImageIO.read(getClass().getResource("/skull.png"));
            speakR = ImageIO.read(getClass().getResource("/speakR.png"));
            speakW = ImageIO.read(getClass().getResource("/speakW.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MenuState() {
        if(play == null) {
            Music.initSongs();
            initImages();
            Music.playMusic();
        }
    }

    public void render(Graphics g) {
        State.drawBackground(g, "grey");

        g.drawImage(title, Game.WIDTH/2 - 400, 50, 800, 300, null);

        g.drawImage(skull, Game.WIDTH - 186, Game.HEIGHT/2 + 50, null);
        g.drawImage(skull, 50, Game.HEIGHT/2 + 50, null);

        if(hPlay) {
            g.drawImage(playH, Game.WIDTH / 2 - 125, Game.HEIGHT / 2 - 40, 250, 200, null);
        }else {
            g.drawImage(play, Game.WIDTH / 2 - 125, Game.HEIGHT / 2 - 40, 250, 200, null);
        }

        if(hTutorial) {
            g.drawImage(tutorialH, Game.WIDTH / 2 - 222, Game.HEIGHT / 2 + 100, 445, 200, null);
        }else {
            g.drawImage(tutorial, Game.WIDTH / 2 - 222, Game.HEIGHT / 2 + 100, 445, 200, null);
        }

        if(hSpeak) {
            g.drawImage(speakW, 0, Game.HEIGHT - 42, 42, 42, null);
            g.setColor(Color.WHITE);
            g.fillRect(60, Game.HEIGHT - 25, 300, 10);
            g.setColor(new Color(188, 50, 40));
            g.fillRect(60 + (int) (300 * GameInfo.getInstance().getVol()), Game.HEIGHT - 30, 2, 20);

        } else {
            g.drawImage(speakR, 0, Game.HEIGHT - 42, 42, 42, null);
        }
    }

    public void tick() {
        int x = (int) GameInfo.getInstance().getMouseX();
        int y = (int) GameInfo.getInstance().getMouseY();

        hPlay = x >= Game.WIDTH / 2 - 125 && x <= Game.WIDTH / 2 + 125 && y >= Game.HEIGHT / 2 - 40 && y <= Game.HEIGHT / 2 + 80;
        hTutorial = x >= Game.WIDTH / 2 - 222 && x <= Game.WIDTH / 2 + 222 && y >= Game.HEIGHT / 2 + 100 && y <= Game.HEIGHT / 2 + 220;
        if(x >= 0 && x <= 42 && y <= Game.HEIGHT && y >= Game.HEIGHT - 42) {
            hSpeak = true;
        }
        if(y <= Game.HEIGHT - 42 || x > 360) {
            hSpeak = false;
        }

        if(Music.isNotRunning()) {
            Music.playMusic();
        }
    }

    public void processMouseEvent(MouseEvent me) {
        float x = (float) GameInfo.getInstance().getMouseX();

        if(hPlay) {
            Game.loadState(new ConnectState());
        }

        if(hTutorial) {
            Game.loadState(new TutorialState());
            Music.setMode(Music.Mode.TUTORIAL);
        }

        if(hSpeak && x >= 60 && x <= 360) {
            GameInfo.getInstance().setVol((x-60)/300);
        }
    }

    public void processKeyEventPress(KeyEvent ke) {

    }

    public void processKeyEventRelease(KeyEvent ke) {

    }

    public void processMouseHold(MouseEvent e) {

    }

    public void processMouseRelease(MouseEvent e) {

    }

}
