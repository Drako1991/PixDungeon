package GUI;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.RoundedRectangle;
import org.newdawn.slick.geom.Vector2f;

public class Button {
    private boolean isPressed;
    private Vector2f pos, scale;
    private GameContainer gc;

    public boolean isPressed() {
        return isPressed;
    }

    public Button addListener() {
        if(gc.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            if(gc.getInput().getMouseX()>=pos.x && gc.getInput().getMouseX()<=pos.x + scale.x) {
                if(gc.getInput().getMouseY()>=pos.y && gc.getInput().getMouseY()<=pos.y + scale.y) {
                    isPressed = true;
                } else isPressed = false;
            } else isPressed = false;
        } else isPressed = false;
        return this;
    }

    public Button(GameContainer GC, Image img, Image onPressed, float x, float y, float w, float h) {
        if(!isPressed()) {
            img.draw(x, y, w, h);
        } else {
            onPressed.draw(x, y, w, h);
        }
        pos = new Vector2f(x, y);
        scale = new Vector2f(w, h);
        gc = GC;
    }

    public Button(GameContainer GC, Image img, float x, float y, float w, float h) {
        img.draw(x, y, w, h);
        pos = new Vector2f(x, y);
        scale = new Vector2f(w, h);
        gc = GC;
    }

    public Button(GameContainer GC, Graphics g, String s, Image img, float x, float y, float w, float h) {
        img.draw(x, y, w, h);
        g.drawString(s, x, y);
        pos = new Vector2f(x, y);
        scale = new Vector2f(w, h);
        gc = GC;
    }

    public Button(GameContainer GC, Graphics g, String s, float x, float y, float w, float h) {
        g.setColor(Color.white);
        g.fill(new RoundedRectangle(x, y, w, h, 0.3f));
        g.setColor(Color.black);
        g.drawString(s, x, y);
        pos = new Vector2f(x, y);
        scale = new Vector2f(w, h);
        gc = GC;
    }

    public Button(GameContainer GC, Graphics g, float x, float y, float w, float h) {
        g.fill(new RoundedRectangle(x, y, w, h, 0.3f));
        pos = new Vector2f(x, y);
        scale = new Vector2f(w, h);
        gc = GC;
    }

    public Button(GameContainer GC, Graphics g, Vector2f Pos, Vector2f Scale) {
        g.fill(new RoundedRectangle(pos.x, pos.y, scale.x, scale.y, 0.3f));
        pos = Pos;
        scale = Scale;
        gc = GC;
    }

    public Button setScale(float w, float h) {
        scale = new Vector2f(w, h);
        return this;
    }

    public Button setScale(Vector2f Scale) {
        scale = Scale;
        return this;
    }

    public Button setPos(float x, float y) {
        pos = new Vector2f(x, y);
        return this;
    }

    public Button setPos(Vector2f Pos) {
        pos = Pos;
        return this;
    }

    public Vector2f getPos() {
        return pos;
    }

    public Vector2f getScale() {
        return scale;
    }
}