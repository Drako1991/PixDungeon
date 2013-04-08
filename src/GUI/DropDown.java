package GUI;

import org.newdawn.slick.geom.Vector2f;

public class DropDown {
    private Vector2f pos;
    private float scale;
    private String[] text;
    private int maxText;

    public DropDown render() {

        return this;
    }

    public DropDown(Vector2f pos, float scale, String[] text) {
        this.pos = pos;
        this.scale = scale;
        this.text = text;
        this.maxText = text.length;
    }

    public DropDown(Vector2f pos, String[] text) {
        this.pos = pos;
        this.text = text;
        this.maxText = text.length;
    }

    public DropDown setMaxText(int maxText) {
        this.maxText = maxText;
        return this;
    }

    public DropDown setPos(Vector2f pos) {
        this.pos = pos;
        return this;
    }

    public DropDown setScale(float scale) {
        this.scale = scale;
        return this;
    }

    public DropDown setText(String[] text) {
        this.text = text;
        this.maxText = text.length;
        return this;
    }

    public Vector2f getPos() {
        return pos;
    }

    public float getScale() {
        return scale;
    }

    public String[] getText() {
        return text;
    }

    public int getMaxText() {
        return maxText;
    }
}
