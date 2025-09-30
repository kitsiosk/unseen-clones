public class Clone363 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:25187446
*  Stack Overflow answer #:25298212
*  And Stack Overflow answer#:25187918
*/
public static void main (String...argv) throws ClassNotFoundException {
    Class < Foo > fooClass = loadClass ();
    initializeClass (fooClass);
    URLClassLoader myClassLoader = ((URLClassLoader) InitializeClassMultipleTimes.class.getClassLoader ());
    URL [] urls = myClassLoader.getURLs ();
    for (int i = 0;
    i < 2; i ++) {
        URLClassLoader newClassLoader = new URLClassLoader (urls, null);
        System.out.format ("%nLoading class using another class loader%n", Foo.class.getSimpleName ());
        Class < ? > fooClassAgain = Class.forName (fooClass.getName (), false, newClassLoader);
        initializeClass (fooClassAgain);
    }
}

public static void main (String [] args) {
    CustomClassLoader loader = new CustomClassLoader ();
    try {
        Class < ? > c = loader.findClass ("sample.Sample");
        Object o = c.newInstance ();
    } catch (ClassNotFoundException e) {
        e.printStackTrace ();
    } catch (InstantiationException e) {
        e.printStackTrace ();
    } catch (IllegalAccessException e) {
        e.printStackTrace ();
    }
}

}
