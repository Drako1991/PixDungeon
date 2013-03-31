package Main;

import Render.RenderComponent;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

public class Entity {
    String id;

    Vector2f position, scale;
    float scaleW, scaleH, rotation;

    RenderComponent renderComponent = null;

    ArrayList<Component> components = null;

    public Entity(String id) {
        this.id = id;

        components = new ArrayList<Component>();

        position = new Vector2f(0, 0);
        scaleW = 1;
        scaleH = 1;
        rotation = 0;
    }

    public void addComponent(Component component) {
        if(RenderComponent.class.isInstance(component))
            renderComponent = (RenderComponent) component;

        component.setOwnerEntity(this);
        components.add(component);
    }

    public Component getComponent(String id) {
        for(Component comp : components) {
            if(comp.getId().equalsIgnoreCase(id))
                return comp;
        }

        return null;
    }

    public Vector2f getPosition() {
        return position;
    }

    public float getRotation() {
        return rotation;
    }

    public Vector2f getScale() {
        return scale;
    }

    public String getId() {
        return id;
    }

    public void setPosition(Vector2f position) {
        this.position = position;
    }

    public void setRotation(float rotate) {
        rotation = rotate;
    }

    public void setScale(Vector2f scale) {
        this.scale = scale;
    }

    public void setScale(float width, float height) {
        this.scale = new Vector2f(width, height);
    }

    public void update(GameContainer gc, StateBasedGame sb, int delta) {
        for(Component component : components) {
            component.update(gc, sb, delta);
        }
    }

    public void render(GameContainer gc, StateBasedGame sb, Graphics g) {
        if(renderComponent != null)
            renderComponent.render(gc, sb, g);
    }
}