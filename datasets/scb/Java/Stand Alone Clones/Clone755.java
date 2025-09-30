public class Clone755 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:35927307
*  Stack Overflow answer #:35927873
*  And Stack Overflow answer#:35934873
*/
public static void main (String [] args) {
    int nth = Integer.parseInt (args [0]);
    Queue < String > q = new LinkedList < > ();
    BufferedReader bufferRead = new BufferedReader (new InputStreamReader (System.in));
    try {
        String s = "";
        while (! "/".equals ((s = bufferRead.readLine ()))) {
            q.add (s);
        }
    } catch (IOException e) {
        e.printStackTrace ();
    }
    String polled = "";
    int count = 1;
    while ((polled = q.poll ()) != null) {
        if (count == nth) {
            System.out.println (nth + " th string is " + polled);
        }
        count ++;
    }
}

public static void main (String [] args) {
    Integer n = Integer.parseInt (args [0]);
    Queue < Integer > q = new Queue < Integer > ();
    while (! StdIn.isEmpty ()) {
        q.enqueue (StdIn.readInt ());
    }
    while (q.size () > n) {
        q.dequeue ();
    }
    StdOut.println (q.peek ().toString ());
}

}
