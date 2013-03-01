package Equipment;

public class Armour extends Equipable {
    private int Armour;

    public Armour(int Strength, int Vitality, int Intellect, int Dexterity, int Agility, EquipmentType type, String name, int Cost) {
        super(Strength, Vitality, Intellect, Dexterity, Agility, type, name, Cost);

        setMinLevel(1);
        setArmour(0);
    }

    public Armour(int Strength, int Vitality, int Intellect, int Dexterity, int Agility, EquipmentType type, int minLevel, String name, int Cost) {
        super(Strength, Vitality, Intellect, Dexterity, Agility, type, minLevel, name, Cost);

        setArmour(0);
    }

    public Armour(int Armour, int Strength, int Vitality, int Intellect, int Dexterity, int Agility, EquipmentType type, int minLevel, String name, int Cost) {
        super(Strength, Vitality, Intellect, Dexterity, Agility, type, minLevel, name, Cost);

        setArmour(Armour);
    }

    public Armour(int Armour, int Strength, int Vitality, int Intellect, int Dexterity, int Agility, EquipmentType type, String name, int Cost) {
        super(Strength, Vitality, Intellect, Dexterity, Agility, type, name, Cost);

        setMinLevel(1);
        setArmour(Armour);
    }

    public void setArmour(int Armour) {

        this.Armour = Armour;
    }

    public int getArmour() {

        return this.Armour;
    }
}