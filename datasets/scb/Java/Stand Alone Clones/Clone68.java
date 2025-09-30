public class Clone68 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3104504
*  Stack Overflow answer #:3104715
*  And Stack Overflow answer#:3104931
*/
public static void main (String [] args) {
    Node node1 = new Node ();
    node1.length = 1;
    Node node2 = new Node ();
    node2.length = 2;
    Node node3 = new Node ();
    node3.length = 3;
    Node node4 = new Node ();
    node4.children.add (node1);
    node4.children.add (node2);
    Node node5 = new Node ();
    node5.children.add (node3);
    Node node6 = new Node ();
    node6.children.add (node4);
    node6.children.add (node5);
    Object array = createArray (String.class, node6);
    outputArray (array);
    System.out.println ();
}

public static void main (String [] args) {
    Random r = new Random ();
    int dims = 1 + r.nextInt (3);
    int [] sizes = new int [dims];
    for (int i = 0;
    i < sizes.length; i ++) sizes [i] = 1 + r.nextInt (3);
    System.out.println ("Creating array with dimensions / sizes: " + Arrays.toString (sizes).replaceAll (", ", "]["));
    Object multiDimArray = Array.newInstance (String.class, sizes);
    fillWithSomeValues (multiDimArray, "pos ", sizes);
    System.out.println (Arrays.deepToString ((Object []) multiDimArray));
}

}
