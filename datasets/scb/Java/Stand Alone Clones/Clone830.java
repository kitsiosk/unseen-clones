public class Clone830 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19552754
*  Stack Overflow answer #:28059496
*  And Stack Overflow answer#:26011529
*/
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

public int [] solution (String S, int [] P, int [] Q) {
    int N = S.length ();
    int M = P.length;
    int [] result = new int [M];
    lastOccurrencesMap = new int [3] [N];
    int lastA = - 1;
    int lastC = - 1;
    int lastG = - 1;
    for (int i = 0;
    i < N; i ++) {
        char c = S.charAt (i);
        if (c == 'A') {
            lastA = i;
        } else if (c == 'C') {
            lastC = i;
        } else if (c == 'G') {
            lastG = i;
        }
        lastOccurrencesMap [0] [i] = lastA;
        lastOccurrencesMap [1] [i] = lastC;
        lastOccurrencesMap [2] [i] = lastG;
    }
    for (int i = 0;
    i < M; i ++) {
        int startIndex = P [i];
        int endIndex = Q [i];
        int minimum = 4;
        for (int n = 0;
        n < 3; n ++) {
            int lastOccurence = getLastNucleotideOccurrence (startIndex, endIndex, n);
            if (lastOccurence != 0) {
                minimum = n + 1;
                break;
            }
        }
        result [i] = minimum;
    }
    return result;
}

}
