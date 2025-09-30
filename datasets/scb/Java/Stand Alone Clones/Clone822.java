public class Clone822 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:28834857
*  Stack Overflow answer #:28835026
*  And Stack Overflow answer#:28834950
*/
public void filter (String [] words, BufferedReader reader) throws IOException {
    String text;
    while ((text = reader.readLine ()) != null) {
        for (int i = 0;
        i < words.length; i ++) {
            if (text.toLowerCase ().contains (words [i].toLowerCase ())) {
                System.out.println (text);
                break;
            }
        }
    }
}

public void filter (String [] words, String text) {
    for (int i = 0;
    i < words.length; i ++) {
        if (text.toLowerCase ().contains (words [i].toLowerCase ())) {
            System.out.println (text);
            break;
        }
    }
}

}
