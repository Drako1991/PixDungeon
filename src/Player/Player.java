package Player;

import Render.PlayerRender;
import States.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import Classes.BaseClass;

public class Player {
    private static int maxPower, power, Strength, Vitality, Agility, Intellect, Dexterity, health, maxHealth, xpIncreaseRate = 500, xp, level, maxLevel = 30, maxXP = level*xpIncreaseRate;
    private static Vector2f pos = new Vector2f(0, 0), scale = new Vector2f(32, 49);
    private static String name;
    private static BaseClass plyClass;
    private static boolean isDead;
    private static PowerTypes powerType;
    private static float speed = 1f, rotation;
    private static Directions plyDirection;
    private static PlayerRender plyRender;

    public Player(String name, BaseClass plyClass) {
        this.plyClass = plyClass;
        this.name = name;

        initPly();
    }

    private void initPly() {
        level = 1;
        xp = 0;
        isDead = false;
        Strength = plyClass.getStrength();
        Vitality = plyClass.getVitality();
        Agility = plyClass.getAgility();
        Intellect = plyClass.getIntellect();
        Dexterity = plyClass.getDexterity();

        plyRender = new PlayerRender(this, Game.getGameContainer());
    }

    public Player update() {
        plyRender.renderPlayer();
        return this;
    }


    public Player setDirection(Directions direction) {
        plyDirection = direction;
        return this;
    }

    public Player takeRotation(float Rotation) {
        if(Rotation > 0 && rotation - Rotation >= 0 && rotation - Rotation <= 360) {
            Rotation -= Rotation;
        }
        if(rotation - Rotation < 0) {
            rotation = 0;
        }
        return this;
    }

    public Player addRotation(float Rotation) {
        if(Rotation > 0 && rotation + Rotation <= 360) {
            rotation += Rotation;
        }
        if(rotation + Rotation > 360) {
            rotation = 360;
        }
        return this;
    }

    public Player setRotation(float Rotation) {
        if(Rotation <= 360) {
            rotation = Rotation;
        }
        if(Rotation > 360) {
            rotation = 360;
        }
        return this;
    }

    public Player setSpeed(float Speed) {
        speed = Speed;
        return this;
    }

    public Player takeHealth(int Health) {
        if(health - Health > 0 && Health > 0) {
            health -= Health;
        }
        if(health - Health <= 0) {
            health = 0;
            isDead = true;
        }
        return this;
    }

    public Player addHealth(int Health) {
        if(health + Health <= maxHealth && Health > 0) {
            health += Health;
        }
        if(health + Health > maxHealth) {
            health = maxHealth;
        }
        return this;
    }

    public Player setHealth(int Health) {
        if(Health > 0 && Health <= maxHealth) {
            health = Health;
        }
        if(Health <= 0) {
            isDead = true;
        }
        if(Health > maxHealth) {
            health = maxHealth;
        }
        return this;
    }

    public Player setName(String Name) {
        name = Name;
        return this;
    }

    public Player setPowerType(PowerTypes pow) {
        powerType = pow;
        return this;
    }

    public Player setPower(int pow) {
        power = pow;
        return this;
    }

    public Player setMaxPower(int pow) {
        maxPower = pow;
        return this;
    }

    public Player setLevel(int lvl) {
        if(lvl > 0 && lvl <= maxLevel) {
            level = lvl;
        }
        if(lvl > maxLevel) {
            level = maxLevel;
        }
        return this;
    }

    public Player addLevel(int lvl) {
        if(lvl > 0 && lvl + level <= maxLevel) {
            level += lvl;
        }
        if(lvl + level > maxLevel) {
            level = maxLevel;
        }
        return this;
    }

    public Player setDead() {
        isDead = true;
        return this;
    }

    public Player setAlive() {
        isDead = false;
        return this;
    }

    public Player setDead(boolean dead) {
        isDead = dead;
        return this;
    }

    public Player setAlive(boolean alive) {
        isDead = !alive;
        return this;
    }

    public Player toggleDead() {
        isDead = !isDead;
        return this;
    }

    public Player setXP(int XP) {
        if(XP >= 0 && XP+xp < maxXP) {
            xp = XP;
        }
        if(XP < 0) {
            xp = 0;
        }
        if(XP == maxXP && level+1 <= maxLevel) {
            level++;
        }
        if(XP+xp > maxXP) {
            int tempXP = maxXP - (XP+xp);

            level++;
            xp = tempXP;
        }
        return this;
    }

    public Player addXP(int XP) {
        setXP(getXP()+XP);
        return this;
    }

    public Player setHelath(int health) {
        this.health = health;
        return this;
    }

    public Player setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        return this;
    }

    public Player setStrength(int str) {
        Strength = str;
        return this;
    }

    public Player setVitality(int vit) {
        Vitality = vit;
        return this;
    }

    public Player setAgility(int agi) {
        Agility = agi;
        return this;
    }

    public Player setIntellect(int inte) {
        Intellect = inte;
        return this;
    }

    public Player setDexterity(int dex) {
        Dexterity = dex;
        return this;
    }

    public Player addPos(float X, float Y) {
        pos = new Vector2f(pos.x+X, pos.y+Y);
        return this;
    }

    public Player takePos(float X, float Y) {
        pos = new Vector2f(pos.x-X, pos.y-Y);
        return this;
    }

    public Player setPos(float x, float y) {
        pos = new Vector2f(x, y);
        return this;
    }

    public Player setPos(Vector2f pos) {
        this.pos = pos;
        return this;
    }

    public Player setScale(float h, float w) {
        scale = new Vector2f(h, w);
        return this;
    }

    public Player setScale(Vector2f scale) {
        this.scale = scale;
        return this;
    }

    public Vector2f getTilePos() {
        return new Vector2f((int) Math.ceil(pos.x/Game.getTileSize().x), (int) Math.ceil(pos.y/Game.getTileSize().y));
    }

    public Directions getDirection() {
        return plyDirection;
    }

    public float getRotation() {
        return rotation;
    }

    public float getSpeed() {
        return speed;
    }

    public PowerTypes getPowerType() {
        return powerType;
    }

    public int getPower() {
        return power;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public boolean isDead() {
        return isDead;
    }

    public int getXP() {
        return xp;
    }

    public int getMaxXP() {
        return maxXP;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getStrength() {
        return Strength;
    }

    public int getVitality() {
        return Vitality;
    }

    public int getAgility() {
        return Agility;
    }

    public int getIntellect() {
        return Intellect;
    }

    public int getDexterity() {
        return Dexterity;
    }

    public Vector2f getPos() {
        return pos;
    }

    public Vector2f getScale() {
        return scale;
    }

    public BaseClass getPlayerClass() {
        return plyClass;
    }

    public String getName() {
        return name;
    }
}