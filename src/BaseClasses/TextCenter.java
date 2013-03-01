package BaseClasses;

import Main.Entity;

public class TextCenter {
    private static float x;

    public static float getCenterTextX(String name, float x) {

        if (name.length() > 6) {
            x = (float) (x - name.length() * 2.5);
        } else if (name.length() > 4 && name.length() <= 6) {
            x = x - name.length() - 1;
        } else if (name.length() == 4) {
            x = x - name.length() + 3;
        }
        return x;
    }
}