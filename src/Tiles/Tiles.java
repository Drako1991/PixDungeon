package Tiles;

import Maps.TileList;

public class Tiles extends BaseObject {
    public static BaseObject grass = new BGObject(0, 0, "Grass", TileList.grass, false),
    path = new BGObject(1, 0, "Path", TileList.path, true),
    bGrass = new BGObject(0, 1, "bGrass", TileList.bGrass, false),
    tGrass = new BGObject(0, 2, "tGrass", TileList.tGrass, false),
    lGrass = new BGObject(0, 3, "lGrass", TileList.lGrass, false),
    rGrass = new BGObject(0, 4, "rGrass", TileList.rGrass, false),
    tlGrass = new BGObject(1, 1, "tlGrass", TileList.tlGrass, false),
    trGrass = new BGObject(1, 2, "trGrass", TileList.trGrass, false);
}