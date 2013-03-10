package BaseClasses;

public class Functions {
    public static int findStringIndex(String[] s, String in) {
        for (int i = 0; i <= s.length; i++) {
            if (s[i] == in) {
                return i;
            }
        }
        return -1;
    }

    public static int findIntIndex(int[] s, int in) {
        for (int i = 0; i <= s.length; i++) {
            if (s[i] == in) {
                return i;
            }
        }
        return -1;
    }

    public static boolean doesStringExist(String[] s, String in) {
        for (int i = 0; i <= s.length; i++) {
            if (s[i] == in) {
                return true;
            }
        }
        return false;
    }

    public static boolean doesIntExist(int[] s, int in) {
        for (int i = 0; i <= s.length; i++) {
            if (s[i] == in) {
                return true;
            }
        }
        return false;
    }
}
