package Render;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import Player.Player;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;

public class PlayerRender {
    private static Image playerImage;
    private static Vector2f scale = new Vector2f(32, 49), pos = new Vector2f(0, 0);
    private static float speed;

    public static void renderPlayer(GameContainer gc, Player ply) {
        playerImage = ply.getPlayerClass().getClassImage();
        pos = ply.getPos();
        scale = ply.getScale();
        speed = ply.getSpeed();

        updatePlayer(gc);
        renderPlayer();
    }

    public static void updatePlayer(GameContainer gc) {
        Input input = gc.getInput();

        if(input.isKeyDown(Input.KEY_W)) {
            pos.y -= speed;
        }
        if(input.isKeyDown(Input.KEY_A)) {
            pos.x -= speed;
        }
        if(input.isKeyDown(Input.KEY_S)) {
            pos.y += speed;
        }
        if(input.isKeyDown(Input.KEY_D)) {
            pos.x += speed;
        }
    }

    public static void renderPlayer() {
        playerImage.draw(pos.x, pos.y, scale.x, scale.y);
    }
}
