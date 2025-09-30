public class Clone757 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3522454
*  Stack Overflow answer #:31449858
*  And Stack Overflow answer#:46213426
*/
public static void main (String [] args) throws Exception {
    NestedMap < String, Integer > test = new NestedMap < > ();
    test.put ("a").put ("b").put ("c", 12);
    Map.Entry < String, Integer > foo = test.put ("a").put ("b").put ("d", 12);
    test.put ("b", 14);
    ObjectMapper mapper = new ObjectMapper ();
    System.out.println (mapper.writeValueAsString (test));
    foo.setValue (99);
    System.out.println (mapper.writeValueAsString (test));
    System.out.println (test.get ("a").get ("b").getValue ("d"));
}

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

}
