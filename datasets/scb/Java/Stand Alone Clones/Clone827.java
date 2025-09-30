public class Clone827 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19552754
*  Stack Overflow answer #:35662562
*  And Stack Overflow answer#:26011529
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
