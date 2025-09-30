public class Clone33 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:4965335
*  Stack Overflow answer #:19484210
*  And Stack Overflow answer#:19484210
*/
public void printTree (OutputStreamWriter out) throws IOException {
    if (right != null) {
        right.printTree (out, true, "");
    }
    printNodeValue (out);
    if (left != null) {
        left.printTree (out, false, "");
    }
}

private void printTree (OutputStreamWriter out, boolean isRight, String indent) throws IOException {
    if (right != null) {
        right.printTree (out, true, indent + (isRight ? "        " : " |      "));
    }
    out.write (indent);
    if (isRight) {
        out.write (" /");
    } else {
        out.write (" \\");
    }
    out.write ("----- ");
    printNodeValue (out);
    if (left != null) {
        left.printTree (out, false, indent + (isRight ? " |      " : "        "));
    }
}

}
