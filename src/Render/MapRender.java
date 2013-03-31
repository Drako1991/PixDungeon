package Render;

import Maps.Map;
import Maps.TileList;
import Tiles.BaseObject;
import Tiles.Tiles;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
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

    public static void drawTile(BaseObject obj, int posX, int posY, float mapX, float mapY, Map map, boolean connectsToPath, GameContainer gc) throws SlickException {
        float height = 64 * gc.getHeight() / 720, width = 64 * gc.getWidth() / 1280;
        boolean sideGrass = false;
        float mPosX = posX + mapX, mPosY = posY + mapY;

        if((obj.getEnum() != TileList.grass && connectsToPath) || !connectsToPath) {
            obj.getImage().draw((posX + mapX) * width, (posY + mapY) * height, width, height);
        }

        if(connectsToPath) {
            if(obj.getEnum() == TileList.grass) {
//                if(posX >= 1) {
//                    if(map.getTile(posX - 1, posY) == Tiles.path) {
//                        sideGrass = true;
//                        Tiles.rGrass.getImage().draw(mPosX * width, mPosY * height, width, height);
//                    }
//
//                    if(map.getTile(posX - 1, posY + 1) == Tiles.path) {
//                        if(map.getTile(posX - 1, posY) == Tiles.grass) {
//                            sideGrass = true;
//                            Tiles.trGrass.getImage().draw(mPosX * width, mPosY * height, width, height);
//                        }
//                    }
//                }

                    for(int x = -1; x < 2; x++) {
                        for(int y = -1; y < 2; y++) {
                            if(map.getTile(posX + x, posY + y) == Tiles.path) {
                                if(x == 0 && y == -1) {
                                    sideGrass = true;
                                    Tiles.bGrass.getImage().draw(mPosX * width, mPosY * height, width, height);
                                }
                                if(x == 0 && y == 1) {
                                    sideGrass = true;
                                    Tiles.tlGrass.getImage().draw(mPosX * width, mPosY * height, width, height);
                                }
                                if(x == -1 && y == 0) {
                                    sideGrass = true;
                                    Tiles.rGrass.getImage().draw(mPosX * width, mPosY * height, width, height);
                                }
                                if(x == 1 && y == 0) {
                                    sideGrass = true;
                                    Tiles.lGrass.getImage().draw(mPosX * width, mPosY * height, width, height);
                                }
                                if(x == -1 && y == -1) {
                                }
                                if(x == 1 && y == -1) {
                                }
                                if(x == -1 && y == 1) {
                                    if(map.getTile(posX - 1, posY) == Tiles.grass) {
                                        sideGrass = true;
                                        Tiles.trGrass.getImage().draw(mPosX * width, mPosY * height, width, height);
                                    }
                                }
                                if(x == 1 && y == 1) {
                                    if(map.getTile(posX + 1, posY) == Tiles.grass) {
                                        sideGrass = true;
                                        Tiles.tlGrass.getImage().draw(mPosX * width, mPosY * height, width, height);
                                    }
                                }
                            }
                        }
                    }

//                if(posY >= 1) {
//                    if(map.getTile(posX, posY - 1) == Tiles.path) {
//                        sideGrass = true;
//                        Tiles.bGrass.getImage().draw(mPosX * width, mPosY * height, width, height);
//                    }
//                }
//
//                if(map.getTile(posX + 1, posY + 1) == Tiles.path) {
//                    sideGrass = true;
//                    Tiles.tlGrass.getImage().draw(mPosX * width, mPosY * height, width, height);
//                }
//
//                if(map.getTile(posX + 1, posY) == Tiles.path) {
//                    sideGrass = true;
//                    Tiles.lGrass.getImage().draw(mPosX * width, mPosY * height, width, height);
//                }
//
//                if(map.getTile(posX, posY + 1) == Tiles.path) {
//                    sideGrass = true;
//                    Tiles.tGrass.getImage().draw(mPosX * width, mPosY * height, width, height);
//                }

                    if(!sideGrass) {
                        Tiles.grass.getImage().draw(mPosX * width, mPosY * height, width, height);
                    }
            }
        }
    }
}