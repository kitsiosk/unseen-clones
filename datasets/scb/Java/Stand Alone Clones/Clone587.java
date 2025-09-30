public class Clone587 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:50788447
*  Stack Overflow answer #:50789389
*  And Stack Overflow answer#:50788897
*/
public static void main (String [] args) {
    String userInput = "Peter";
    int length = userInput.length ();
    int m, j, i, n = 0;
    for (m = length % 2 > 0 ? 1 : 2; m < length * 2; m += 2) {
        i = m < length ? m : length * 2 - m;
        for (j = 0; j < length - 1 - i / 2; ++ j) {
            System.out.print (" ");
        }
        for (j = 0; j < i; ++ j) {
            char c = userInput.charAt (n ++ % length);
            c = j == 0 ? Character.toUpperCase (c) : Character.toLowerCase (c);
            System.out.print (c);
        }
        System.out.println ("");
    }
}

public static void main (String [] args) {
    Scanner keyboard = new Scanner (System.in);
    String userInput = keyboard.next ();
    String concatenated = userInput;
    int i, cumSum = 0;
    ArrayList < Integer > helperIndex = new ArrayList < > ();
    for (i = 1; i < userInput.length (); i += 2) {
        helperIndex.add (i);
        cumSum += i;
    }
    for (i = userInput.length (); i > 0; i -= 2) {
        helperIndex.add (i);
        cumSum += i;
    }
    int numOfWordRepitition = cumSum / userInput.length ();
    for (i = 0; i < numOfWordRepitition; i ++) {
        concatenated += userInput;
    }
    String substr;
    int prev = helperIndex.get (0);
    int next = helperIndex.get (0);
    substr = concatenated.substring (0, helperIndex.get (0));
    System.out.println (Character.toUpperCase (substr.charAt (0)) + substr.substring (1));
    for (i = 1; i < userInput.length (); i ++) {
        next += helperIndex.get (i);
        substr = concatenated.substring (prev, next);
        substr = Character.toUpperCase (substr.charAt (0)) + substr.substring (1);
        System.out.println (substr);
        prev = next;
    }
}

}
