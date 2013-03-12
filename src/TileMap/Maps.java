package TileMap;

import World.BaseObject;
import World.Tiles;

public class Maps {

    public static BaseObject[][] map1 = {
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

    public static Map Map1 = new Map(map1);

    public static void renderMap(String s, float mapX, float mapY, boolean changingMap) {
        if (s.toLowerCase() == "map1") {
            TileConverter.renderWorld(map1, mapX, mapY, changingMap);

            for(int x = 0; x <= map1.length-1; x++) {
                for(int y = 0; y <= map1[x].length-1; y++) {
                    System.out.println(map1[x][y].getName());
                }
            }
        }
    }
}