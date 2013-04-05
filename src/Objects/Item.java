package Objects;

import GUI.Inventory;
import GUI.Slot;
import GUI.Types;
import States.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Item {
    private String itemName;
    private Types.SlotTypes slotType;
    private boolean isSelected, onGround, isSelectedOverride, isHoveredOver;
    private Vector2f selectedPos, pos, scale = new Vector2f(64, 64);
    private Slot slot;
    private GameContainer gc = Game.getGameContainer();
    private Image itemImage;
    private Graphics g;

    public void update() {
        if(isSelected | isSelectedOverride) {
            pos = new Vector2f(gc.getInput().getMouseX(), gc.getInput().getMouseY());
            System.out.println("isSelected");
        }else{
            pos = new Vector2f(gc.getInput().getMouseX(), gc.getInput().getMouseY());
//            pos = slot.getPos();
        }
//        itemImage.draw(pos.x, pos.y, scale.x, scale.y);

        if(gc.getInput().getMouseX() >= pos.x && gc.getInput().getMouseX() <= pos.x + scale.x) {
            if(gc.getInput().getMouseY() >= pos.y && gc.getInput().getMouseY() <= pos.y + scale.y) {
                isHoveredOver = true;
            }else isHoveredOver = false;
        }else isHoveredOver = false;
    }

    public void render() {
        if(isSelected) {
            itemImage.draw(pos.x, pos.y, slot.getScale());
        }else{
            itemImage.draw(pos.x, pos.y, 64);
        }
    }

    public Item addToInventory() {
        for(int i = 0; i < Inventory.getMaxSlots(); i++) {
            if(Inventory.getSlot(i) == null) {
                slot = Inventory.getSlot(i);
                Inventory.getSlot(i).setItemInSlot(this);
            }
        }
        return this;
    }

    public Item addToInventory(int slot) {
        this.slot = Inventory.getSlot(slot);
        Inventory.getSlot(slot).setItemInSlot(this);
        return this;
    }

    public Item(String Name, Types.SlotTypes slotType, Slot slot, String imgRef) {
        itemName = Name;
        this.slotType = slotType;
        this.slot = slot;
        slot.setItemInSlot(this);
        try{
            itemImage = new Image(imgRef);
        }catch(SlickException e) {
            e.printStackTrace();
        }
    }

    public Item(String Name, Types.SlotTypes Slot, Image img) {
        itemName = Name;
        slotType = Slot;
        itemImage = img;
    }

    public Item(String Name, Types.SlotTypes Slot) {
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
        isSelectedOverride = !isSelected;
        return this;
    }

    public Item setSelected(boolean selected) {
        isSelectedOverride = selected;
        return this;
    }

    public Item setSelected() {
        isSelectedOverride = true;
        return this;
    }

    public Item setUnselected() {
        isSelectedOverride = false;
        return this;
    }

    public Item setSlot(Slot Slot) {
        slot = Slot;
        return this;
    }

    public Item setSlotType(Types.SlotTypes Slot) {
        slotType = Slot;
        return this;
    }

    public Item setName(String name) {
        itemName = name;
        return this;
    }

    public Vector2f getPos() {
        return pos;
    }

    public boolean isHoveredOver() {
        return isHoveredOver;
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

    public Types.SlotTypes getSlotType() {
        return slotType;
    }

    public String getName() {
        return itemName;
    }
}