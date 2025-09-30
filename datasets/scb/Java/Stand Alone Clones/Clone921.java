public class Clone921 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:122407
*  Stack Overflow answer #:5347558
*  And Stack Overflow answer#:687655
*/
public static void main (String [] args) {
    final A a = new A ();
    final B b = new B ();
    NameFuncPair [] fArray = new NameFuncPair [] {new NameFuncPair ("A") {
        @Override
        void f (String x) {
            a.g (x);
        }}
    , new NameFuncPair ("B") {
        @Override
        void f (String x) {
            b.h (x);
        }}
    ,};
    for (NameFuncPair fInstance : fArray) {
        if (fInstance.name.equals ("B")) {
            fInstance.f (fInstance.name + "(some args)");
        }
    }
}

public static void main (final String [] argv) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    final String methodName;
    final Method method;
    final Main main;
    main = new Main ();
    if (argv.length == 0) {
        methodName = "foo";
    } else {
        methodName = "bar";
    }
    method = Main.class.getDeclaredMethod (methodName, int.class);
    main.car (method, 42);
}

}
