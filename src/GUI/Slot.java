package GUI;

import Objects.Item;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.RoundedRectangle;
import org.newdawn.slick.geom.Vector2f;

public class Slot {
    private Vector2f pos;
    private float scale = 48;
    private boolean isHoveredOver, isSelected;
    private SlotTypes type;
    private Item itemInSlot;
    private int slotID = 0;

    public Slot(SlotTypes Type, Vector2f Pos) {
        pos = Pos;
        type = Type;
    }

    public Slot(SlotTypes Type, Vector2f Pos, int ID) {
        pos = Pos;
        type = Type;
        slotID = ID;
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
        if(item.getSlotType() == type) {
            itemInSlot = item;
        }
        return this;
    }

    public Slot setSelected(boolean selected) {
        isSelected = selected;
        return this;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public SlotTypes getType() {
        return type;
    }

    public int getSlotID() {
        return slotID;
    }

    public Slot setHovered(boolean hover) {
        isHoveredOver = hover;
        return this;
    }

    public Slot update(GameContainer gc, Graphics g) {
        if(itemInSlot != null) {
            g.setColor(Color.white);
            g.texture(new RoundedRectangle(pos.x, pos.y, scale, scale, 5F), itemInSlot.getImage(), true);
        }

        if(gc.getInput().getMouseX() >= pos.x && gc.getInput().getMouseX() <= pos.x + scale) {
            if(gc.getInput().getMouseY() >= pos.y && gc.getInput().getMouseY() <= pos.y + scale) {
                isHoveredOver = true;
                g.setColor(new Color(255, 255, 255, 100));
                g.fill(new RoundedRectangle(pos.x, pos.y, scale, scale, 5F));
                if(gc.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                    isSelected= true;
                }
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