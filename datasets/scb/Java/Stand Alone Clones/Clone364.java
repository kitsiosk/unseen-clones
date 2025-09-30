public class Clone364 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19538999
*  Stack Overflow answer #:19541306
*  And Stack Overflow answer#:19539055
*/
public static int TestTryFinallyBlock () {
    int returnValue;
    try {
        int i = 0;
        i = 10;
        returnValue = i;
        i = 40;
        return returnValue;
    } catch (RuntimeException e) {
        i = 40;
        throw e;
    }
}

public static int TestTryFinallyBlock () {
    int i = 0;
    try {
        i = 10;
        return i;
    } finally {
        i = 40;
        System.out.println ("local: " + i);
    }
}

}
