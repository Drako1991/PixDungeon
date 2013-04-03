package Maps;

import Tiles.BaseObject;
import Tiles.Tiles;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class Maps {

    public static BaseObject[][] start = {
            {Tiles.grass, Tiles.grass, Tiles.grass, Tiles.grass, Tiles.grass, Tiles.grass, Tiles.grass, Tiles.grass},
            {Tiles.grass, Tiles.grass, Tiles.path, Tiles.path, Tiles.path, Tiles.path, Tiles.grass, Tiles.grass},
            {Tiles.grass, Tiles.grass, Tiles.path, Tiles.path, Tiles.path, Tiles.path, Tiles.grass, Tiles.grass},
            {Tiles.grass, Tiles.grass, Tiles.path, Tiles.path, Tiles.path, Tiles.path, Tiles.grass, Tiles.grass},
            {Tiles.grass, Tiles.grass, Tiles.path, Tiles.path, Tiles.path, Tiles.path, Tiles.grass, Tiles.grass},
            {Tiles.grass, Tiles.grass, Tiles.path, Tiles.path, Tiles.path, Tiles.path, Tiles.grass, Tiles.grass},
            {Tiles.grass, Tiles.grass, Tiles.path, Tiles.path, Tiles.path, Tiles.path, Tiles.grass, Tiles.grass},
            {Tiles.grass, Tiles.grass, Tiles.path, Tiles.path, Tiles.path, Tiles.path, Tiles.grass, Tiles.grass},
            {Tiles.grass, Tiles.grass, Tiles.path, Tiles.path, Tiles.path, Tiles.path, Tiles.grass, Tiles.grass},
            {Tiles.grass, Tiles.grass, Tiles.path, Tiles.path, Tiles.path, Tiles.path, Tiles.grass, Tiles.grass},
            {Tiles.grass, Tiles.grass, Tiles.path, Tiles.path, Tiles.path, Tiles.path, Tiles.grass, Tiles.grass},
            {Tiles.grass, Tiles.grass, Tiles.path, Tiles.path, Tiles.path, Tiles.path, Tiles.grass, Tiles.grass},
            {Tiles.grass, Tiles.grass, Tiles.grass, Tiles.grass, Tiles.grass, Tiles.grass, Tiles.grass, Tiles.grass}
    };

    public static Map Map1 = new Map(start, "Starting", MapsList.startingMap, 1, 1);

    public static void renderMap(Map map, float mapX, float mapY, GameContainer gc) throws SlickException {
        if(map != null) {
            map.renderMap(mapX, mapY, gc);
        } else {
            System.out.println("Returned null then rendering map!");
        }
    }
}