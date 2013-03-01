package GUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Inventory {
    public void Inventory(GameContainer gc, Graphics g) throws SlickException {
        int posX = 0;
        int posY = 0;
        g.drawImage(new Image("res/inventory.png"), posX, posY);
    }
}
