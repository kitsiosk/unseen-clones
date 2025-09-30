public class Clone825 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19552754
*  Stack Overflow answer #:35662562
*  And Stack Overflow answer#:21432777
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
    final char [] characterInput = S.toCharArray ();
    final int [] integerInput = new int [characterInput.length];
    for (int counter = 0;
    counter < characterInput.length; counter ++) {
        integerInput [counter] = characterMapping.get (characterInput [counter]);
    }
    int [] result = new int [P.length];
    for (int index = 0;
    index < P.length; index ++) {
        if (P [index] == Q [index]) {
            result [index] = integerInput [P [index]];
            break;
        }
        final int [] subArray = Arrays.copyOfRange (integerInput, P [index], Q [index] + 1);
        final int minimumValue = minimum (subArray);
        result [index] = minimumValue;
    }
    return result;
}

}
