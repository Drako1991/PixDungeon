package GUI;

import Objects.Item;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Inventory {
    private static Slot[] slots = new Slot[42];
    private static Item logoTest = new Item("logoTest", SlotTypes.Inventory, "res/logo.png");

    public static void Inventory(GameContainer gc, Graphics g) {
        for(int x = 0; x <= 5; x++) {
            for(int y = 0; y <= 6; y++) {
                slots[x + (y*5) + y] = new Slot(SlotTypes.Inventory, new Vector2f(gc.getWidth() - 75 -(x*50), gc.getHeight()/2 + y*50));
                slots[x + (y*5) + y].setItemInSlot(logoTest);
            }
        }
        try{
            Image img = new Image("res/GUI/Inventory.png");
            img.draw(gc.getWidth() - 332.5f, 21);
        }catch(SlickException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < slots.length; i++) {
            slots[i].update(gc, g);
        }
    }
}