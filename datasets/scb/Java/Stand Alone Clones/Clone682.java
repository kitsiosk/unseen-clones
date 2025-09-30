public class Clone682 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:4989091
*  Stack Overflow answer #:29855633
*  And Stack Overflow answer#:7008285
*/
public static void main (String args []) {
    String result = new String (removeDupes (new char [] {'a', 'b', 'c', 'd', 'a'}));
    assert "abcd".equals (result) : "abcda should return abcd but it returns: " + result;
    result = new String (removeDupes (new char [] {'a', 'a', 'a', 'a'}));
    assert "a".equals (result) : "aaaa should return a but it returns: " + result;
    result = new String (removeDupes (new char [] {'a', 'b', 'c', 'a'}));
    assert "abc".equals (result) : "abca should return abc but it returns: " + result;
    result = new String (removeDupes (new char [] {'a', 'a', 'b', 'b'}));
    assert "ab".equals (result) : "aabb should return ab but it returns: " + result;
    result = new String (removeDupes (new char [] {'a'}));
    assert "a".equals (result) : "a should return a but it returns: " + result;
    result = new String (removeDupes (new char [] {'a', 'b', 'b', 'a'}));
    assert "ab".equals (result) : "abba should return ab but it returns: " + result;
    char [] arr = bigArr (5000000);
    long startTime = System.nanoTime ();
    System.out.println ("2: " + new String (removeDupes (arr)));
    long endTime = System.nanoTime ();
    long duration = (endTime - startTime);
    System.out.println ("Program took: " + duration + " nanoseconds");
    System.out.println ("Program took: " + duration / 1000000000 + " seconds");
}

public static void main (String [] args) {
    String s = "harikrishna";
    String s2 = "";
    for (int i = 0;
    i < s.length (); i ++) {
        Boolean found = false;
        for (int j = 0;
        j < s2.length (); j ++) {
            if (s.charAt (i) == s2.charAt (j)) {
                found = true;
                break;
            }
        }
        if (found == false) {
            s2 = s2.concat (String.valueOf (s.charAt (i)));
        }
    }
    System.out.println (s2);
}

}
