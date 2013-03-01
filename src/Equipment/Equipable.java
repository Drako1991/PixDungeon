package Equipment;

public class Equipable {
    private int Cost, Strength, Vitality, Intellect, Dexterity, Agility, minLevel;
    private EquipmentType type;
    private String name;

    public Equipable(int Strength, int Vitality, int Intellect, int Dexterity, int Agility, EquipmentType type, int minLevel, String name, int Cost) {

        CreateEquipable(Strength, Vitality, Intellect, Dexterity, Agility, type, minLevel, name, Cost);
    }

    public Equipable(int Strength, int Vitality, int Intellect, int Dexterity, int Agility, String name, int Cost) {

        CreateEquipable(Strength, Vitality, Intellect, Dexterity, Agility, EquipmentType.None, 1, name, Cost);
    }

    public Equipable(int Strength, int Vitality, int Intellect, int Dexterity, int Agility, int minLevel, String name, int Cost) {

        CreateEquipable(Strength, Vitality, Intellect, Dexterity, Agility, EquipmentType.None, minLevel, name, Cost);
    }

    public Equipable(int Strength, int Vitality, int Intellect, int Dexterity, int Agility, EquipmentType type, String name, int Cost) {

        CreateEquipable(Strength, Vitality, Intellect, Dexterity, Agility, type, 1, name, Cost);
    }

    private void CreateEquipable(int Strength, int Vitality, int Intellect, int Dexterity, int Agility, EquipmentType Type, int minLevel, String name, int Cost) {

        setStrength(Strength);
        setVitality(Vitality);
        setIntellect(Intellect);
        setDexterity(Dexterity);
        setAgility(Agility);
        setType(Type);
        setMinLevel(minLevel);
        setName(name);
        setCost(Cost);
    }

    public void setCost(int cost) {

        this.Cost = cost;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setMinLevel(int minLevel) {

        this.minLevel = minLevel;
    }

    public void setType(EquipmentType type) {

    }

    public void setStrength(int Strength) {

        this.Strength = Strength;
    }

    public void setVitality(int Vitality) {

        this.Vitality = Vitality;
    }

    public void setIntellect(int Intellect) {

        this.Intellect = Intellect;
    }

    public void setDexterity(int Dexterity) {

        this.Dexterity = Dexterity;
    }

    public void setAgility(int Agility) {

        this.Agility = Agility;
    }

    public int getCost() {

        return this.Cost;
    }

    public String getName() {

        return this.name;
    }

    public int getMinLevel() {

        return this.minLevel;
    }

    public int getStrength() {

        return this.Strength;
    }

    public int getVitality() {

        return this.Vitality;
    }

    public int getIntellect() {

        return this.Intellect;
    }

    public int getDexterity() {

        return this.Dexterity;
    }

    public int getAgility() {

        return this.Agility;
    }

    public EquipmentType getType() {

        return this.type;
    }
}