package Render;

import States.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import Player.Player;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;

public class PlayerRender {
    private static Image playerImage;
    private static float xSpeed, ySpeed;

    public static void renderPlayer(GameContainer gc, Player ply) {
        playerImage = ply.getPlayerClass().getClassImage();

        updatePlayer(gc, ply);
        renderPlayer(ply);
    }

    public static void updatePlayer(GameContainer gc, Player ply) {
        Input input = gc.getInput();
        ply.addPos(xSpeed, ySpeed);
        float speedX = ply.getSpeed()*Game.getTileSize().x/64, speedY = ply.getSpeed()*Game.getTileSize().y/64;

        if(input.isKeyDown(Input.KEY_W)) {
            ySpeed = -speedY;
        }
        if(input.isKeyDown(Input.KEY_A)) {
            xSpeed = -speedX;
        }
        if(input.isKeyDown(Input.KEY_S)) {
            ySpeed = speedY;
        }
        if(input.isKeyDown(Input.KEY_D)) {
            xSpeed = speedX;
        }
        if(!input.isKeyDown(Input.KEY_W) && !input.isKeyDown(Input.KEY_S)) {
            ySpeed = 0;
        }
        if(!input.isKeyDown(Input.KEY_A) && !input.isKeyDown(Input.KEY_D)) {
            xSpeed = 0;
        }
    }

    public static void renderPlayer(Player ply) {
        playerImage.draw(ply.getPos().x, ply.getPos().y, ply.getScale().x, ply.getScale().y);
        playerImage.rotate(ply.getRotation());
    }
}
