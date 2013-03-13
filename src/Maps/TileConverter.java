package Maps;

import Render.MapRender;
import Tiles.BaseObject;
import org.newdawn.slick.SlickException;

public class TileConverter {
    private static BaseObject[][] tilesMap = new BaseObject[250][250];

    public static BaseObject getTile(int x, int y) {
        if(tilesMap != null) {
            if(x >= 0 && y >= 0) {
                if(tilesMap[x][y] != null) {
                    if(x <= tilesMap.length && y <= tilesMap[x].length) {
                        return tilesMap[x][y];
                    } else return null;
                } else return null;
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