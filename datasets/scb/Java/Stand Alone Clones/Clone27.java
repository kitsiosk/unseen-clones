public class Clone27 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:33711003
*  Stack Overflow answer #:33711178
*  And Stack Overflow answer#:33711361
*/
static String transpose (String s) {
    char [] c = s.toCharArray ();
    int n = (int) Math.sqrt (s.length ());
    for (int i = 0;
    i < n; ++ i) {
        for (int j = i + 1;
        j < n; ++ j) {
            char h = c [i * n + j];
            c [i * n + j] = c [j * n + i];
            c [j * n + i] = h;
        }
    }
    return new String (c);
}

static String transpose (String s, int rows, int columns) {
    int n = s.length ();
    if (rows * columns != n) throw new IllegalArgumentException ();
    StringBuilder sb = new StringBuilder ();
    for (int i = 0;
    i < n - 1; i ++) sb.append (s.charAt (i * columns % (n - 1)));
    sb.append (s.charAt (n - 1));
    return sb.toString ();
}

}
