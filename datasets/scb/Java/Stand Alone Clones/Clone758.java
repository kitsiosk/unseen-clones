public class Clone758 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3522454
*  Stack Overflow answer #:31449858
*  And Stack Overflow answer#:18503585
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
