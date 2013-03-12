package Maps;

import Render.MapRender;
import Tiles.BaseObject;

public class Map {
    private BaseObject[][] map;
    private String name;
    private int mapID;

    public Map renderMap(float mapX, float mapY) {
        int maxY = map[0].length;
        int maxX = map.length;

        if(map != null) {
            for(int y = 0; y < maxY; y++) {
                for(int x = 0; x < maxX; x++) {
                    MapRender.drawTile(map[x][y], x, y, mapX, mapY, true);
                }
            }
        }
        return this;
    }

    public Map() {
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

    public Map setTile(float x, float y, BaseObject t) {
        int tempX = (int) Math.floor(x) / 64;
        int tempY = (int) Math.floor(y) / 64;

        map[tempX][tempY] = t;
        return this;
    }

    public BaseObject getTile(int x, int y) {
        return map[x][y];
    }

    public int getMapID() {
        return mapID;
    }

    public BaseObject getTile(float x, float y) {
        int tempX = (int) Math.floor(x) / 64;
        int tempY = (int) Math.floor(y) / 64;

        return map[tempX][tempY];
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