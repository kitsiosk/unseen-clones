public class Clone886 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:4674850
*  Stack Overflow answer #:22409526
*  And Stack Overflow answer#:25476257
*/
public static void main (String [] args) {
    String s = "a a a A A";
    String [] splitedString = s.split (" ");
    Map m = new HashMap ();
    int count = 1;
    for (String s1 : splitedString) {
        count = m.containsKey (s1) ? count + 1 : 1;
        m.put (s1, count);
    }
    Iterator < StringToword > itr = m.entrySet ().iterator ();
    while (itr.hasNext ()) {
        System.out.println (itr.next ());
    }
}

public static void main (String [] args) {
    System.out.println ("Please enter the String");
    Scanner input = new Scanner (System.in);
    String userInput = input.nextLine ().trim ();
    int numOfWords = getNumberOfWords (userInput);
    char words [] [] = new char [numOfWords + 1] [];
    words = getWordsFromString (userInput);
    System.out.println ("Total number of words found in the String is " + (numOfWords));
    for (int i = 0;
    i < numOfWords; i ++) {
        System.out.println (" ");
        for (int j = 0;
        j < words [i].length; j ++) {
            System.out.print (words [i] [j]);
        }
    }
}

}
