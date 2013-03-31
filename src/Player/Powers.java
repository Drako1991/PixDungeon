package Player;

import org.newdawn.slick.Color;

public class Powers {
    private static int maxPower;
    private static String powerName;
    private static Color powerColor;

    public Powers(int max, String name, Color color) {
        powerName = name;
        maxPower = max;
        powerColor = color;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public String getPowerName() {
        return powerName;
    }

    public Color getPowerColor() {
        return powerColor;
    }
}