public class Clone160 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13060062
*  Stack Overflow answer #:13060190
*  And Stack Overflow answer#:13060246
*/
public boolean checkZero (Class clazz) {
    boolean zeroNumericFields = true;
    Field [] fields = clazz.getDeclaredFields ();
    boolean zeroNumericFields = true;
    List < Class > numberClasses = new ArrayList < Class > ();
    numberClasses.add (Number.class);
    numberClasses.add (Integer.class);
    numberClasses.add (Long.class);
    numberClasses.add (Double.class);
    numberClasses.add (Float.class);
    if (fields.length > 0) {
        for (Field field : fields) {
            if (numberClasses.contains (field.getType ())) {
                zeroNumericFields = false;
                break;
            }
        }
    }
    return zeroNumericFields;
}

public static boolean checkZero (Object toCheck) {
    final Class < ? > numerics = new Class < ? > [] {int.class, double.class, float.class, long.class, short.class, byte.class, Integer.class, Double.class, Float.class, Long.class, Short.class, Byte.class};
    try {
        Class < ? > clazz = toCheck.getClass ();
        Field [] fields = clazz.getDeclaredFields ();
        for (Field field : fields) {
            Class < ? > type = field.getType ();
            boolean isNumeric = false;
            for (Class < ? > numeric : numerics) {
                if (type.equals (numeric)) {
                    isNumeric = true;
                    break;
                }
            }
            if (isNumeric) {
                Object value = field.get (toCheck);
                if (value == 0) {
                    return true;
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace ();
    }
    return false;
}

}
