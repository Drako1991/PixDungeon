package Player;

import Classes.ClassList;
import Classes.DefaultValues;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {
    static ClassList Class;
    private int MaxLevel = 30, Level, xp, Strength, Vitality, Intellect, Dexterity, Agility, maxHealth, Health,
            xpIncreaseRate = 500, maxPower, power;
    private String Name, classImgLocation;
    private DefaultValues v = new DefaultValues();
    private int maxXP = Level * xpIncreaseRate;
    private boolean Dead = false;
    private PowerTypes powerType;
    private static PlayerAnimStates animState;

    //TODO: Set increasing stats on level increase
    //TODO: When creating a Player, access Class<ClassName> instead of DefaultValues class
    //TODO: Add death function and allow the player to be killed when at 0 Health
    //TODO: Add death overlay when the player is killed telling the player what killed them
    //TODO: Add player animations & Better images

    public Player() {
        setLevel(1);
        setXP(0);
        setName("");
    }

    public Player(ClassList Class, String Name) {
        setClass(Class);
        setLevel(1);
        setXP(0);

            switch (Class) {
                case Archer:
                    setStrength(v.ARCHER_STRENGTH);
                    setVitality(v.ARCHER_VITALITY);
                    setIntellect(v.ARCHER_INTELLECT);
                    setDexterity(v.ARCHER_DEXTERITY);
                    setAgility(v.ARCHER_AGILITY);
                    setName(Name);
                    setClassImageLocation(v.ARCHER_LOCATION);
                    setPowerType(PowerTypes.tempArcher);
                    setMaxPower(100);
                    break;

                case Assassin:
                    setStrength(v.ASSASSIN_STRENGTH);
                    setVitality(v.ASSASSIN_VITALITY);
                    setIntellect(v.ASSASSIN_INTELLECT);
                    setDexterity(v.ASSASSIN_DEXTERITY);
                    setAgility(v.ASSASSIN_AGILITY);
                    setName(Name);
                    setClassImageLocation(v.ASSASSIN_LOCATION);
                    setPowerType(PowerTypes.tempAssassin);
                    setMaxPower(100);
                    break;

                case Knight:
                    setStrength(v.KNIGHT_STRENGTH);
                    setVitality(v.KNIGHT_VITALITY);
                    setIntellect(v.KNIGHT_INTELLECT);
                    setDexterity(v.KNIGHT_DEXTERITY);
                    setAgility(v.KNIGHT_AGILITY);
                    setName(Name);
                    setClassImageLocation(v.KNIGHT_LOCATION);
                    setPowerType(PowerTypes.Fury);
                    setMaxPower(100);
                    break;

                case Wizard:
                    setStrength(v.WIZARD_STRENGTH);
                    setVitality(v.WIZARD_VITALITY);
                    setIntellect(v.WIZARD_INTELLECT);
                    setDexterity(v.WIZARD_DEXTERITY);
                    setAgility(v.WIZARD_AGILITY);
                    setName(Name);
                    setClassImageLocation(v.WIZARD_LOCATION);
                    setPowerType(PowerTypes.Mana);
                    setMaxPower(100);
                    break;

                default:
                    System.out.println("====ERROR WHEN CREATING CHARACTER====");
                    break;
        }
    }

    public static void writePlayerToFile() {

    }

    public static void readPlayerFromFile() {

    }

    public static void setAnimState(PlayerAnimStates animaState) {
        animState = animaState;
    }

    public void setPower(int power) {
        if (power >= 0 && power <= maxPower) {
            this.power = power;
        }
        if (power < 0) {
            this.power = 0;
        }
        if (power > maxPower) ;
        {
            this.power = maxPower;
        }
    }

    public void addPower(int power) {
        if (this.power + power <= maxPower) {
            this.power += power;
        } else {
            this.power = maxPower;
        }
    }

    public void takePower(int power) {
        if (this.power - power >= 0) {
            this.power -= power;
        } else {
            this.power = 0;
        }
    }

    public void setMaxPower(int maxPower) {
        if (maxPower >= 0) {
            this.maxPower = maxPower;
        } else {
            this.maxPower = 0;
        }
    }

    public void setXP(int XP) {

        this.xp = XP;
    }

    public void addXP(int XP) {
        if (this.Level + 1 <= MaxLevel) {

            if (this.xp + XP < this.getMaxXP(this.Level)) {
                this.xp += XP;
            } else {
                if (this.Level + 1 <= this.MaxLevel) {
                    int tempXP = (this.xp + XP) - this.getMaxXP(this.Level);

                    if (tempXP >= 0) {
                        this.addLevel(1);
                        this.xp = tempXP;
                    }
                } else {
                    this.Level = this.MaxLevel;
                    this.xp = 0;
                }
            }
        }
    }

    public Player setPowerType(String type) {
        if (type.toLowerCase() == "fury") {
            powerType = PowerTypes.Fury;
        }
        if (type.toLowerCase() == "magicka") {
            powerType = PowerTypes.Mana;
        }
        return this;
    }

    public void setPowerType(PowerTypes type) {
        powerType = type;
    }


    public void xp(int XP, boolean at) {

        if (at) {
            this.xp += XP;
        } else {
            this.xp -= XP;
        }
    }

    public void setDead() {
        this.Dead = true;
    }

    public void setDead(boolean dead) {
        this.Dead = dead;
    }

    public void setAlive() {
        this.Dead = false;
    }

    public void setAlive(boolean alive) {
        this.Dead = !alive;
    }

    public void setLevel(int Level) {

        if (Level <= this.MaxLevel) {
            this.Level = Level;
        } else {
            this.Level = this.MaxLevel;
        }
    }

    public void addLevel(int Level) {

        if (this.Level + Level <= this.MaxLevel) {
            this.Level += Level;

        } else {
            this.Level = this.MaxLevel;
        }
    }

    public void setClassImageLocation(String location) {

        this.classImgLocation = location;
    }

    public void setName(String Name) {

        this.Name = Name;
    }

    public void takeHealth(int Health) {
        if (this.Health - Health > 0) {
            this.Health -= Health;
        } else {
            this.Health = 0;
            setDead();
        }
    }

    public void addHealth(int Health) {
        if (this.Health + Health <= maxHealth) {
            this.Health += Health;
        } else {
            this.Health = maxHealth;
        }
    }

    public void setHealth(int Health) {
        if (Health <= 0) {
            setDead();
            this.Health = 0;
        }
        if (Health == maxHealth) {
            this.Health = maxHealth;
        }
        this.Health = Health;
    }

    public void setMaxHealth(int MaxHealth) {
        if (MaxHealth > 0) {
            this.maxHealth = MaxHealth;
        } else {
            this.maxHealth = 1;
        }
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

    public int getPower() {
        return power;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public PlayerAnimStates getAnimState() {
        return this.animState;
    }

    public PowerTypes getPowerType() {
        return powerType;
    }

    public Color getPowerColor() {
        if (powerType == PowerTypes.Fury) {
            return new Color(255, 0, 0);
        } else if (powerType == PowerTypes.Mana) {
            return new Color(20, 20, 255);
        } else {
            return null;
        }
    }

    public int getPowerTypeID() {
        return powerType.ordinal();
    }

    public boolean getDead() {
        return this.Dead;
    }

    public Image getClassImage() throws SlickException {

        return new Image(this.classImgLocation);
    }

    public int getMaxLevel() {

        return this.MaxLevel;
    }

    public int getMaxXP() {
        int maximumXP = this.Level * xpIncreaseRate;
        return maximumXP;
    }

    public int getMaxXP(int level) {

        return level * this.xpIncreaseRate;
    }

    public int getXP() {

        return this.xp;
    }

    public int getLevel() {

        return this.Level;
    }

    public String getName() {

        return this.Name;
    }

    public int getHealth() {

        return this.Health;
    }

    public int getMaxHealth() {

        return this.maxHealth;
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

    public void setClass(ClassList cl) {
        if (cl != null) {
            this.Class = cl;
        } else {
            System.out.println("====ERROR WHEN SETTING CLASS====");
        }
    }

    public ClassList getPlayerClass() {

        return this.Class;
    }

    public static String getPlayerClassString(ClassList Cls) {

        switch (Cls) {
            case Archer:
                return "Archer";
            case Assassin:
                return "Assassin";
            case Knight:
                return "Knight";
            case Wizard:
                return "Wizard";
            case None:
                return "None";
            default:
                System.out.println("====ERROR WHEN GETTING PLAYER CLASS STRING====");
                return null;
        }
    }

    public String getPlayerClassImage() {
        return "res/Player/" + getPlayerClassString(Class) + ".png";
    }

    public String getPowerTypeString() {
        switch (powerType) {
            case Fury:
                return "Fury";
            case Mana:
                return "Mana";
            case tempArcher:
                return "tempArcher";
            case tempAssassin:
                return "tempAssassin";
            default:
                return null;
        }
    }
}