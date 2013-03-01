package Classes;

import Player.PowerTypes;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BaseClass {
    private int Level, Vitality, Strength, Intellect, Dexterity, Agility;
    private String className, imgLocation;
    private PowerTypes powerType;

    public BaseClass() {
        Class(0, 0, 0, 0, 0, 0, "");
    }

    public BaseClass(int Vitality, int Strength, int Intellect, int Dexterity, int Agility, String name) {

        Class(1, Vitality, Strength, Intellect, Dexterity, Agility, name);
    }

    public BaseClass(int Level, int Vitality, int Strength, int Intellect, int Dexterity, int Agility, String name) {

        Class(Level, Vitality, Strength, Intellect, Dexterity, Agility, name);
    }

    private void Class(int Level, int Vitality, int Strength, int Intellect, int Dexterity, int Agility, String name) {

        this.Level = Level;
        this.Vitality = Vitality;
        this.Strength = Strength;
        this.Intellect = Intellect;
        this.Dexterity = Dexterity;
        this.Agility = Agility;
        this.className = name;
    }

    public BaseClass setPowerType(PowerTypes type) {
        powerType = type;
        return this;
    }

    public BaseClass setImageLocation(String location) {

        this.imgLocation = location;
        return this;
    }

    public BaseClass setName(String name) {

        this.className = name;
        return this;
    }

    public BaseClass setVitality(int Vitality) {

        this.Vitality = Vitality;
        return this;
    }

    public BaseClass setStrength(int Strength) {

        this.Strength = Strength;
        return this;
    }

    public BaseClass setIntellect(int Intellect) {

        this.Intellect = Intellect;
        return this;
    }

    public BaseClass setDexterity(int Dexterity) {

        this.Dexterity = Dexterity;
        return this;
    }

    public BaseClass setAgility(int Agility) {

        this.Agility = Agility;
        return this;
    }

    public PowerTypes getPowerType() {
        return powerType;
    }

    public Image getClassImage() throws SlickException {

        return new Image(this.imgLocation);
    }

    public int getLevel() {

        return this.Level;
    }

    public String getName() {

        return this.className;
    }

    public int getVitality() {

        return this.Vitality;
    }

    public int getStrength() {

        return this.Strength;
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
}