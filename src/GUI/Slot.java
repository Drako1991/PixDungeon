package GUI;

import Objects.Item;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class Slot {
    private Vector2f pos;
    private float scale = 64;
    private boolean isHoveredOver;
    private SlotTypes type;
    private Item itemInSlot;

    public Slot(SlotTypes Type, Vector2f Pos) {
        pos = Pos;
        type = Type;
    }

    public Slot(SlotTypes Type, Vector2f Pos, float Scale) {
        pos = Pos;
        scale = Scale;
        type = Type;
    }

    public Slot setScale(float Scale) {
        scale = Scale;
        return this;
    }

    public Slot setItemInSlot(Item item) {
        itemInSlot = item;
        return this;
    }

    public SlotTypes getType() {
        return type;
    }

    public Slot setHovered(boolean hover) {
        isHoveredOver = hover;
        return this;
    }

    public Slot render(Graphics g) {
        if(isHoveredOver) {
            g.setColor(new Color(255, 255, 255, 100));
            g.fill(new Rectangle(pos.x, pos.y, scale, scale));
        }
        if(itemInSlot != null) {
            itemInSlot.getImage().draw(pos.x, pos.y, scale, scale);
        }
        return this;
    }

    public Slot update(GameContainer gc) {
        if(gc.getInput().getMouseX() >= pos.x && gc.getInput().getMouseX() <= pos.x + scale) {
            if(gc.getInput().getMouseY() >= pos.y && gc.getInput().getMouseY() <= pos.y + scale) {
                isHoveredOver = true;
            }else isHoveredOver = false;
        }else isHoveredOver = false;
        return this;
    }

    public Vector2f getPos() {
        return pos;
    }

    public float getScale() {
        return scale;
    }

    public Item getItemInSlot() {
        return itemInSlot;
    }

    public boolean getHovered() {
        return isHoveredOver;
    }
}