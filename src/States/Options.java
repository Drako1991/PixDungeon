package States;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Options extends BasicGameState {
    public static boolean isVSync, isFrameLimit;

    private enum Buttons {

    }

    public int getID() {
        return States.Options.ordinal();
    }

    public void init(GameContainer gc, StateBasedGame game) throws SlickException {
        isVSync = true;
        isFrameLimit = false;
    }

    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(Color.red);
        g.drawString("Options", 200, 50);

//        Button.addMenuButton(gc, "Test", g, 1, Color.red, gc.getWidth() / 2, gc.getHeight() / 2);
    }

    public void update(GameContainer container, StateBasedGame game, int delta) {
    }
}
