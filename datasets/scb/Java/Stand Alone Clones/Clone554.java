public class Clone554 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3904579
*  Stack Overflow answer #:41737694
*  And Stack Overflow answer#:49294191
*/
public static void main (String [] args) {
    final String str1 = "HELLO WORLD";
    System.out.println (capitalizeFirstLetter (str1));
    final String str2 = "Hello WORLD";
    System.out.println (capitalizeFirstLetter (str2));
    final String str3 = "hello world";
    System.out.println (capitalizeFirstLetter (str3));
    final String str4 = "heLLo wORld";
    System.out.println (capitalizeFirstLetter (str4));
}

public static void main (String [] args) {
    String str = "my name is khan";
    String words [] = str.split ("\\s");
    String capitalizedWord = "";
    for (String w : words) {
        String first = w.substring (0, 1);
        String f_after = w.substring (1);
        capitalizedWord += first.toUpperCase () + f_after + " ";
    }
    System.out.println (capitalizedWord);
}

}
