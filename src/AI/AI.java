package AI;

import Mobs.Mob;

public class AI {
    private Mob mob;
    private float speed;

    public AI(Mob mob) {
        this.mob = mob;

        speed = mob.getSpeed();
    }

    public AI update() {
        return this;
    }
}
