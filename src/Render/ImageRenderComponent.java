package Render;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class ImageRenderComponent extends RenderComponent {
    Image image;
    Vector2f scale = new Vector2f(0, 0);

    public ImageRenderComponent(String id, Image image, float scaleW, float scaleH) {
        super(id);
        this.image = image;
        this.scale.x = scaleW;
        this.scale.y = scaleH;
    }

    public ImageRenderComponent(String id, Image img, Vector2f scale) {
        super(id);
        image = img;
        this.scale = scale;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sb, Graphics g) {
//        Vector2f pos = owner.getPosition();
//        float scale = owner.getScale();
        image.draw(gc.getWidth() / 2, gc.getHeight() / 2, scale.x, scale.y);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sb, int delta) {
        image.rotate(owner.getRotation() - image.getRotation());
    }
}