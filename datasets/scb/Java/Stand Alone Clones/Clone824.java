public class Clone824 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19552754
*  Stack Overflow answer #:35662562
*  And Stack Overflow answer#:28059496
*/
public int [] solution (String S, int [] P, int [] K) {
    char [] sc = S.toCharArray ();
    int [] A = new int [sc.length];
    int [] G = new int [sc.length];
    int [] C = new int [sc.length];
    int prevA = - 1, prevG = - 1, prevC = - 1;
    for (int i = 0;
    i < sc.length; i ++) {
        if (sc [i] == 'A') prevA = i;
        else if (sc [i] == 'G') prevG = i;
        else if (sc [i] == 'C') prevC = i;
        A [i] = prevA;
        G [i] = prevG;
        C [i] = prevC;
    }
    int [] result = new int [P.length];
    for (int i = 0;
    i < P.length; i ++) {
        if (A [K [i]] >= P [i] && A [K [i]] <= K [i]) {
            result [i] = 1;
        } else if (C [K [i]] >= P [i] && C [K [i]] <= K [i]) {
            result [i] = 2;
        } else if (G [K [i]] >= P [i] && G [K [i]] <= K [i]) {
            result [i] = 3;
        } else {
            result [i] = 4;
        }
    }
    return result;
}

public static int [] solution (String S, int [] P, int [] Q) {
    int [] arr = new int [S.length ()];
    for (int i = 0;
    i < S.length (); i ++) {
        switch (S.charAt (i)) {
            case 'A' :
                arr [i] = 1;
                break;
            case 'C' :
                arr [i] = 2;
                break;
            case 'G' :
                arr [i] = 3;
                break;
            case 'T' :
                arr [i] = 4;
                break;
            default :
                break;
        }
    }
    segmentNode root = buildTree (arr, 0, S.length () - 1);
    int [] result = new int [P.length];
    for (int i = 0;
    i < P.length; i ++) {
        result [i] = getMin (root, P [i], Q [i]);
    }
    return result;
}

}
