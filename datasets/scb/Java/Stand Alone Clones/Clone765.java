public class Clone765 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:50666406
*  Stack Overflow answer #:50667420
*  And Stack Overflow answer#:50666975
*/
public static void main (String [] args) {
    Scanner in = new Scanner (System.in);
    int T = Integer.parseInt (in.nextLine ());
    int [] N = new int [T];
    int [] A = new int [T];
    int [] B = new int [T];
    double [] Probability = new double [T];
    for (int t = 0;
    t < T; t ++) {
        String [] input = in.nextLine ().split (" ");
        N [t] = Integer.parseInt (input [0]);
        A [t] = Integer.parseInt (input [1]);
        B [t] = Integer.parseInt (input [2]);
        int total, pa = 0, pb = 0;
        String [] faces = in.nextLine ().split (" ");
        total = faces.length;
        for (String f : faces) {
            if (Integer.parseInt (f) == A [t]) {
                pa ++;
            }
            if (Integer.parseInt (f) == B [t]) {
                pb ++;
            }
        }
        double pn = (double) (total * total);
        Probability [t] = (pa * pb) / pn;
    }
    for (double d : Probability) {
        System.out.println (d);
    }
}

public static void main (String [] args) {
    Scanner scanner = new Scanner (System.in);
    String line = scanner.nextLine ();
    int trys = Integer.parseInt (line.trim ());
    for (int i = 0;
    i < trys; i ++) {
        double probability = processTry (scanner);
        System.out.println (probability);
    }
    scanner.close ();
}

}
