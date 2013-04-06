package Mobs;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import AI.AI;

public class Mob {
    private String name;
    private int health, maxHealth, level;
    private Image image;
    private Vector2f pos = new Vector2f(0, 0), scale;
    private float damage, maxDamage, rotation, speed;
    private boolean isDead, isAttacking;
    private AI mobAI;
//TODO: CODE ATTACK METHOD

    public Mob(String name, AI mobAI, Image image, Vector2f pos, Vector2f scale) {
        this.name = name;
        this.image = image;
        this.pos = pos;
        this.scale = scale;
        this.mobAI = mobAI;
    }

    public Mob(String name, AI mobAI, Image image, Vector2f pos) {
        this.name = name;
        this.image = image;
        this.pos = pos;
        this.mobAI = mobAI;
    }

    public Mob(String name, AI mobAI, Image image) {
        this.name = name;
        this.image = image;
        this.mobAI = mobAI;
    }

    public Mob(String name, AI mobAI, String imgRef) {
        this.name = name;
        this.mobAI = mobAI;
        try{
            image = new Image(imgRef);
        }catch(SlickException e) {
            e.printStackTrace();
        }
    }

    public Mob update() {
        mobAI.update();
        return this;
    }

    public Mob attack(float rotation) {
        isAttacking = true;
        return this;
    }

    public Mob setSpeed(float speed) {
        this.speed = speed;
        return this;
    }

    public Mob setAttacking(boolean attacking) {
        isAttacking = attacking;
        return this;
    }

    public Mob setDead() {
        isDead = true;
        return this;
    }

    public Mob setRotation(float rotation) {
        this.rotation = rotation;
        return this;
    }

    public Mob setDamage(float damage, float maxDamage) {
        this.damage = damage;
        this.maxDamage = maxDamage;
        return this;
    }

    public Mob addPos(float x, float y) {
        pos = new Vector2f(pos.x + x, pos.y + y);
        return this;
    }

    public Mob setPos(Vector2f pos) {
        this.pos = pos;
        return this;
    }

    public Mob setScale(Vector2f scale) {
        this.scale = scale;
        return this;
    }

    public Mob setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        return this;
    }

    public Mob setHealth(int health) {
        this.health = health;
        return this;
    }

    public Mob setLevel(int level) {
        this.level = level;
        return this;
    }

    public boolean isAttacking() {
        return isAttacking;
    }

    public float getSpeed() {
        return speed;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public boolean isDead() {
        return isDead;
    }

    public float getRotation() {
        return rotation;
    }

    public float getMaxDamage() {
        return maxDamage;
    }

    public float getDamage() {
        return damage;
    }

    public Vector2f getPos() {
        return pos;
    }

    public Vector2f getScale() {
        return scale;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }
}