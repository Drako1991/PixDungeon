package States;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class PauseMenu extends BasicGameState {
    private enum Buttons {
        ResumeGame,
        Options,
        QuitGame;
    }

    public int getID() {
        return States.PauseMenu.ordinal();
    }

    public void init(GameContainer gc, StateBasedGame game) throws SlickException {
    }

    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(Color.red);
        g.drawString("Pause Menu", 200, 50);

//        Button.addMenuButton(Buttons.ResumeGame, gc, "Resume Game", g, 1, Color.white, gc.getWidth() / 2, gc.getHeight() / 2);
//        Button.addMenuButton(Buttons.Options, gc, "Options", g, 1, Color.white, gc.getWidth() / 2, (gc.getHeight() / 2) - 10);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) {

        if (sbg.getCurrentStateID() == States.PauseMenu.ordinal()) {
            if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
                sbg.enterState(States.Playing.ordinal());
            }

            if (gc.getInput().isKeyPressed(Input.KEY_1)) {
                sbg.enterState(States.MainMenu.ordinal());
            }
        }
    }
}
