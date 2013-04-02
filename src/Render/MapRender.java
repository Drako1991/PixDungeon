package Render;

import Maps.Map;
import Maps.TileList;
import Tiles.BaseObject;
import Tiles.Tiles;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class MapRender {
    public static void drawTile(BaseObject obj, int posX, int posY, float mapX, float mapY, Map map, boolean connectsToPath, GameContainer gc) throws SlickException {
        float height = 64 * gc.getHeight() / 720, width = 64 * gc.getWidth() / 1280;
        boolean sideGrass = false;
        float mPosX = (posX + mapX + map.getMaxX()) * width, mPosY = (posY + mapY - map.getMaxY()) * height;

        if((obj.getEnum() != TileList.grass && connectsToPath) || !connectsToPath) {
            obj.getImage().draw(mPosX, mPosY, width, height);
        }

        if(connectsToPath) {
            if(obj.getEnum() == TileList.grass) {
                for(int x = -1; x<2; x++) {
                    for(int y = -1; y<2; y++) {
                        if(map.getTile(posX + x, posY + y) == Tiles.path) {
                            if(x == 0 && y == -1) {
                                sideGrass = true;
                                Tiles.bGrass.getImage().draw(mPosX, mPosY, width, height);
                            }
                            if(x == 0 && y == 1) {
                                sideGrass = true;
                                Tiles.tlGrass.getImage().draw(mPosX, mPosY, width, height);
                            }
                            if(x == -1 && y == 0) {
                                sideGrass = true;
                                Tiles.rGrass.getImage().draw(mPosX, mPosY, width, height);
                            }
                            if(x == 1 && y == 0) {
                                sideGrass = true;
                                Tiles.lGrass.getImage().draw(mPosX, mPosY, width, height);
                            }
                            if(x == -1 && y == -1) {
                            }
                            if(x == 1 && y == -1) {
                            }
                            if(x == -1 && y == 1) {
                                if(map.getTile(posX - 1, posY) == Tiles.grass) {
                                    sideGrass = true;
                                    Tiles.trGrass.getImage().draw(mPosX, mPosY, width, height);
                                }
                            }
                            if(x == 1 && y == 1) {
                                if(map.getTile(posX + 1, posY) == Tiles.grass) {
                                    sideGrass = true;
                                    Tiles.tlGrass.getImage().draw(mPosX, mPosY, width, height);
                                }
                            }
                        }
                    }
                }
                if(!sideGrass) {
                    Tiles.grass.getImage().draw(mPosX, mPosY, width, height);
                }
            }
        }
    }
}