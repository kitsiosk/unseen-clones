public class Clone311 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:50218273
*  Stack Overflow answer #:50218440
*  And Stack Overflow answer#:50218470
*/
public static void print (Object...items) {
    for (Object item : items) {
        if (item.getClass ().isArray ()) {
            Object [] objs = primitiveArrayFrom (item);
            if (objs == null) {
                objs = (Object []) item;
            }
            for (Object obj : objs) {
                System.out.println (obj);
            }
        } else {
            System.out.println (item);
        }
    }
}

public static void print (Object...toPrint) {
    for (Object item : toPrint) {
        if (item.getClass () == int [].class) {
            System.out.println (Arrays.toString ((int []) item));
        } else if (item.getClass () == double [].class) {
            System.out.println (Arrays.toString ((double []) item));
        } else if (item instanceof Object []) {
            System.out.println (Arrays.toString ((Object []) item));
        } else {
            System.out.println (item);
        }
    }
}

}
