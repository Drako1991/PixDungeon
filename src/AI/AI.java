package AI;

import Mobs.Mob;

public class AI {
    private Mob mob;
    private float speed;
    private boolean canSeePlayer;

    public AI(Mob mob) {
        this.mob = mob;

        speed = mob.getSpeed();
    }

    public AI update() {
        return this;
    }

    public AI canSeePlayer(boolean canSee) {
        canSeePlayer = canSee;
        return this;
    }

    public boolean canSeePlayer() {
        return canSeePlayer;
    }
}