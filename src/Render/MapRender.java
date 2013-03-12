package Render;

import TileMap.TileConverter;
import TileMap.TileList;
import World.BaseObject;
import World.Tiles;
import org.newdawn.slick.Graphics;
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

        if ((obj.getEnum() != TileList.grass && connectsToPath) || !connectsToPath) {
            obj.getImage().draw((posX + mapX) * scale, (posY + mapY) * scale, scale, scale);
        }

        if (connectsToPath) {
            if (obj.getEnum() == TileList.grass) {
                if (posX >= 1) {
                    if (TileConverter.getTile(posX - 1, posY) == Tiles.path) {
                        sideGrass = true;
                        Tiles.rGrass.getImage().draw((posX + mapX) * scale, (posY + mapY) * scale, scale, scale);
                    }
                    if (TileConverter.getTile(posX - 1, posY + 1) == Tiles.path) {
                        if (TileConverter.getTile(posX - 1, posY) == Tiles.grass) {
                            sideGrass = true;
                            Tiles.trGrass.getImage().draw((posX + mapX) * scale, (posY + mapY) * scale, scale, scale);
                        }
                    }
                }
                if (posY >= 1) {
                    if (TileConverter.getTile(posX, posY - 1) == Tiles.path) {
                        sideGrass = true;
                        Tiles.bGrass.getImage().draw((posX + mapX) * scale, (posY + mapY) * scale, scale, scale);
                    }
                }
                if (TileConverter.getTile(posX + 1, posY + 1) == Tiles.path) {
                    sideGrass = true;
                    Tiles.tlGrass.getImage().draw((posX + mapX) * scale, (posY + mapY) * scale, scale, scale);
                }
                if (TileConverter.getTile(posX + 1, posY) == Tiles.path) {
                    sideGrass = true;
                    Tiles.lGrass.getImage().draw((posX + mapX) * scale, (posY + mapY) * scale, scale, scale);
                }
                if (TileConverter.getTile(posX, posY + 1) == Tiles.path) {
                    sideGrass = true;
                    Tiles.tGrass.getImage().draw((posX + mapX) * scale, (posY + mapY) * scale, scale, scale);
                }
                if (!sideGrass) {
                    Tiles.grass.getImage().draw((posX + mapX) * scale, (posY + mapY) * scale, scale, scale);
                }
            }
        }
    }

    public static void drawLine(Graphics g, BaseObject obj, int posX, int posY, int endX) {
        for (int tempX = posX; tempX <= endX; tempX++) {
            g.drawImage(obj.getImage(), tempX, posY);
        }
    }

    public static void drawLineFromPoint(Graphics g, BaseObject obj, int posX, int posY, int width) {
        for (int tempX = posX; tempX <= posX + width; tempX++) {
            g.drawImage(obj.getImage(), tempX, posY);
        }
    }

    public static void fillFromPoint(Graphics g, BaseObject obj, int posX, int posY, int width, int height) {
        for (int tempX = posX; tempX <= posX + width; tempX++) {
            for (int tempY = posY; tempY <= posY + height; tempY++) {
                g.drawImage(obj.getImage(), tempX * 64, tempY * 64);
            }
        }
    }

    public static void fill(Graphics g, BaseObject obj, int startX, int startY, int endX, int endY) {
        for (int tempX = startX; tempX <= endX; tempX++) {
            for (int tempY = startY; tempY <= endY; tempY++) {
                g.drawImage(obj.getImage(), tempX * 64, tempY * 64);
            }
        }
    }
}