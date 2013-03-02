package World;

import TileMap.TileList;

public class Tiles extends BaseObject {
    public static BaseObject grass = new BGObject(0, 0, "Grass", TileList.grass);
    public static BaseObject path = new BGObject(1, 0, "Path", TileList.path);
    public static BaseObject bGrass = new BGObject(0, 1, "bGrass", TileList.bGrass);
    public static BaseObject tGrass = new BGObject(0, 2, "tGrass", TileList.tGrass);
    public static BaseObject lGrass = new BGObject(0, 3, "lGrass", TileList.lGrass);
    public static BaseObject rGrass = new BGObject(0, 4, "rGrass", TileList.rGrass);
    public static BaseObject tlGrass = new BGObject(1, 1, "tlGrass", TileList.tlGrass);
    public static BaseObject trGrass = new BGObject(1, 2, "trGrass", TileList.trGrass);
}