public class Clone270 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:203475
*  Stack Overflow answer #:6843336
*  And Stack Overflow answer#:203571
*/
public static boolean isImmutable (Object object) {
    if (object instanceof Number) {
        if (object instanceof AtomicInteger) {
        } else if (object instanceof AtomicLong) {
        } else {
            return true;
        }
    } else if (object instanceof String) {
        return true;
    } else if (object instanceof Character) {
        return true;
    } else if (object instanceof Class) {
        return true;
    }
    Class < ? > objClass = object.getClass ();
    if (! Modifier.isFinal (objClass.getModifiers ())) {
        return false;
    }
    Field [] objFields = objClass.getDeclaredFields ();
    for (int i = 0;
    i < objFields.length; i ++) {
        if (! Modifier.isFinal (objFields [i].getModifiers ()) || ! isImmutable (objFields [i].getType ())) {
            return false;
        }
    }
    return true;
}

static boolean isImmutable (Object obj) {
    Class < ? > objClass = obj.getClass ();
    Class < ? > superClass = objClass.getSuperclass ();
    if (! Immutable.class.equals (superClass)) {
        return false;
    }
    if (! Modifier.isFinal (objClass.getModifiers ())) {
        return false;
    }
    Field [] objFields = objClass.getDeclaredFields ();
    for (int i = 0;
    i < objFields.length; i ++) {
        if (! Modifier.isFinal (objFields [i].getModifiers ()) || ! isValidFieldType (objFields [i].getType ())) {
            return false;
        }
    }
    return true;
}

}
