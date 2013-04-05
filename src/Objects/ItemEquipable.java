package Objects;

import GUI.SlotTypes;

public class ItemEquipable extends Item {
    private int Strength, Dexterity, Intellect, Agility;

    public ItemEquipable(String name, SlotTypes Type, int Str, int Dex, int Int, int Agi) {
        super(name, Type);

        Strength = Str;
        Dexterity = Dex;
        Intellect = Int;
        Agility = Agi;
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