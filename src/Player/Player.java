package Player;

import Classes.BaseClass;
import Classes.ClassList;
import Classes.Classes;
import Classes.DefaultValues;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {
    private int maxLevel = 30, Level, xp, Strength, Vitality, Intellect, Dexterity, Agility, maxHealth, Health,
            xpIncreaseRate = 500, maxPower, power;
    private String Name, classImgLocation;
    private int maxXP = Level * xpIncreaseRate;
    private boolean Dead = false;
    private PowerTypes powerType;
    private static PlayerAnimStates animState;
    private static BaseClass playerClass;

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
        setLevel(1);
        setXP(0);
        setName(Name);

        switch(Class) {
            case Archer:
                playerClass = Classes.Archer;
                break;

            case Assassin:
                playerClass = Classes.Assassin;
                break;

            case Knight:
                playerClass = Classes.Knight;
                break;

            case Wizard:
                playerClass = Classes.Wizard;
                break;

            default:
                System.out.println("====ERROR WHEN CREATING CHARACTER====");
                break;
        }

        maxPower = playerClass.getMaxPower();
    }

    public static void writePlayerToFile() {

    }

    public static void readPlayerFromFile() {

    }

    public static void setAnimState(PlayerAnimStates animaState) {
        animState = animaState;
    }

    public void setPower(int power) {
        if(power >= 0 && power <= maxPower) {
            this.power = power;
        }
        if(power < 0) {
            this.power = 0;
        }
        if(power > maxPower) ;
        {
            this.power = maxPower;
        }
    }

    public void addPower(int power) {
        if(this.power + power <= maxPower) {
            this.power += power;
        } else {
            this.power = maxPower;
        }
    }

    public void takePower(int power) {
        if(this.power - power >= 0) {
            this.power -= power;
        } else {
            this.power = 0;
        }
    }

    public void setMaxPower(int maxPower) {
        if(maxPower >= 0) {
            this.maxPower = maxPower;
        } else {
            this.maxPower = 0;
        }
    }

    public void setXP(int XP) {

        this.xp = XP;
    }

    public void addXP(int XP) {
        if(this.Level + 1 <= maxLevel) {

            if(this.xp + XP < this.getMaxXP(this.Level)) {
                this.xp += XP;
            } else {
                if(this.Level + 1 <= this.maxLevel) {
                    int tempXP = (this.xp + XP) - this.getMaxXP(this.Level);

                    if(tempXP >= 0) {
                        this.addLevel(1);
                        this.xp = tempXP;
                    }
                } else {
                    this.Level = this.maxLevel;
                    this.xp = 0;
                }
            }
        }
    }

    public void setPowerType(PowerTypes type) {
        powerType = type;
    }


    public void xp(int XP, boolean at) {
        if(at) {
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

    public void toggleDeath() {
        Dead = !Dead;
    }

    public void setAlive() {
        this.Dead = false;
    }

    public void setAlive(boolean alive) {
        this.Dead = !alive;
    }

    public void setLevel(int Level) {
        if(Level <= this.maxLevel) {
            this.Level = Level;
        } else {
            this.Level = this.maxLevel;
        }
    }

    public void addLevel(int Level) {
        if(this.Level + Level <= this.maxLevel) {
            this.Level += Level;

        } else {
            this.Level = this.maxLevel;
        }
    }

    public void setClassImageLocation(String location) {
        this.classImgLocation = location;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void takeHealth(int Health) {
        if(this.Health - Health > 0) {
            this.Health -= Health;
        } else {
            this.Health = 0;
            setDead();
        }
    }

    public void addHealth(int Health) {
        if(this.Health + Health <= maxHealth) {
            this.Health += Health;
        } else {
            this.Health = maxHealth;
        }
    }

    public void setHealth(int Health) {
        if(Health <= 0) {
            setDead();
            this.Health = 0;
        }
        if(Health == maxHealth) {
            this.Health = maxHealth;
        }
        this.Health = Health;
    }

    public void setMaxHealth(int MaxHealth) {
        if(MaxHealth > 0) {
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

    public BaseClass getPlayerClass() {
        return playerClass;
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
        if(powerType == PowerTypes.Fury) {
            return new Color(255, 0, 0);
        } else if(powerType == PowerTypes.Mana) {
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
        return this.maxLevel;
    }

    public int getMaxXP() {
        return this.Level * xpIncreaseRate;
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

    public String getPowerTypeString() {
        switch(powerType) {
            case Fury: return "Fury";
            case Mana: return "Mana";
            case tempArcher: return "tempArcher";
            case tempAssassin: return "tempAssassin";
            default: return null;
        }
    }
}