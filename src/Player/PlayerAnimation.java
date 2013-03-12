package Player;

public class PlayerAnimation {
    public static void animated(PlayerAnimStates anim) {
        switch(anim) {
            case WalkingW:
                System.out.println("WalkingW");
            case WalkingS:
                System.out.println("WalkingS");
            case WalkingA:
                System.out.println("WalkingA");
            case WalkingD:
                System.out.println("WalkingD");
            case WalkingWA:
                System.out.println("WalkingWA");
            case WalkingWD:
                System.out.println("WalkingWD");
            case WalkingSA:
                System.out.println("WalkingSA");
            case WalkingSD:
                System.out.println("WalkingSD");
            case Idle:
                System.out.println("Idle");
        }
    }
}
