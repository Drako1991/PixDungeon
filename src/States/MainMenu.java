package States;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState {
    private enum Buttons {
        NewGame,
        LoadGame;
    }

    public int getID() {
        return States.MainMenu.ordinal();
    }

    public void init(GameContainer gc, StateBasedGame game) throws SlickException {
    }

    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(Color.white);
        g.drawString("Pix. Dungeon", 100, 100);
        g.setColor(Color.red);
        g.drawString("Main Menu", 200, 50);

//        Button.addMenuButton(Buttons.NewGame, gc, "Test", g, 1, Color.white, gc.getWidth() / 2, gc.getHeight() / 2);
//        Button.addMenuButton(Buttons.LoadGame, gc, "Test", g, 1, Color.white, gc.getWidth() / 2, gc.getHeight() / 4);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) {

/*        if(Button.getButtonPressed(Buttons.NewGame)) {
            System.out.println("Button Pressed");
        }*/

        if(sbg.getCurrentStateID() == getID()) {
            if(gc.getInput().isKeyPressed(Input.KEY_1)) {
                sbg.enterState(States.CharacterCreation.ordinal());
            }

            if(gc.getInput().isKeyPressed(Input.KEY_2)) {
                sbg.enterState(States.Playing.ordinal());
            }
        }
    }
}
