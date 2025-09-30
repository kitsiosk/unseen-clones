public class Clone366 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:5022824
*  Stack Overflow answer #:5022857
*  And Stack Overflow answer#:5022875
*/
public static void main (String [] args) {
    List < List < Integer > > twoDim = new ArrayList < List < Integer > > ();
    String [] inputLines = {"0 1 0 1 0", "0 1 1 0 1", "0 0 0 1 0"};
    for (String line : inputLines) {
        List < Integer > row = new ArrayList < Integer > ();
        Scanner s = new Scanner (line);
        while (s.hasNextInt ()) row.add (s.nextInt ());
        twoDim.add (row);
    }
}

public static void main (String...args) {
    List < List < Integer > > array = new ArrayList < List < Integer > > ();
    Scanner input = new Scanner (System.in);
    out.println ("Enter n:");
    int n = input.nextInt ();
    out.println ("Enter m:");
    int m = input.nextInt ();
    out.println ("Enter the values:");
    for (int i = 0;
    i < n; i ++) {
        List < Integer > list = new ArrayList < Integer > ();
        array.add (list);
        for (int j = 0;
        j < m; j ++) {
            list.add (input.nextInt ());
        }
    }
    out.println ("Result:");
    out.println (array);
}

}
