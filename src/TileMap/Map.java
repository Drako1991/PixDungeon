package TileMap;

import World.BaseObject;

public class Map {
    private BaseObject[][] map;

    public Map(BaseObject[][] map) {
        this.map = map;
    }

    public Map setMap(BaseObject[][] map) {
        this.map = map;
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

    public BaseObject getTile(float x, float y) {
        int tempX = (int) Math.floor(x) / 64;
        int tempY = (int) Math.floor(y) / 64;

        return map[tempX][tempY];
    }

    public int getMaxX() {
        return map.length;
    }

    public int getMaxY() {
        return map[0].length;
    }
}