package game.main;

import javax.sound.sampled.*;
import java.io.IOException;

public class Music {
    private final static String[] songs = new String[2];
    private static Clip clip;

    public static void initSongs() {
        songs[0] = "Necromancy.wav";
    }

    public static void playMusic() {
        try {
//            //random generate an index
//            int i = (int) (Math.random() * songs.length);

            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Music.class.getResource("/songs/" + songs[0])));
//            FloatControl gainControl =
//                    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
//            gainControl.setValue(-10.0f);
            clip.start();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

}
