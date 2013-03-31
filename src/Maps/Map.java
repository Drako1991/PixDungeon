package Maps;

import Render.MapRender;
import Tiles.BaseObject;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class Map {
    private BaseObject[][] map;
    private String name;
    private int mapID;

    public Map renderMap(float mapX, float mapY, GameContainer gc) throws SlickException {
        int maxY = map[0].length;
        int maxX = map.length;

        for(int y = 0; y < maxY; y++) {
            for(int x = 0; x < maxX; x++) {
                MapRender.drawTile(map[x][y], y, x, mapX, mapY, this, true, gc);
            }
        }
        return this;
    }

    public Map(BaseObject[][] map) {
        this.map = map;
        name = "";
    }

    public Map(String name) {
        this.name = name;
    }

    public Map(int mapID) {
        this.mapID = mapID;
    }

    public Map(MapsList ml) {
        this.mapID = ml.ordinal();
    }

    public Map(BaseObject[][] map, String name) {
        this.map = map;
        this.name = name;
    }

    public Map(BaseObject[][] map, String name, int mapID) {
        this.map = map;
        this.name = name;
        this.mapID = mapID;
    }

    public Map(BaseObject[][] map, String name, MapsList ml) {
        this.map = map;
        this.name = name;
        this.mapID = ml.ordinal();
    }

    public Map setMap(BaseObject[][] map) {
        this.map = map;
        return this;
    }

    public Map setName(String name) {
        this.name = name;
        return this;
    }

    public Map setID(int mapID) {
        this.mapID = mapID;
        return this;
    }

    public BaseObject[][] getMap() {
        return map;
    }

    public Map setTile(int x, int y, BaseObject t) {
        map[x][y] = t;
        return this;
    }

    /*public BaseObject getTile(int x, int y) {
        int tempX = x-3, tempY = y+6;
        if(tempY >= 0 && tempY < map.length) {
            if(tempX >= 0 && tempX < map[tempY].length) {
                return map[tempY][tempX];
            } else return null;
        } else return null;
    }*/

    public BaseObject getTile(int x, int y) {
        int tempX = x, tempY = y;
        if(tempY >= 0 && tempY < map.length) {
            if(tempX >= 0 && tempX < map[tempY].length) {
                return map[tempY][tempX];
            } else return null;
        } else return null;
    }

    public int getMapID() {
        return mapID;
    }

    public String getName() {
        return name;
    }

    public int getMaxX() {
        return map.length;
    }

    public int getMaxY() {
        return map[0].length;
    }
}