package GUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class CharacterCreation {

    public static void createWindow(GameContainer gc, Graphics g)
            throws SlickException {

        g.drawImage(new Image("res/archer.png"), 50, gc.getHeight() / 2);
        g.drawImage(new Image("res/assassin.png"), 100, gc.getHeight() / 2);
        g.drawImage(new Image("res/knight.png"), 150, gc.getHeight() / 2);
        g.drawImage(new Image("res/wizard.png"), 200, gc.getHeight() / 2);
    }
}