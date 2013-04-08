package States;

import GUI.Button;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class CharacterCreation extends BasicGameState {
    private TextField textField;
    private Font font;
    private boolean tfFocused;
    private Button createCharacter;
    private String text;

    public int getID() {
        return States.CharacterCreation.ordinal();
    }

    public void init(GameContainer gc, StateBasedGame game) throws SlickException {
        tfFocused = false;
        int width = 250;
        int height = 35;
        int posX = (gc.getWidth() / 2) - (width / 2);
        int posY = gc.getHeight() / 2 + (gc.getHeight() / 4);

        font = new TrueTypeFont(new java.awt.Font(java.awt.Font.SERIF, java.awt.Font.BOLD, 26), false);
        textField = new TextField(gc, font, posX, posY, width, height);

        textField.setMaxLength(10);
        textField.setText("Name");
    }

    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(Color.white);
        textField.setBackgroundColor(Color.white);
        textField.setTextColor(Color.black);
        textField.render(gc, g);
        g.setColor(Color.red);
        g.drawString("Character Creation", 200, 50);

        createCharacter = new Button(gc, g, "Create Character", gc.getWidth()/3, gc.getHeight()/2, 250, 25);
        createCharacter.addListener();
        if(createCharacter.isPressed()) {
            System.out.println(textField.getText());
            text = textField.getText();
        }
        if(text != null) {
            g.setColor(Color.red);
            g.drawString(text, gc.getWidth()/2, gc.getHeight()/2);
        }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) {
        Input input = gc.getInput();
        if(textField.hasFocus() && tfFocused == false) {
            textField.setText("");
            tfFocused = true;
        }

        if(input.isKeyPressed(Input.KEY_ESCAPE)) {
            sbg.enterState(States.MainMenu.ordinal());
        }
    }
}
