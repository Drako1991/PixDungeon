package GUI;

import org.newdawn.slick.geom.Vector2f;

public class Slot {
    private Vector2f pos;
    private float scale = 64;
    private boolean isHoveredOver;
    private SlotTypes type;

    public Slot(SlotTypes Type, Vector2f Pos) {
        pos = Pos;
        type = Type;
    }

    public Slot(SlotTypes Type, Vector2f Pos, float Scale) {
        pos = Pos;
        scale = Scale;
        type = Type;
    }

    public SlotTypes getType() {
        return type;
    }

    public Slot setHovered(boolean hover) {
        isHoveredOver = hover;
        return this;
    }

    public boolean getHovered() {
        return isHoveredOver;
    }
}