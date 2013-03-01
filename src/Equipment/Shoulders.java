package Equipment;

public class Shoulders extends Armour {

    public Shoulders(int Armour, int Strength, int Vitality, int Intellect, int Dexterity, int Agility, EquipmentType type, int minLevel, String name, int Cost) {
        super(Armour, Strength, Vitality, Intellect, Dexterity, Agility, type, minLevel, name, Cost);
    }

    public Shoulders(int Armour, int Strength, int Vitality, int Intellect, int Dexterity, int Agility, EquipmentType type, String name, int Cost) {
        super(Armour, Strength, Vitality, Intellect, Dexterity, Agility, type, name, Cost);
    }
}