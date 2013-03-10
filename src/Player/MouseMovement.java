package Player;

import Main.Component;
import TileMap.TileConverter;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class MouseMovement extends Component {
    float direction;
    float speed = 0.4f;
    int mouseX, mouseY;
    static PlayerAnimStates animState = PlayerAnimStates.Idle;
    private static boolean mouseControl = true;

    public void setAnimState(PlayerAnimStates state) {
        animState = state;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getDirection() {
        return direction;
    }

    public MouseMovement(String id) {
        this.id = id;
    }

    public void mousePressed(int x, int y) {
        mouseX = x;
        mouseY = y;
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sb, int delta) {
        Input input = gc.getInput();
        float scale = owner.getScale();
        Vector2f position = owner.getPosition();
        float speed = this.speed * delta;

        if (TileConverter.getTile(position.x, position.y - speed) != null) {
            if (input.isKeyDown(Input.KEY_W) && !TileConverter.getTile(position.x, position.y - speed).isSolid()) {
                position.y -= speed;
            }
        }else{
            if(input.isKeyDown(Input.KEY_W)) {
                position.y -= speed;
            }
        }
        if (input.isKeyDown(Input.KEY_S)) position.y += speed;
        if (input.isKeyDown(Input.KEY_D)) position.x += speed;
        if (input.isKeyDown(Input.KEY_A)) position.x -= speed;

        owner.setRotation(getRotation(gc));
        owner.setPosition(position);
        owner.setScale(scale);
    }

    private float getRotation(GameContainer gc) {
        Input input = gc.getInput();
        float plyX = gc.getWidth() / 2, plyY = gc.getHeight() / 2, radiansToMouse = (float) Math.atan2(plyX - input.getMouseX(), plyY - input.getMouseY()),
                degreesToMouse = (57.2957795f * radiansToMouse) * -1, angle = 0;
        boolean w = gc.getInput().isKeyDown(Input.KEY_W), s = gc.getInput().isKeyDown(Input.KEY_S), a = gc.getInput().isKeyDown(Input.KEY_A),
                d = gc.getInput().isKeyDown(Input.KEY_D);

        if (!w && !s && !a && !d) {
            angle = degreesToMouse;
            mouseControl = true;
        }

        if (w) {
            angle += 0;
            mouseControl = false;
        }

        if (w && d) {
            angle += 45;
            mouseControl = false;
        }

        if (d && !w && !s) {
            angle += 90;
            mouseControl = false;
        }

        if (s && d) {
            angle -= 45;
            mouseControl = false;
        }

        if (w && a) {
            angle -= 45;
            mouseControl = false;
        }

        if (s && a) {
            angle += 45;
            mouseControl = false;
        }

        if (a && !w && !s) {
            angle -= 90;
            mouseControl = false;
        }

        if (s) {
            angle += 180;
            mouseControl = false;
        }

        return angle;
    }
}