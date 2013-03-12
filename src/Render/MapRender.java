package Render;

import Maps.TileConverter;
import Maps.TileList;
import Tiles.BaseObject;
import Tiles.Tiles;
import org.newdawn.slick.geom.Vector2f;

public class MapRender {
    public static int toMapX(int X) {
        return X * 64;
    }

    public static int toMapY(int Y) {
        return Y * 64;
    }

    public static Vector2f toMap(Vector2f pos) {
        return new Vector2f(pos.x * 64, pos.y * 64);
    }

    public static void drawTile(BaseObject obj, int posX, int posY, float mapX, float mapY, boolean connectsToPath) {
        float scale = 64;
        boolean sideGrass = false;

        if((obj.getEnum() != TileList.grass && connectsToPath) || !connectsToPath) {
            obj.getImage().draw((posX + mapX) * scale, (posY + mapY) * scale, scale, scale);
        }

        if(connectsToPath) {
            if(obj.getEnum() == TileList.grass) {
                if(posX >= 1) {
                    if(TileConverter.getTile(posX - 1, posY) == Tiles.path) {
                        sideGrass = true;
                        Tiles.rGrass.getImage().draw((posX + mapX) * scale, (posY + mapY) * scale, scale, scale);
                    }
                    if(TileConverter.getTile(posX - 1, posY + 1) == Tiles.path) {
                        if(TileConverter.getTile(posX - 1, posY) == Tiles.grass) {
                            sideGrass = true;
                            Tiles.trGrass.getImage().draw((posX + mapX) * scale, (posY + mapY) * scale, scale, scale);
                        }
                    }
                }

                if(posY >= 1) {
                    if(TileConverter.getTile(posX, posY - 1) == Tiles.path) {
                        sideGrass = true;
                        Tiles.bGrass.getImage().draw((posX + mapX) * scale, (posY + mapY) * scale, scale, scale);
                    }
                }

                if(TileConverter.getTile(posX + 1, posY + 1) == Tiles.path) {
                    sideGrass = true;
                    Tiles.tlGrass.getImage().draw((posX + mapX) * scale, (posY + mapY) * scale, scale, scale);
                }

                if(TileConverter.getTile(posX + 1, posY) == Tiles.path) {
                    sideGrass = true;
                    Tiles.lGrass.getImage().draw((posX + mapX) * scale, (posY + mapY) * scale, scale, scale);
                }

                if(TileConverter.getTile(posX, posY + 1) == Tiles.path) {
                    sideGrass = true;
                    Tiles.tGrass.getImage().draw((posX + mapX) * scale, (posY + mapY) * scale, scale, scale);
                }

                if(!sideGrass) {
                    Tiles.grass.getImage().draw((posX + mapX) * scale, (posY + mapY) * scale, scale, scale);
                }
            }
        }
    }
}