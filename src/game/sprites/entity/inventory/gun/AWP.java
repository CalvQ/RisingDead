package game.sprites.entity.inventory.gun;

import game.main.Game;
import game.main.Music;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class AWP extends Gun{

    private static final int FIRE_RATE = 120;

    public void initImage() {
        if (gun == null) {
            try {
                gun = ImageIO.read(AWP.class.getResource("/guns/AWP Gun.png"));
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(icon == null) {
            try {
                icon = ImageIO.read(AWP.class.getResource("/guns/AWP.png"));
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void fire() {
        if(cd != 0) {
            return;
        }
        System.out.println("Fired");
        Music.fire("AWP");
        cd = FIRE_RATE;
    }

    public void tick() {
        if(cd > 0) {
            cd--;
        }
    }

    public void render(Graphics g, double angle) {
        g.translate(Game.WIDTH/2, Game.HEIGHT/2);
        ((Graphics2D)g).rotate(angle);
        g.drawImage(gun, 7, -10, 100, 20,null);
        ((Graphics2D)g).rotate(-angle);
        g.translate(-Game.WIDTH/2, -Game.HEIGHT/2);
    }

}
