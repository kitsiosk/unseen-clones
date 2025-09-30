public class Clone828 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19552754
*  Stack Overflow answer #:28059496
*  And Stack Overflow answer#:21432777
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
