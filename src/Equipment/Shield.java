package Equipment;

public class Shield extends Weapon {

    public Shield(int Strength, int Vitality, int Intellect, int Dexterity, int Agility, double Damage, double Speed, double Block, EquipmentType type, int minLevel, String name, int Cost) {
        super(Strength, Vitality, Intellect, Dexterity, Agility, Damage, Speed, type, minLevel, name, Cost);

        setBlock(Block);

    }

    public Shield(int Strength, int Vitality, int Intellect, int Dexterity, int Agility, double Damage, double Speed, double Block, EquipmentType type, String name, int Cost) {
        super(Strength, Vitality, Intellect, Dexterity, Agility, Damage, Speed, type, name, Cost);

        setBlock(Block);
    }
}