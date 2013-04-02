package Player;

import Main.Main;
import Maps.Map;
import States.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class Movement {
    private static float xSpeed, ySpeed;

    public static void move(GameContainer gc, Player ply) {
        Input input = gc.getInput();
        float speedX = -ply.getSpeed() * (Game.getTileSize().x / 64) / 30f, speedY = ply.getSpeed() * (Game.getTileSize().y / 64) / 30f;
        boolean w = input.isKeyDown(Input.KEY_W), a = input.isKeyDown(Input.KEY_A), s = input.isKeyDown(Input.KEY_S), d = input.isKeyDown(Input.KEY_D);
        ply.addPos(xSpeed, ySpeed);
        Map map = Game.getCurrentMap();
        int plyX = (int) ply.getPos().x, plyY = (int) ply.getPos().y;
        int speedXX = (int) Math.floor(speedX), speedYY = (int) Math.floor(speedY);

        if(Main.debugMode()) {
            if(w) ySpeed = speedY;
            if(s) ySpeed = -speedY;
            if(a) xSpeed = speedX;
            if(d) xSpeed = -speedX;
            if(!w && !s) speedY = 0;
            if(!a && !d) speedX = 0;
        }

        if(!Main.debugMode()) {
            if(map.getTile(plyX, plyY + speedYY) != null) {
                if(!map.getTile(plyX, plyY + speedYY).isSolid()) {
                    if(w) {
                        ySpeed = speedY;
                    }
                } else if(w) ySpeed = 0;
            } else if(w) ySpeed = 0;

            if(map.getTile(plyX, plyY - speedYY) != null) {
                if(!map.getTile(plyX, plyY - speedYY).isSolid()) {
                    if(s) {
                        ySpeed = -speedY;
                    }
                } else if(s) ySpeed = 0;
            } else if(s) ySpeed = 0;

            if(map.getTile(plyX + speedXX, plyY) != null) {
                if(!map.getTile(plyX + speedXX, plyY).isSolid()) {
                    if(a) {
                        xSpeed = speedX;
                    }
                }
            }
            if(map.getTile(plyX - speedXX, plyY) != null) {
                if(!map.getTile(plyX - speedXX, plyY).isSolid()) {
                    if(d) {
                        xSpeed = -speedX;
                    }
                } else if(d) xSpeed = 0;
            } else if(d) xSpeed = 0;

            if(!w && !s) {
                ySpeed = 0;
            }
            if(!a && !d) {
                xSpeed = 0;
            }
        }
    }
}