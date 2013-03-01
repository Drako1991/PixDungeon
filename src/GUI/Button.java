package GUI;

import org.newdawn.slick.*;

public class Button {
    private static boolean[] buttonPressed = null;
    //TODO: Make buttons actualy work, and send an output when it is pressed

    public static void addMenuButton(Enum ID, GameContainer gc, String text, Graphics g, int mlr, Color clr, float x, float y) throws SlickException {
        float TextX = 0;
        UnicodeFont myFont = new UnicodeFont("res/fonts/pixelated.ttf", 20, false, false);
        Image img = new Image("res/knight.png");

        g.drawImage(img, x, y);

        g.setColor(clr);

        if (mlr == 0) {
            TextX = x + myFont.getWidth(text) / 2;
        }
        if (mlr == 1) {
            TextX = x;
        }
        if (mlr == 2) {
            TextX = x + img.getWidth();
        }

        g.drawString(text, TextX, y + myFont.getHeight(text) / 2);

        if (gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            int mouseX = gc.getInput().getMouseX();
            int mouseY = gc.getInput().getMouseY();

            if (mouseX >= x && mouseX <= x + img.getWidth()) {
                if (mouseY >= y && mouseY <= y + img.getHeight()) {
//                    buttonPressed[ID.ordinal()] = true;
                    System.out.println("Button Pressed! @ " + x + ", " + y);
                }
            }
        }
    }

    public static boolean getButtonPressed(Enum ID) {
        return buttonPressed[ID.ordinal()];
    }
}