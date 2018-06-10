package game.main;

import javax.sound.sampled.*;
import java.io.IOException;

public class Music {

    public enum Mode {
        MENU, GAME
    }

    private final static String[] songs = new String[1];
    private static Clip clip;
    private static Mode mode = Mode.MENU;

    public static void initSongs() {
        songs[0] = "Necromancy.wav";
    }

    public static void playMusic() {
        try {
            clip = AudioSystem.getClip();

            switch (mode) {
                case MENU:
                    clip.open(AudioSystem.getAudioInputStream(Music.class.getResource("/songs/Menu.wav")));
                    break;
                case GAME:
                    //random generate an index
                    int i = (int) (Math.random() * songs.length);

                    clip.open(AudioSystem.getAudioInputStream(Music.class.getResource("/songs/" + songs[i])));
                    break;
            }
            clip.start();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public static void setMode(Music.Mode m) {
        mode = m;
        clip.stop();
        clip = null;
        playMusic();
    }

    public static boolean isNotRunning() {
        return !clip.isRunning();
    }

    public static void stop() {
        clip.stop();
        clip = null;
    }

}
