package TileMap;

import Render.MapRender;
import World.BaseObject;

public class TileConverter {
    private static BaseObject[][] tilesMap = new BaseObject[250][250];

    /*public static void renderWorld(String[] s, float mapX, float mapY, boolean changingMap) {
        int maxX, maxY = s.length;
        if (changingMap) {
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

        for (int y = 0; y < maxY; y++) {
            maxX = s[y].length();
            for (int x = 0; x < maxX; x++) {
                if (tilesMap[x][y] != null) {
                    MapRender.drawTile(tilesMap[x][y], x, y, mapX, mapY, true);
                }
            }
        }
    }*/

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

//    public static BaseObject getTile(int x, int y) {
//        if (tilesMap != null) {
//            if (x <= tilesMap.length && y <= tilesMap[x].length) {
//                return tilesMap[x][y];
//            } else {
//                return null;
//            }
//        } else {
//            return null;
//        }
//    }

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

    public static BaseObject getTile(float x, float y) {
        if (tilesMap != null) {
            if (x >= 0 && y >= 0) {
                int tempX = (int) Math.ceil(x) / 32;
                int tempY = (int) Math.ceil(y) / 32;

                if (x <= tilesMap.length && y <= tilesMap[tempX].length) {
                    return tilesMap[tempX][tempY];
                } else return null;
            } else return null;
        } else return null;
    }

    public static void setTile(int x, int y, BaseObject tile) {
        tilesMap[x][y] = tile;
    }
}