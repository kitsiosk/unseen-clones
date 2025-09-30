public class Clone308 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2515858
*  Stack Overflow answer #:47982124
*  And Stack Overflow answer#:2515876
*/
public static void main (String [] args) {
    String s = "AVBVDABCHJHDFABCJKHKHF", ned = "ABC";
    int nedIndex = - 1, count = 0, totalNed = 0;
    for (int i = 0;
    i < s.length (); i ++) {
        if (i > ned.length () - 1) nedIndex ++;
        else nedIndex = i;
        if (s.charAt (i) == ned.charAt (nedIndex)) count ++;
        else {
            nedIndex = 0;
            count = 0;
            if (s.charAt (i) == ned.charAt (nedIndex)) count ++;
            else nedIndex = - 1;
        }
        if (count == ned.length ()) {
            nedIndex = - 1;
            count = 0;
            totalNed ++;
            System.out.println (totalNed + " needle found at index=" + (i - (ned.length () - 1)));
        }
    }
    System.out.print ("Total Ned=" + totalNed);
}

public static void main (String [] args) {
    String needle = "ABC";
    String haystack = "ABCDSGDABCSAGAABCCCCAAABAABC";
    int numberOfOccurences = 0;
    int index = haystack.indexOf (needle);
    while (index != - 1) {
        numberOfOccurences ++;
        haystack = haystack.substring (index + needle.length ());
        index = haystack.indexOf (needle);
    }
    System.out.println ("" + numberOfOccurences);
}

}
