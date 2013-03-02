package TileMap;

import States.Game;
import org.newdawn.slick.Graphics;

public class Maps {
    public static String[] map1 = {
            "ggggggggggggggggggggggggggggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggggggggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggggggggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggggggggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggpppgggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggpppgggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggpppgggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggpppgggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggpppgggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggpppgggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggpppgggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggpppgggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggpppgggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggpppgggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggpppgggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggpppgggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggpppgggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggpppgggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggpppgggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggpppgggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggpppgggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggggggggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggggggggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggggggggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggggggggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggggggggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggggggggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggggggggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggggggggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggggggggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggggggggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggggggggggggggggggggggggggggggggg",
    };

    public static String[] map2 = {
            "   ggg   ",
            "   ggg   ",
    };

    public static void renderMap(String s, float mapX, float mapY, boolean changingMap) {
        if(s.toLowerCase() == "map1") {
            TileConverter.renderWorld(map1, mapX, mapY, changingMap);
        }
        if(s.toLowerCase() == "map2") {
            TileConverter.renderWorld(map2, mapX, mapY, changingMap);
        }
    }
}