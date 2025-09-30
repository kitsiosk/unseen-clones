public class Clone155 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:25130557
*  Stack Overflow answer #:25131007
*  And Stack Overflow answer#:25130926
*/
public static void throwException (final String key) throws Throwable {
    ExceptionMapping exceptionMapping = exceptionMappings.getExceptionMappings ().get (key);
    if (exceptionMapping != null) {
        try {
            Class < Throwable > exceptionClass = (Class < Throwable >) Class.forName (exceptionMapping.getClassName ());
            try {
                throw exceptionClass.cast (exceptionClass.newInstance ());
            } catch (InstantiationException e) {
                e.printStackTrace ();
            } catch (IllegalAccessException e) {
                e.printStackTrace ();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }
}

public static void throwException (String className) throws CheckedException, UncheckedException {
    Class < ? > exceptionClass;
    try {
        exceptionClass = Class.forName (className);
    } catch (ClassNotFoundException e) {
        throw new IllegalArgumentException (e);
    }
    try {
        if (CheckedException.class.isAssignableFrom (exceptionClass)) {
            throw exceptionClass.asSubclass (CheckedException.class).newInstance ();
        } else if (UncheckedException.class.isAssignableFrom (exceptionClass)) {
            throw exceptionClass.asSubclass (UncheckedException.class).newInstance ();
        } else {
            throw new IllegalArgumentException ("Not a valid exception type: " + exceptionClass.getName ());
        }
    } catch (InstantiationException | IllegalAccessException e) {
        throw new IllegalStateException (e);
    }
}

}
