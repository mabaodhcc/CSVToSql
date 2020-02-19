package util;

public class StringUtil {
    public static boolean isEmpty(String string) {
        if (string==null||string.length()==0||string.equals("")){
            return true;
        }
        return false;
    }
}
