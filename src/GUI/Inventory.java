package GUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Inventory {
    private static Slot[] slots = new Slot[42];
    private static Image bgImage;

    public static void initInventory(GameContainer gc) {
        try {
            bgImage = new Image("res/GUI/Inventory.png");
        } catch(SlickException e) {
            e.printStackTrace();
        }
        for(int x = 0; x<=5; x++) {
            for(int y = 0; y<=6; y++) {
                slots[x + (y * 5) + y] = new Slot(Types.SlotTypes.Inventory, new Vector2f(gc.getWidth() - 75 - (x * 50), gc.getHeight() / 2 + y * 50), x + (y * 5) + y);
            }
        }
    }

    public static void Inventory(GameContainer gc, Graphics g) {
        bgImage.draw(gc.getWidth() - 332.5f, 21);
        for(int i = 0; i < slots.length; i++) {
            slots[i].update(gc, g);
        }
    }

    public static int getMaxSlots() {
        return slots.length;
    }

    public static Slot getSlot(int ID) {
        return slots[ID];
    }
}