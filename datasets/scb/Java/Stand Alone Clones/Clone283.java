public class Clone283 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3757596
*  Stack Overflow answer #:3758281
*  And Stack Overflow answer#:3757745
*/
public static void main (String [] args) {
    String input = "(A,Name1,200), (A,Name1,200), (R,Name1,200), (A,Name2,900), (A,Name2,500)";
    Pattern p = Pattern.compile ("\\(([A,R]?),(\\w+?),(\\d+?)\\)");
    Matcher m = p.matcher (input);
    ArrayList < Score > scores = new ArrayList < Score > ();
    ArrayList < Score > topScores = new ArrayList < Score > ();
    while (m.find ()) {
        String action = m.group (1);
        String name = m.group (2);
        double scoreVal = Double.valueOf (m.group (3));
        Score score = new Score (name, scoreVal);
        scores.add (score);
        if ("A".equalsIgnoreCase (action)) {
            topScores.add (score);
        } else {
            for (Score topScore : topScores) {
                if (topScore.equals (score)) {
                    topScores.remove (score);
                }
            }
        }
    }
    for (Score finalScore : topScores) {
        System.out.println (finalScore);
    }
}

public static void main (String [] args) {
    String input = "(A,Name1,200), (A,Name1,200), (R,Name1,200), (A,Name2,900), (A,Name2,500)";
    String [] scoreSets = input.split ("\\),");
    List < Score > scoreList = new ArrayList < Score > ();
    for (String score : scoreSets) {
        score = score.trim ().substring (1);
        int closeBrace = score.indexOf (')');
        if (closeBrace == score.length () - 1) {
            score = score.substring (0, score.length () - 1);
        }
        String [] tokens = score.split (",");
        scoreList.add (new Score (tokens [0], tokens [1], Double.valueOf (tokens [2])));
    }
}

}
