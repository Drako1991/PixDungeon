package Render;

import Player.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import Player.Movement;

public class PlayerRender {
    private static Image playerImage;
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

        Movement.rotate(gc, ply);
        Movement.move(gc, ply);
        return this;
    }

}