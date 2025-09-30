public class Clone626 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:17967114
*  Stack Overflow answer #:17967261
*  And Stack Overflow answer#:19802629
*/
public static void main (String [] args) throws Exception {
    final int [] original = new int [] {1, 1, 2, 8, 9, 8, 4, 7, 4, 9, 1};
    System.out.println (Arrays.toString (original));
    quicksort (original);
    System.out.println (Arrays.toString (original));
    final int [] unqiue = new int [original.length];
    int prev = original [0];
    unqiue [0] = prev;
    int count = 1;
    for (int i = 1;
    i < original.length; ++ i) {
        if (original [i] != prev) {
            unqiue [count ++] = original [i];
        }
        prev = original [i];
    }
    System.out.println (Arrays.toString (unqiue));
    final int [] compressed = new int [count];
    System.arraycopy (unqiue, 0, compressed, 0, count);
    System.out.println (Arrays.toString (compressed));
}

public static void main (String args []) throws Exception {
    BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
    System.out.println ("enter size of the array");
    int l = Integer.parseInt (br.readLine ());
    int [] a = new int [l];
    for (int i = 0;
    i < l; i ++) {
        System.out.println ("enter a element");
        int el = Integer.parseInt (br.readLine ());
        a [i] = el;
    }
    for (int i = 0;
    i < l; i ++) {
        for (int j = 0;
        j < l - 1; j ++) {
            if (a [j] > a [j + 1]) {
                int temp = a [j];
                a [j] = a [j + 1];
                a [j + 1] = temp;
            }
        }
    }
    int b = 0;
    a [b] = a [0];
    for (int i = 1;
    i < l; i ++) {
        if (a [b] != a [i]) {
            b ++;
            a [b] = a [i];
        }
    }
    for (int i = 0;
    i <= b; i ++) {
        System.out.println (a [i]);
    }
}

}
