package game.sprites.entity.inventory.gun;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class AWP extends Gun{

    public void initImage() {
        if(icon == null) {
            try {
                icon = ImageIO.read(TestGun.class.getResource("/guns/AWP.png"));
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void fire() {

    }

    public void render(Graphics g, double angle) {

    }

}
