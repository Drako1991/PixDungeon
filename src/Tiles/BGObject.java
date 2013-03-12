package Tiles;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Vector2f;

public class BGObject extends BaseObject {

    public BGObject(int x, int y, String name, Enum n) {
        int tileSize = 64;
        setColidable(false);
        setBreakable(false);
        setEnum(n);
        setName(name);
        setTileSize(tileSize);
        setColidable(true);
        try {
            setImage(new SpriteSheet("res/SpriteSheets/NaturalBGSS64.png", tileSize, tileSize), new Vector2f(x, y));
        } catch(SlickException e) {
            e.printStackTrace();
        }
    }
}