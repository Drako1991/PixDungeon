package TileMap;

import Render.MapRender;
import World.BaseObject;
import World.Tiles;
import org.newdawn.slick.Graphics;

public class TileConverter {
    private static BaseObject[][] tilesMap = new BaseObject[250][250];

    public static void renderWorld(String[] s, float mapX, float mapY, boolean changingMap) {
        int maxX, maxY = s.length;
        if(changingMap) {
            System.out.println("Changing Map!");
            for (int y = 0; y < maxY; y++) {
                maxX = s[y].length();
                for (int x = 0; x < maxX; x++) {
                    char[] cLetters = s[y].toCharArray();
                    if (cLetters[x] == 'g') {
                        tilesMap[x][y] = Tiles.grass;
                    }
                    if (cLetters[x] == 'p') {
                        tilesMap[x][y] = Tiles.path;
                    }
                }
            }
        }

        for (int y = 0; y < maxY ; y++) {
            maxX = s[y].length();
            for(int x = 0; x < maxX; x++) {
                if(tilesMap[x][y] != null) {
                    MapRender.drawTile(tilesMap[x][y], x, y, mapX, mapY, true);
                }
            }
        }
    }

    public static BaseObject getTile(int x, int y) {
        if(tilesMap != null) {
            if(x <= tilesMap.length && y <= tilesMap[x].length) {
                return tilesMap[x][y];
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public static void setTile(int x, int y, BaseObject tile) {
        tilesMap[x][y] = tile;
    }
}