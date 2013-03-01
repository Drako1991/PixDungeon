package Render;

import States.Game;
import TileMap.Maps;
import TileMap.TileConverter;
import TileMap.TileList;
import World.BaseObject;
import World.Tiles;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
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

    public static void drawTile(BaseObject obj, float posX, float posY, boolean connectsToPath) {
        float scale = obj.getTileSize();
        if(connectsToPath) {
            if(obj.getEnum() == TileList.grass) {
                if(TileConverter.getTile(posX-1, posY) == Tiles.path) {
                    Tiles.rGrass.getImage().draw(posX, posY, scale);
//                    TileConverter.setTile(posX, posY, Tiles.rGrass);
                }else if(TileConverter.getTile(posX+1, posY) == Tiles.path) {
                    Tiles.lGrass.getImage().draw(posX, posY, scale);
//                    TileConverter.setTile(posX, posY, Tiles.lGrass);
                }else if(TileConverter.getTile(posX, posY+1) == Tiles.path) {
                    Tiles.tGrass.getImage().draw(posX, posY, scale);
//                    TileConverter.setTile(posX, posY, Tiles.tGrass);
                }else if(TileConverter.getTile(posX, posY-1) == Tiles.path) {
                    Tiles.bGrass.getImage().draw(posX, posY, scale);
//                    TileConverter.setTile(posX, posY, Tiles.bGrass);
                }else{
                    Tiles.grass.getImage().draw(posX, posY, scale);
//                    TileConverter.setTile(posX, posY, Tiles.grass);
                }
            }
        }

//        obj.getImage().draw(posX*scale, posY*scale, scale, scale);
    }

    public static void drawTile(Graphics g, BaseObject obj, float posX, float posY, float scale) {
        obj.getImage().draw(posX*scale, posY*scale, scale, scale);
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
                g.drawImage(obj.getImage(), tempX * 32, tempY * 32);
            }
        }
    }

    public static void fill(Graphics g, BaseObject obj, int startX, int startY, int endX, int endY) {
        for (int tempX = startX; tempX <= endX; tempX++) {
            for (int tempY = startY; tempY <= endY; tempY++) {
                g.drawImage(obj.getImage(), tempX * 32, tempY * 32);
            }
        }
    }
}
