package TileMap;

import Render.MapRender;
import World.BaseObject;

public class TileConverter {
    private static BaseObject[][] tilesMap = new BaseObject[250][250];

    public static void renderWorld(BaseObject[][] t, float mapX, float mapY, boolean changingMap) {
        int maxX, maxY = t.length;

        for (int y = 0; y < maxY; y++) {
            maxX = t[y].length;
            for (int x = 0; x < maxX; x++) {
                if (t[y][x] != null) {
                    tilesMap[x][y] = t[y][x];
                    MapRender.drawTile(t[y][x], x, y, mapX, mapY, true);
                }
            }
        }
    }

    public static BaseObject getTile(int x, int y) {
        if (tilesMap != null) {
            if (x >= 0 && y >= 0) {
                if(tilesMap[x][y] != null) {
                    if (x <= tilesMap.length && y <= tilesMap[x].length) {
                        return tilesMap[x][y];
                    } else return null;
                }else return null;
            } else return null;
        } else return null;
    }

    /*public static BaseObject getTile(float x, float y) {
        if (tilesMap != null) {
            if (x >= -3 && y >= -3) {
                double tempX = Math.floor(x) / 64;
                double tempY = Math.floor(y) / 64;

//                System.out.println("tempX: " + Math.floor(x) + ", tempY: " + Math.floor(y));

                if (x <= tilesMap.length && y <= tilesMap[(int) tempX].length) {
                    return tilesMap[(int) tempX][(int) tempY];
                } else return null;
            } else return null;
        } else return null;
    }*/

    public static void setTile(int x, int y, BaseObject tile) {
        tilesMap[x][y] = tile;
    }
}