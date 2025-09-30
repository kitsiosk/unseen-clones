public class Clone936 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6947707
*  Stack Overflow answer #:18687387
*  And Stack Overflow answer#:6948410
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

public static void main (String [] args) throws Exception {
    int loops = 1000 * 1000;
    Object object = new Object ();
    long start = System.nanoTime ();
    Object s;
    testMethodCall (object, loops);
    long regularCalls = System.nanoTime () - start;
    java.lang.reflect.Method method = Object.class.getMethod ("getClass");
    method.setAccessible (true);
    start = System.nanoTime ();
    testInvoke (object, loops, method);
    long reflectiveCalls = System.nanoTime () - start;
    start = System.nanoTime ();
    testGetMethodInvoke (object, loops);
    long reflectiveLookup = System.nanoTime () - start;
    System.out.println ("Average regular method calls:" + regularCalls / loops + " ns.");
    System.out.println ("Average reflective method calls without lookup:" + reflectiveCalls / loops + " ns.");
    System.out.println ("Average reflective method calls with lookup:" + reflectiveLookup / loops + " ns.");
}

}
