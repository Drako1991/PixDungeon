package BaseClasses;

public class Functions {
    public int findIndexWithString(String[] s, String in) {
        for(int i = 0; i <= s.length; i++) {
            if(s[i] == in) {
                return i;
            }else{
                return -1;
            }
        }
        return -1;
    }
}
