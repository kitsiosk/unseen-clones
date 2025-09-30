public class Clone960 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:53860834
*  Stack Overflow answer #:53860926
*  And Stack Overflow answer#:53860982
*/
public String startOz (String str) {
    if (str != null) {
        char [] arr = str.toLowerCase ().toCharArray ();
        boolean oTest = arr.length >= 1 && arr [0] == 'o';
        boolean zTest = arr.length >= 2 && arr [1] == 'z';
        if (oTest && zTest) {
            return "oz";
        } else if (oTest) {
            return "o";
        } else if (zTest) {
            return "z";
        }
    }
    return "";
}

public static String startOz (String str) {
    if (str.length () >= 2 && str.substring (0, 2).equals ("oz")) {
        return "oz";
    } else if (str.length () >= 2 && str.substring (1, 2).equals ("z")) {
        return "z";
    } else if (str.length () >= 2 && str.substring (0, 1).equals ("o")) {
        return "o";
    }
    return "";
}

}
