package game.sprites.entity.inventory.gun;

import game.main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class M16 extends Gun{


    public void fire() {

    }

    public void tick() {

    }

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
                icon = ImageIO.read(TestGun.class.getResource("/guns/AWP.png"));
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void render(Graphics g, double angle) {//TODO
        g.translate(Game.WIDTH/2, Game.HEIGHT/2);
        ((Graphics2D)g).rotate(angle);
        g.drawImage(gun, 10, -3, 60, 7, null);
        ((Graphics2D)g).rotate(-angle);
        g.translate(-Game.WIDTH/2, -Game.HEIGHT/2);
    }
}
