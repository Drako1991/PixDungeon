package Tiles;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Vector2f;

public class BaseObject {
    private boolean isSolid, breakable, usesSpriteSheet;
    private String imageLocation, name;
    private int imageSize;
    private float tileSize;
    private Image img;
    private Enum tileEnum;

    public BaseObject() {

    }

    public BaseObject setCollisionSize(float size) {
        this.tileSize = size;
        return this;
    }

    public BaseObject setTileSize(int size) {
        this.imageSize = size;
        return this;
    }

    public BaseObject setName(String name) {
        this.name = name;
        return this;
    }

    public BaseObject setEnum(Enum n) {
        tileEnum = n;
        return this;
    }

    public BaseObject setColidable(boolean solid) {
        this.isSolid = solid;
        return this;
    }

    public BaseObject setImage(Image img) {
        usesSpriteSheet = false;
        this.img = img;
        return this;
    }

    public BaseObject setImage(String name) throws SlickException {
        usesSpriteSheet = false;
        imageLocation = "res/SpriteSheets/" + name + ".png";
            this.img = new Image("res/SpriteSheets/" + name + ".png");
        return this;
    }

    public BaseObject setImage(SpriteSheet ss, Vector2f pos) throws SlickException {
        usesSpriteSheet = true;
        img = ss.getSprite((int) pos.x, (int) pos.y);
        return this;
    }

    public BaseObject setBreakable(boolean breakable) {
        this.breakable = breakable;
        return this;
    }

    public float getCollisionSize() {
        return tileSize;
    }

    public int getTileSize() {
        return imageSize;
    }

    public boolean isSolid() {
        return isSolid;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public String getName() {
        return this.name;
    }

    public int getID() {
        return this.tileEnum.ordinal();
    }

    public Enum getEnum() {
        return this.tileEnum;
    }

    public Image getImage() throws SlickException {
        if(usesSpriteSheet) {
            return img;
        } else {
                return new Image(imageLocation);
        }
    }

    public Image getImageFromSpriteSheet() {
        return img;
    }


    public boolean getBreakable() {
        return breakable;
    }

    public BaseObject animate(int frames) throws SlickException {
        SpriteSheet ss = new SpriteSheet(new Image("res/BackgroundObjects.png"), 32, 32);
        for(int curFrame = 0; curFrame <= frames; curFrame++) {
            new Animation(ss, 2);
        }
        return this;
    }
}
