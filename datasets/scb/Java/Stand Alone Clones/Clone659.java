public class Clone659 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:9483703
*  Stack Overflow answer #:9483941
*  And Stack Overflow answer#:9483835
*/
public static void main (String [] args) {
    List < char [] > list = new ArrayList < char [] > ();
    list.add ("hello".toCharArray ());
    list.add ("world !".toCharArray ());
    char [] [] xss = list.toArray (new char [0] [0]);
    for (char [] xs : xss) {
        System.out.println (Arrays.toString (xs));
    }
}

public static void main (String...args) throws Exception {
    List < char [] > myArray = new ArrayList < char [] > ();
    myArray.add ("string1".toCharArray ());
    myArray.add ("string2".toCharArray ());
    myArray.add ("string3".toCharArray ());
    char [] [] charArray2D = myArray.toArray (new char [0] [0]);
    System.out.println (charArray2D.length);
    StringBuilder s = new StringBuilder ();
    for (char [] c : myArray) {
        s.append (String.copyValueOf (c));
    }
    char [] charArray1D = s.toString ().toCharArray ();
    System.out.println (charArray1D.length);
}

}
