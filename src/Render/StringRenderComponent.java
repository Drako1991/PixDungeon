package Render;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class StringRenderComponent extends RenderComponent {
    String text;
    Color color;

    public StringRenderComponent(String id, String text, Color clr) {
        super(id);
        this.text = text;
        this.color = clr;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sb, Graphics g) {
        Vector2f pos = owner.getPosition();
        g.setColor(this.color);
        g.drawString(text, pos.x, (gc.getHeight()/2)-20);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sb, int delta) {

    }
}