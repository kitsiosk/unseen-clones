public class Clone22 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:54919126
*  Stack Overflow answer #:54919528
*  And Stack Overflow answer#:54919356
*/
public static void main (String [] args) {
    List < Integer > numberList = new ArrayList < > ();
    List < String > strList = new ArrayList < > ();
    for (int i = 0;
    i < args.length; i ++) {
        if (Pattern.matches ("-?\\d+", args [i])) {
            numberList.add (Integer.parseInt (args [i]));
        } else {
            strList.add (args [i]);
        }
    }
    String [] colors = strList.toArray (new String [0]);
    int [] number = ArrayUtils.toPrimitive (numberList.toArray (new Integer [numberList.size ()]));
}

public static void main (String [] args) {
    String [] colors = new String [args.length];
    int color_ix = 0;
    int number_idx = 0;
    Integer [] number = new Integer [args.length];
    for (int i = 0;
    i < args.length; i ++) {
        if (args [i] == null) {
            continue;
        }
        try {
            number [number_idx] = Integer.parseInt (args [i]);
            number_idx ++;
        } catch (NumberFormatException e) {
            colors [color_ix] = args [i];
            color_ix ++;
        }
    }
    System.out.println ("-----Number-----");
    for (int i = 0;
    i < number_idx; i ++) {
        System.out.println (number [i]);
    }
    System.out.println ("-----Colors-----");
    for (int i = 0;
    i < color_ix; i ++) {
        System.out.println (colors [i]);
    }
}

}
