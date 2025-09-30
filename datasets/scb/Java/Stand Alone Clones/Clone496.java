public class Clone496 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:25336620
*  Stack Overflow answer #:25337436
*  And Stack Overflow answer#:25337220
*/
public static void main (String [] args) {
    char [] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray ();
    final int mid = (chars.length + 1) / 2;
    System.out.println ("Mid: " + mid);
    System.out.println ("Start : " + new String (chars));
    if ((chars.length % 2) == 1) {
        char first = chars [0];
        for (int l = 1, r = mid;
        r < chars.length; l ++, r ++) {
            chars [l - 1] = chars [r];
            chars [r] = chars [l];
        }
        chars [mid - 1] = first;
    } else {
        for (int l = 0, r = mid;
        r < chars.length; l ++, r ++) {
            swap (chars, l, r);
        }
    }
    System.out.println ("Pass 1: " + new String (chars));
    swap (chars, 0, chars.length - 2);
    swap (chars, 1, chars.length - 1);
    System.out.println ("Pass 2: " + new String (chars));
    swap (chars, mid - 1, mid + 1);
    swap (chars, mid - 2, mid);
    System.out.println ("Pass 3: " + new String (chars));
}

public static void main (String [] args) {
    System.out.println ("Hello World");
    String xyz = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final int mid = (xyz.length () + 1) / 2;
    String [] spstr = {xyz.substring (0, mid), xyz.substring (mid)};
    String firstMix = spstr [1] + spstr [0];
    String [] array = firstMix.split ("");
    for (int i = 1;
    i < 3; i ++) {
        String temp = array [i];
        array [i] = array [array.length - i];
        array [array.length - i] = temp;
    }
    String str1 = Arrays.toString (array);
    str1 = str1.substring (1, str1.length () - 1).replaceAll (",", "");
    int j = 2;
    for (int i = ((array.length / 2) - 2);
    i < (array.length) / 2; i ++) {
        String temp = array [i];
        array [i] = array [array.length / 2 + j];
        array [array.length / 2 + j] = temp;
        j --;
    }
    String str2 = Arrays.toString (array);
    str2 = str2.substring (1, str2.length () - 1).replaceAll (",", "");
    System.out.println (firstMix);
    System.out.println (str1);
    System.out.println (str2);
}

}
