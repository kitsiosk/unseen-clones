public class Clone935 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6947707
*  Stack Overflow answer #:18687387
*  And Stack Overflow answer#:6948325
*/
public static void main (String [] args) throws Exception {
    Experius a = new Experius ();
    int count = 10000000;
    int v = 0;
    long tm = System.currentTimeMillis ();
    for (int i = 0;
    i < count; ++ i) {
        v = a.something (i + v);
        ++ v;
    }
    tm = System.currentTimeMillis () - tm;
    System.out.println ("Time: " + tm);
    tm = System.currentTimeMillis ();
    Method method = Experius.class.getMethod ("something", Integer.TYPE);
    for (int i = 0;
    i < count; ++ i) {
        Object o = method.invoke (a, i + v);
        ++ v;
    }
    tm = System.currentTimeMillis () - tm;
    System.out.println ("Time: " + tm);
}

public static void main (String [] args) throws NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    Object obj = new Object ();
    Class < Object > objClass = Object.class;
    String s;
    long start = System.nanoTime ();
    s = obj.toString ();
    long directInvokeEnd = System.nanoTime ();
    System.out.println (s);
    long methodLookupStart = System.nanoTime ();
    java.lang.reflect.Method method = objClass.getMethod ("toString");
    long methodLookupEnd = System.nanoTime ();
    s = (String) (method.invoke (obj));
    long reflectInvokeEnd = System.nanoTime ();
    System.out.println (s);
    System.out.println (directInvokeEnd - start);
    System.out.println (methodLookupEnd - methodLookupStart);
    System.out.println (reflectInvokeEnd - methodLookupEnd);
}

}
