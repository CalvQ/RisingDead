package game.sprites.entity.inventory.gun;

import game.main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TestGun extends Gun {

    public void initImage() {
        if(gun == null) {
            try {
                gun = ImageIO.read(TestGun.class.getResource("/ClipGun.png"));
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(icon == null) {
            try {
                icon = ImageIO.read(TestGun.class.getResource("/guns/PixelArt (4).png"));
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void fire() {
        System.out.println("here");
    }

    public void tick() {

    }

    public void render(Graphics g, double angle) {
        g.translate(Game.WIDTH/2, Game.HEIGHT/2);
        ((Graphics2D)g).rotate(angle);
        g.drawImage(gun, 10, -3, 60, 7, null);
        ((Graphics2D)g).rotate(-angle);
        g.translate(-Game.WIDTH/2, -Game.HEIGHT/2);
    }

}
