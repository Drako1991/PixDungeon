package TileMap;

import Render.MapRender;
import World.BaseObject;
import World.Tiles;
import org.newdawn.slick.Graphics;

public class TileConverter {
    private static BaseObject[][] tilesMap;

    public static void renderWorld(String[] s, Graphics g, float mapX, float mapY) {
        int maxX = s[0].length(), maxY = s.length;
        tilesMap = new BaseObject[maxX + (int) Math.ceil(mapX)][maxY + (int) Math.ceil(mapY)];

        for (int y = 0; y < maxY; y++) {
            maxX = s[y].length();
            for (int x = 0; x < maxX; x++) {
                char[] cLetters = s[y].toCharArray();
                if (cLetters[x] == 'g') {
                    MapRender.drawTile(Tiles.grass, x+mapX, y+mapY, true);
//                    setTile(x+mapX, y+mapY, Tiles.grass);
                    tilesMap[(int) (x+mapX)][(int) (y+mapY)] = Tiles.grass;
                }
                if (cLetters[x] == 'p') {
                    MapRender.drawTile(Tiles.path, x+mapX, y+mapY, false);
                }
                if(tilesMap[x][y] != null) {
                    tilesMap[x][y].getImage().draw(x, y);
                }
//                if(cLetters[x] == 't') {
//                    MapRender.drawTile(g, Tiles.tGrass, x+mapX, y+mapY);
//                }
//                if(cLetters[x] == 'b') {
//                    MapRender.drawTile(g, Tiles.bGrass, x+mapX, y+mapY);
//                }
//                if(cLetters[x] == 'l') {
//                    MapRender.drawTile(g, Tiles.lGrass, x+mapX, y+mapY);
//                }
//                if(cLetters[x] == 'r') {
//                    MapRender.drawTile(g, Tiles.rGrass, x+mapX, y+mapY);
//                }
//                if(cLetters[x] == 'c') {
//                    MapRender.drawTile(g, Tiles.tlcGrass, x+mapX, y+mapY);
//                }
            }
        }
    }

//    public static void setTileMap(int x, int y, Enum n) {
//        tileMap[x][y] = n.ordinal();
//    }
//
//    public static int getXLength() {
//        return tileMap.length;
//    }
//
//    public static int getYLength() {
//        return tileMap[0].length;
//    }

//    public static int getTile(int x, int y) {
//        return tileMap[x][y];
//    }

    public static BaseObject getTile(float x, float y) {
        return tilesMap[(int) x][(int) y];
    }

    public static void setTile(float x, float y, BaseObject tile) {
        tilesMap[(int) x][(int) y] = tile;
    }
}