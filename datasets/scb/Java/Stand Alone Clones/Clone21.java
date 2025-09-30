public class Clone21 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:36343209
*  Stack Overflow answer #:36344302
*  And Stack Overflow answer#:36343689
*/
public static void main (String [] args) {
    double numIterations = 10;
    long exceptionPlusCatchTime = 0, excepTime = 0, strTime = 0, throwTime = 0;
    for (int i = 0;
    i < numIterations; i ++) {
        exceptionPlusCatchTime += exceptionPlusCatchBlock ();
        excepTime += createException ();
        throwTime += catchBlock ();
        strTime += createString ();
    }
    System.out.println ("new Exception + throw/catch = " + exceptionPlusCatchTime / numIterations);
    System.out.println ("new Exception only          = " + excepTime / numIterations);
    System.out.println ("throw/catch only            = " + throwTime / numIterations);
    System.out.println ("new String (benchmark)      = " + strTime / numIterations);
}

public static void main (String [] args) {
    long throwCatchTime = 0, newExceptionTime = 0, newObjectTime = 0, noStackExceptionTime = 0;
    for (int i = 0;
    i < 30; i ++) {
        throwCatchTime += throwCatchLoop ();
        newExceptionTime += newExceptionLoop ();
        newObjectTime += newObjectLoop ();
        noStackExceptionTime += newNoStackExceptionLoop ();
    }
    System.out.println ("throwCatchTime = " + throwCatchTime / 30);
    System.out.println ("newExceptionTime = " + newExceptionTime / 30);
    System.out.println ("newStringTime = " + newObjectTime / 30);
    System.out.println ("noStackExceptionTime = " + noStackExceptionTime / 30);
}

}
