package Render;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

public class ImageRenderComponent extends RenderComponent {
    Image image;
    int scale;

    public ImageRenderComponent(String id, Image image, int scale) {
        super(id);
        this.image = image;
        this.scale = scale;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sb, Graphics g) {
//        Vector2f pos = owner.getPosition();
//        float scale = owner.getScale();
        image.draw(gc.getWidth() / 2, gc.getHeight() / 2, scale);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sb, int delta) {
        image.rotate(owner.getRotation() - image.getRotation());
    }
}