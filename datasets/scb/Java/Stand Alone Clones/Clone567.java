public class Clone567 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:27105677
*  Stack Overflow answer #:27108222
*  And Stack Overflow answer#:47916986
*/
public static void main (String [] args) {
    int size = 10;
    double skew = 2.0;
    ZipfGenerator z0 = new ZipfGenerator (size, skew);
    FastZipfGenerator z1 = new FastZipfGenerator (size, skew);
    long before = 0;
    long after = 0;
    int n = 5000000;
    before = System.nanoTime ();
    Map < Integer, Integer > counts0 = computeCounts (z0, size, n);
    after = System.nanoTime ();
    System.out.println (counts0 + ", duration " + (after - before) / 1e6);
    before = System.nanoTime ();
    Map < Integer, Integer > counts1 = computeCounts (z1, size, n);
    after = System.nanoTime ();
    System.out.println (counts1 + ", duration " + (after - before) / 1e6);
}

public static void main (String [] args) {
    if (args.length != 2) {
        System.out.println ("usage: ./zipf size skew");
        System.exit (- 1);
    }
    ZipfGenerator zipf = new ZipfGenerator (Integer.valueOf (args [0]), Double.valueOf (args [1]));
    for (int i = 1;
    i <= 10; i ++) {
        System.out.println (i + " " + zipf.getProbability (i));
    }
    int hist [] = new int [12];
    for (int i = 0;
    i < 12; i ++) {
        hist [i] = 0;
    }
    System.out.println ("Testing the probability distribution:");
    int sum = 0;
    for (int i = 1;
    i <= 1000000; i ++) {
        hist [zipf.next ()] ++;
    }
    for (int i = 0;
    i < 12; i ++) System.out.println (i + " " + hist [i] / 1000000.0);
}

}
