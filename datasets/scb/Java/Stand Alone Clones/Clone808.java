public class Clone808 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7383624
*  Stack Overflow answer #:7383983
*  And Stack Overflow answer#:7383983
*/
public String toString () {
    StringBuilder sb = new StringBuilder ();
    sb.append ("(");
    sb.append (a + ",");
    sb.append (b + ",");
    sb.append (v + ",");
    sb.append (w + ",");
    sb.append (m + ",");
    sb.append (n);
    sb.append (")");
    return sb.toString ();
}

public String toString () {
    StringBuilder sb = new StringBuilder ();
    sb.append (a + "\n");
    sb.append (b + "\n");
    for (A elem : aList) {
        sb.append (elem + "\n");
    }
    return sb.toString ();
}

}
