public class Clone961 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:53860834
*  Stack Overflow answer #:53860926
*  And Stack Overflow answer#:53860979
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

public String startOz (String str) {
    int len = str.length ();
    if (len < 1) return new String ("");
    if (len > 1 && str.charAt (0) == 'o' && str.charAt (1) == 'z') return new String ("oz");
    if (str.charAt (0) == 'o') return new String ("o");
    if (str.charAt (1) == 'z') return new String ("z");
    return new String ("");
}

}
