package Equipment;

public class Helm extends Armour {

    public Helm(int Armour, int Strength, int Vitality, int Intellect, int Dexterity, int Agility, int minLevel, String name, int Cost) {
        super(Armour, Strength, Vitality, Intellect, Dexterity, Agility, EquipmentType.Helm, minLevel, name, Cost);
    }

    public Helm(int Armour, int Strength, int Vitality, int Intellect, int Dexterity, int Agility, String name, int Cost) {
        super(Armour, Strength, Vitality, Intellect, Dexterity, Agility, EquipmentType.Helm, name, Cost);
    }
}