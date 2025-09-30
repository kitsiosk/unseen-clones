public class Clone623 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:17967114
*  Stack Overflow answer #:17967206
*  And Stack Overflow answer#:29633545
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
    int end = arr.length;
    for (int i = 0;
    i < end; i ++) {
        for (int j = i + 1;
        j < end; j ++) {
            if (arr [i] == arr [j]) {
                arr [j] = arr [end - 1];
                end --;
                j --;
            }
        }
    }
    int [] whitelist = new int [end];
    System.arraycopy (arr, 0, whitelist, 0, end);
    return whitelist;
}

}
