package Render;

import Main.Main;
import Player.Directions;
import Player.Player;
import States.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import Player.Movement;

public class PlayerRender {
    private static Image playerImage;
    private static float xSpeed, ySpeed;
    private static boolean mouseControl;
    private Player ply;
    private GameContainer gc;

    public PlayerRender(Player ply, GameContainer gc) {
        this.ply = ply;
        this.gc = gc;
    }

    public PlayerRender renderPlayer() {
        playerImage = ply.getPlayerClass().getClassImage();

        playerImage.rotate(ply.getRotation());
        playerImage.draw(gc.getWidth() / 2, gc.getHeight() / 2, ply.getScale().x, ply.getScale().y);

        rotate();
        Movement.move(gc, ply);
        return this;
    }

    private PlayerRender rotate() {
        Input input = gc.getInput();
        boolean w = input.isKeyDown(Input.KEY_W), a = input.isKeyDown(Input.KEY_A), s = input.isKeyDown(Input.KEY_S), d = input.isKeyDown(Input.KEY_D);
        float plyX = gc.getWidth() / 2, plyY = gc.getHeight() / 2, radiansToMouse = (float) Math.atan2(plyX - input.getMouseX(), plyY - input.getMouseY()),
                degreesToMouse = -(57.2957795f * radiansToMouse), angle = 0;

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
        }

        ply.setRotation(angle);

        return this;
    }
}