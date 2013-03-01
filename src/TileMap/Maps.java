package TileMap;

import org.newdawn.slick.Graphics;

public class Maps {
    public static String[] map1 = {
            "ggggggggggggggggggggggggggggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggggggggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggggggggggggggggggggggggggggggggg",
            "gggggggggggggggggggggctttgggggggggggggggggggggggggggg",
            "ggggggggggggggggggggglppprggggggggggggggggggggggggggg",
            "ggggggggggggggggggggglppprggggggggggggggggggggggggggg",
            "ggggggggggggggggggggglppprggggggggggggggggggggggggggg",
            "ggggggggggggggggggggglppprggggggggggggggggggggggggggg",
            "ggggggggggggggggggggglppprggggggggggggggggggggggggggg",
            "ggggggggggggggggggggglppprggggggggggggggggggggggggggg",
            "ggggggggggggggggggggglppprggggggggggggggggggggggggggg",
            "ggggggggggggggggggggglppprggggggggggggggggggggggggggg",
            "ggggggggggggggggggggglppprggggggggggggggggggggggggggg",
            "ggggggggggggggggggggglppprggggggggggggggggggggggggggg",
            "ggggggggggggggggggggglppprggggggggggggggggggggggggggg",
            "ggggggggggggggggggggglppprggggggggggggggggggggggggggg",
            "ggggggggggggggggggggglppprggggggggggggggggggggggggggg",
            "ggggggggggggggggggggglppprggggggggggggggggggggggggggg",
            "ggggggggggggggggggggglppprggggggggggggggggggggggggggg",
            "ggggggggggggggggggggglppprggggggggggggggggggggggggggg",
            "ggggggggggggggggggggglppprggggggggggggggggggggggggggg",
            "ggggggggggggggggggggggbbbgggggggggggggggggggggggggggg",
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

    public static void renderMap(Graphics g,  String s, float mapX, float mapY) {
        if(s.toLowerCase() == "map1") {
            TileConverter.renderWorld(map1, g, mapX, mapY);
        }
        if(s.toLowerCase() == "map2") {
            TileConverter.renderWorld(map2, g, mapX, mapY);
        }
    }
}