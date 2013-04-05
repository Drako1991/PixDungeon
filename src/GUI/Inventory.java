package GUI;

import Objects.Item;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

public class Inventory {
    private static Slot[] slots = new Slot[2];
    private static Item logoTest = new Item("logoTest", SlotTypes.Inventory, "res/logo.png");

    public static void Inventory(GameContainer gc, Graphics g) {
        slots[0] = new Slot(SlotTypes.Inventory, new Vector2f(gc.getWidth()/2, gc.getHeight()/2));
        slots[1] = new Slot(SlotTypes.Inventory, new Vector2f(gc.getWidth()/2 + 400, gc.getHeight()/2));

        slots[0].setItemInSlot(logoTest);
//        slots[1].setItemInSlot(logoTest);


        for(int i = 0; i < slots.length; i++) {
            slots[i].render(g);
            slots[i].update(gc, g);
        }
    }
}