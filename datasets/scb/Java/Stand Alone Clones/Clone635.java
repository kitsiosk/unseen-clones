public class Clone635 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:40798319
*  Stack Overflow answer #:40798444
*  And Stack Overflow answer#:40798403
*/
public int compare (String s1, String s2) {
    String [] s1NameNumPair = s1.split (" ");
    String [] s2NameNumPair = s2.split (" ");
    if (s1NameNumPair [0].compareTo (s2NameNumPair [0]) > 1) {
        return 1;
    } else if (s1NameNumPair [0].compareTo (s2NameNumPair [0]) < 0) {
        return - 1;
    } else {
        Double n1 = Double.parseDouble (s1NameNumPair [1]);
        Double n2 = Double.parseDouble (s2NameNumPair [1]);
        if (n1 > n2) {
            return 1;
        } else if (n1 < n2) {
            return - 1;
        } else {
            return 0;
        }
    }
}

public int compare (String s1, String s2) {
    String [] s1NameNumPair = s1.split (" ");
    String [] s2NameNumPair = s2.split (" ");
    int diff = s1NameNumPair [0].compareTo (s2NameNumPair [0]);
    if (0 == diff) {
        Double n1 = Double.parseDouble (s1NameNumPair [1]);
        Double n2 = Double.parseDouble (s2NameNumPair [1]);
        return n1.compareTo (n2);
    }
    return diff;
}

}
