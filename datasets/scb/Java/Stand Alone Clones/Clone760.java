public class Clone760 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:4516891
*  Stack Overflow answer #:6117735
*  And Stack Overflow answer#:6117735
*/
static void investigate (Type t, Type...typeArgs) {
    if (t == null) return;
    if (t instanceof Class < ? >) {
        investigate ((Class < ? >) t, typeArgs);
    } else if (t instanceof ParameterizedType) {
        investigate ((ParameterizedType) t, typeArgs);
    }
}

static void investigate (ParameterizedType p, Type...typeArgs) {
    final Class < ? > c = (Class < ? >) p.getRawType ();
    final StringBuilder b = new StringBuilder (c.getName ());
    b.append ('<');
    Type [] localArgs = p.getActualTypeArguments ();
    if (typeArgs != null && typeArgs.length > 0) {
        int i = 0, nextTypeArg = 0;
        for (Type local : localArgs) {
            if (local instanceof ParameterizedType) {
                ParameterizedType localP = (ParameterizedType) local;
                b.append (localP.getRawType ()).append ('<');
                b.append (typeArgs [nextTypeArg ++]);
                b.append ('>');
            } else if (local instanceof TypeVariable) {
                localArgs [nextTypeArg] = typeArgs [nextTypeArg];
                b.append (localArgs [nextTypeArg]);
                nextTypeArg ++;
            } else {
                b.append (local.toString ());
            }
            b.append (", ");
            i ++;
        }
        if (typeArgs.length > 0) {
            b.delete (b.length () - 2, b.length ());
        }
        b.append ('>');
    } else {
        String args = Arrays.toString (localArgs);
        b.append (args.substring (1, args.length () - 1)).append ('>');
    }
    System.out.println (b);
    investigate (c, localArgs);
}

}
