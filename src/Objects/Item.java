package Objects;

import GUI.Slot;
import GUI.SlotTypes;
import States.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Item {
    private String itemName;
    private SlotTypes slotType;
    private boolean isSelected, onGround;
    private Vector2f selectedPos, pos, scale = new Vector2f(64, 64);
    private Slot slot;
    private GameContainer gc = Game.getGameContainer();
    private Image itemImage;

    public void update() {
        if(gc.getInput().getMouseX() >= slot.getPos().x && gc.getInput().getMouseX() <= slot.getPos().x + slot.getScale()) {
            if(gc.getInput().getMouseY() >= slot.getPos().y && gc.getInput().getMouseY() <= slot.getPos().y + slot.getScale()) {
                if(gc.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                    isSelected = true;
                }else isSelected = false;
            }else isSelected = false;
        }else isSelected = false;

        if(isSelected) {
            selectedPos = new Vector2f(gc.getInput().getMouseX(), gc.getInput().getMouseY());
            pos = selectedPos;
        }else{
            pos = slot.getPos();
        }
    }

    public void render() {
        if(isSelected) {
            itemImage.draw(pos.x, pos.y, slot.getScale());
        }else{
            itemImage.draw(pos.x, pos.y, 64);
        }
    }

    public Item(String Name, SlotTypes Slot, String imgRef) {
        itemName = Name;
        slotType = Slot;
        try{
            itemImage = new Image(imgRef);
        }catch(SlickException e) {
            e.printStackTrace();
        }
    }

    public Item(String Name, SlotTypes Slot, Image img) {
        itemName = Name;
        slotType = Slot;
        itemImage = img;
    }

    public Item(String Name, SlotTypes Slot) {
        itemName = Name;
        slotType = Slot;
    }

    public Item setImage(String imgRef) {
        try{
            itemImage = new Image(imgRef);
        }catch(SlickException e){
            e.printStackTrace();
        }
        return this;
    }

    public Item setImage(Image img) {
        itemImage = img;
        return this;
    }

    public Item drop() {
        onGround = true;
        return this;
    }

    public Item toggleSelected() {
        isSelected = !isSelected;
        return this;
    }

    public Item setSelected(boolean selected) {
        isSelected = selected;
        return this;
    }

    public Item setSelected() {
        isSelected = true;
        return this;
    }

    public Item setUnselected() {
        isSelected = false;
        return this;
    }

    public Item setSlot(Slot Slot) {
        slot = Slot;
        return this;
    }

    public Item setSlotType(SlotTypes Slot) {
        slotType = Slot;
        return this;
    }

    public Item setName(String name) {
        itemName = name;
        return this;
    }

    public Image getImage() {
        return itemImage;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public boolean isDropped() {
        return onGround;
    }

    public Slot getSlot() {
        return slot;
    }

    public SlotTypes getSlotType() {
        return slotType;
    }

    public String getName() {
        return itemName;
    }
}