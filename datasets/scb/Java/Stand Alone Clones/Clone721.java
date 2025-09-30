public class Clone721 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:35474887
*  Stack Overflow answer #:35475467
*  And Stack Overflow answer#:35475559
*/
public static void main (String [] args) {
    Scanner stdin = new Scanner (System.in);
    int [] wordCount = new int [1000];
    String [] wordList = new String [1000];
    int j = 0;
    while (stdin.hasNextLine ()) {
        String s = stdin.nextLine ();
        String [] words = s.split ("\\W+");
        for (String word : words) {
            int listIndex = - 1;
            for (int i = 0;
            i < wordList.length; i ++) {
                if (word.equals (wordList [i])) {
                    listIndex = i;
                }
            }
            if (listIndex > - 1) {
                wordCount [listIndex] ++;
            } else {
                wordList [j] = word;
                wordCount [j] ++;
                j ++;
            }
        }
        for (int i = 0;
        i < j; i ++) {
            System.out.println ("the word: " + wordList [i] + " occured " + wordCount [i] + " time(s).");
        }
    }
}

public static void main (String [] args) {
    Scanner stdin = new Scanner (System.in);
    String [] wordArray = new String [10000];
    int [] wordCount = new int [10000];
    int numWords = 0;
    while (stdin.hasNextLine ()) {
        String s = stdin.nextLine ();
        ArrayList < String > noDuplicated = new ArrayList < String > ();
        String [] words = s.replaceAll ("[^a-zA-Z ]", "").toLowerCase ().split ("\\s+");
        for (int i = 0;
        i < words.length; i ++) {
            if (! noDuplicated.contains (words [i])) noDuplicated.add (words [i]);
        }
        for (int i = 0;
        i < noDuplicated.size (); i ++) {
            int count = 0;
            for (int j = 0;
            j < words.length; j ++) {
                if (noDuplicated.get (i).equals (words [j])) count ++;
            }
            System.out.println ("word count: → " + words [i] + " " + count);
        }
    }
}

}
