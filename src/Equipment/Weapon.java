package Equipment;

import ElementalStats.ElementalTypes;

public class Weapon extends Equipable {
    private double Damage, Speed, Block;
    private boolean isElemental;
    private ElementalTypes ElementalType;

    public Weapon(int Strength, int Vitality, int Intellect, int Dexterity, int Agility, double Damage, double Speed, EquipmentType type, int minLevel, String name, double Block, int Cost) {
        super(Strength, Vitality, Intellect, Dexterity, Agility, type, minLevel, name, Cost);

        setDamage(Damage);
        setSpeed(Speed);
        setBlock(Block);
    }

    public Weapon(int Strength, int Vitality, int Intellect, int Dexterity, int Agility, double Damage, double Speed, EquipmentType type, int minLevel, String name, int Cost) {
        super(Strength, Vitality, Intellect, Dexterity, Agility, type, minLevel, name, Cost);

        setDamage(Damage);
        setSpeed(Speed);
        setBlock(0);
    }

    public Weapon(int Strength, int Vitality, int Intellect, int Dexterity, int Agility, double Damage, double Speed, EquipmentType type, String name, int Cost) {
        super(Strength, Vitality, Intellect, Dexterity, Agility, type, name, Cost);

        setMinLevel(1);
        setDamage(Damage);
        setSpeed(Speed);
        setBlock(0);
    }

    public void setElementalType(ElementalTypes type) {

        this.ElementalType = type;
        this.isElemental = true;
    }

    public void setBlock(double Block) {

        this.Block = Block;
    }

    public void setDamage(double Damage) {

        this.Damage = Damage;
    }

    public void setSpeed(double Speed) {

        this.Speed = Speed;
    }


    public ElementalTypes getElementalType() {

        if (this.isElemental) {
            return this.ElementalType;
        } else {
            return null;
        }
    }

    public boolean isElemental() {

        return this.isElemental;
    }

    public double getBlock() {

        return this.Block;
    }

    public double getDamage() {

        return this.Damage;
    }

    public double getSpeed() {

        return this.Speed;
    }
}