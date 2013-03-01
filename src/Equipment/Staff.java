package Equipment;

public class Staff extends Weapon {

    public Staff(int Strength, int Vitality, int Intellect, int Dexterity, int Agility, double Damage, double Speed, EquipmentType type, int minLevel, String name, int Cost) {
        super(Strength, Vitality, Intellect, Dexterity, Agility, Damage, Speed, type, minLevel, name, Cost);

    }

    public Staff(int Strength, int Vitality, int Intellect, int Dexterity, int Agility, double Damage, double Speed, EquipmentType type, String name, int Cost) {
        super(Strength, Vitality, Intellect, Dexterity, Agility, Damage, Speed, type, name, Cost);
    }
}
