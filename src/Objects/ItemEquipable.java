package Objects;

import GUI.Slot;
import GUI.ToolTip;
import GUI.Types;
import States.Game;
import org.newdawn.slick.geom.Vector2f;

public class ItemEquipable extends Item {
    private int Strength, Dexterity, Intellect, Agility;
    private ToolTip tt;
    private String[] ttText;

    public ItemEquipable(String name, Types.SlotTypes Type, Slot slot, int Str, int Dex, int Int, int Agi, String imgRef) {
        super(name, Type, slot, imgRef);

        Strength = Str;
        Dexterity = Dex;
        Intellect = Int;
        Agility = Agi;

        String[] text = {
            "Strength: " + Strength, "Dexterity: " + Dexterity, "Intellect: " + Intellect, "Agility: " + Agility
        };

        ttText = text;
    }

//    public void update() {
//        if(isHoveredOver()) {
//            tt.showToolTip(Game.getGraphics());
//        }
//    }

    public ItemEquipable showTooltip() {
        tt = new ToolTip(Types.ttTypes.Weapon, new Vector2f(Game.getGameContainer().getInput().getMouseX()+10, Game.getGameContainer().getInput().getMouseY()+10), getName(), ttText);
        tt.showToolTip(Game.getGraphics());
        return this;
    }

    public int getStrength() {
        return Strength;
    }

    public int getDexterity() {
        return Dexterity;
    }

    public int getIntellect() {
        return Intellect;
    }

    public int getAgility() {
        return Agility;
    }
}