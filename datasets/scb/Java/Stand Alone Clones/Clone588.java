public class Clone588 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:12053241
*  Stack Overflow answer #:12053669
*  And Stack Overflow answer#:12110151
*/
public static void main (String [] args) {
    String sent1 = "Mary and Meera are my classmates.";
    String sent2 = "Meera and Mary are my classmates.";
    String sent3 = "Alice and Bobe are not my classmates.";
    String sent4 = "Some totally different sentence.";
    System.out.println ("Distance between \n'" + sent1 + "' \nand '" + sent2 + "': \n" + computeDistance (sent1, sent2));
    System.out.println ("Distance between \n'" + sent1 + "' \nand '" + sent3 + "': \n" + computeDistance (sent1, sent3));
    System.out.println ("Distance between \n'" + sent1 + "' \nand '" + sent4 + "': \n" + computeDistance (sent1, sent4));
}

public static void main (String [] args) {
    try {
        ArrayList < String > sentences = null;
        sentences = new ArrayList < String > ();
        sentences.add ("Mary and Meera are my classmates.");
        sentences.add ("Mary and Meera are my classmates.");
        sentences.add ("Meera and Mary are my classmates.");
        sentences.add ("Alice and Bobe are not my classmates.");
        sentences.add ("Some totally different sentence.");
        wordAnalyser (sentences);
    } catch (Exception e) {
        e.printStackTrace ();
    }
}

}
