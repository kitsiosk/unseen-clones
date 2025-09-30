public class Clone759 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3522454
*  Stack Overflow answer #:46213426
*  And Stack Overflow answer#:18503585
*/
public static final void main (String...args) {
    Node tree = new Node ();
    tree.value = "root";
    Node [] n = {new Node (), new Node ()};
    tree.nodes = n;
    tree.nodes [0].value = "leftish";
    tree.nodes [1].value = "rightish-leafy";
    Node [] nn = {new Node ()};
    tree.nodes [0].nodes = nn;
    tree.nodes [0].nodes [0].value = "off-leftish-leaf";
    System.out.println (Arrays.toString (list (tree, args [0]).toArray ()));
}

public static void main (String [] args) {
    BinaryTreeWithoutRecursion < Integer > ls = new BinaryTreeWithoutRecursion < > ();
    ls.insert (1);
    ls.insert (2);
    ls.insert (3);
    ls.insert (4);
    ls.insert (5);
    ls.insert (6);
    ls.insert (7);
    ls.inOrderPrint ();
}

}
