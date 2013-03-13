package Maps;

import Tiles.BaseObject;
import Tiles.Tiles;
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

    public static Map Map1 = new Map(start, "Starting", MapsList.startingMap);

    public static void renderMap(Map map, float mapX, float mapY) throws SlickException {
        if(map != null) {
            map.renderMap(mapX, mapY);
        } else {
            System.out.println("Returned null then rendering map!");
        }
    }
}