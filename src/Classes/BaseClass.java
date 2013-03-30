package Classes;

import Player.PowerTypes;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BaseClass {
    private int Vitality, Strength, Intellect, Dexterity, Agility, maxPower;
    private String className, imgLocation;
    private PowerTypes powerType;

    public BaseClass(int Vitality, int Strength, int Intellect, int Dexterity, int Agility, PowerTypes power, int maxPower) {

        Class(Vitality, Strength, Intellect, Dexterity, Agility, className, power, maxPower);
    }

    public BaseClass(int Vitality, int Strength, int Intellect, int Dexterity, int Agility, String className, PowerTypes power, int maxPower) {
        Class(Vitality, Strength, Intellect, Dexterity, Agility, className, power, maxPower);
    }

    private void Class(int Vitality, int Strength, int Intellect, int Dexterity, int Agility, String className, PowerTypes power, int maxPower) {
        this.Vitality = Vitality;
        this.Strength = Strength;
        this.Intellect = Intellect;
        this.Dexterity = Dexterity;
        this.Agility = Agility;
        this.className = className;
        this.imgLocation = "res/player/" + className + ".png";
        this.powerType = power;
        this.maxPower = maxPower;
    }

    public BaseClass setMaxPower(int maxPower) {
        this.maxPower = maxPower;
        return this;
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

    public int getMaxPower() {
        return maxPower;
    }

    public PowerTypes getPowerType() {
        return powerType;
    }

    public Image getClassImage()  {
        try{
            return new Image(this.imgLocation);
        }catch(SlickException e) {
            e.printStackTrace();
        }
        return null;
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