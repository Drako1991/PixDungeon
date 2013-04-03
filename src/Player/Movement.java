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
            if(!w && !s) ySpeed = 0;
            if(!a && !d) xSpeed = 0;
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

    public static void rotate(GameContainer gc, Player ply) {
        Input input = gc.getInput();
        boolean w = input.isKeyDown(Input.KEY_W), a = input.isKeyDown(Input.KEY_A), s = input.isKeyDown(Input.KEY_S), d = input.isKeyDown(Input.KEY_D);
        float plyX = gc.getWidth() / 2, plyY = gc.getHeight() / 2, radiansToMouse = (float) Math.atan2(plyX - input.getMouseX(), plyY - input.getMouseY()),
                degreesToMouse = -(57.2957795f * radiansToMouse), angle = 0;
        boolean mouseControl;

        if(!w && !a && !s && !d) {
            mouseControl = true;
        } else {
            mouseControl = false;
        }

        if(!mouseControl) {
            if(w) {
                angle += 0;
                ply.setDirection(Directions.North);
                mouseControl = false;
            }

            if(w && d) {
                angle += 45;
                ply.setDirection(Directions.NorthEast);
                mouseControl = false;
            }
            if(d && !w && !s) {
                angle += 90;
                ply.setDirection(Directions.East);
                mouseControl = false;
            }
            if(s && d) {
                angle -= 45;
                ply.setDirection(Directions.SouthEast);
                mouseControl = false;
            }
            if(w && a) {
                angle -= 45;
                ply.setDirection(Directions.NorthWest);
                mouseControl = false;
            }
            if(s && a) {
                angle += 45;
                ply.setDirection(Directions.SouthWest);
                mouseControl = false;
            }

            if(a && !w && !s) {
                angle -= 90;
                ply.setDirection(Directions.West);
                mouseControl = false;
            }
            if(s) {
                angle += 180;
                ply.setDirection(Directions.South);
                mouseControl = false;
            }
        }

        if(mouseControl) {
            angle = degreesToMouse;
            if(angle > -22.5 && angle < 22.5) ply.setDirection(Directions.North);
            if(angle > 22.5 && angle < 67.5) ply.setDirection(Directions.NorthEast);
            if(angle > 67.5 && angle < 112.5) ply.setDirection(Directions.East);
            if(angle > 112.5 && angle < 157.5) ply.setDirection(Directions.SouthEast);
            if(angle > 157.5) ply.setDirection(Directions.South);
            if(angle < -157.5) ply.setDirection(Directions.South);
            if(angle > -157.5 && angle < -112.5) ply.setDirection(Directions.SouthWest);
            if(angle > -112.5 && angle < 67.5) ply.setDirection(Directions.West);
            if(angle > -67.5 && angle < -112.5) ply.setDirection(Directions.NorthWest);
        }

        ply.setRotation(angle);
    }
}