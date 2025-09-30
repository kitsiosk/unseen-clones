public class Clone624 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:17967114
*  Stack Overflow answer #:17967206
*  And Stack Overflow answer#:17974322
*/
public static int [] removeDuplicates (int [] arr) {
    HashSet < Integer > set = new HashSet < > ();
    final int len = arr.length;
    for (int i = 0;
    i < len; i ++) {
        set.add (arr [i]);
    }
    int [] whitelist = new int [set.size ()];
    int i = 0;
    for (Iterator < Integer > it = set.iterator ();
    it.hasNext ();) {
        whitelist [i ++] = it.next ();
    }
    return whitelist;
}

public static int [] removeDuplicates (int [] arr) {
    boolean [] set = new boolean [1001];
    int totalItems = 0;
    for (int i = 0;
    i < arr.length; ++ i) {
        if (! set [arr [i]]) {
            set [arr [i]] = true;
            totalItems ++;
        }
    }
    int [] ret = new int [totalItems];
    int c = 0;
    for (int i = 0;
    i < set.length; ++ i) {
        if (set [i]) {
            ret [c ++] = i;
        }
    }
    return ret;
}

}
