public class Clone123 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:10042
*  Stack Overflow answer #:6674458
*  And Stack Overflow answer#:25311
*/
public static void main (String [] args) {
    for (int i = 0;
    i < 5; i ++) {
        Link.insert (i + 5);
    }
    Link.printList ();
    Link.deletefromFirst ();
    Link.printList ();
}

public static void main (String [] args) {
    LinkList list = new LinkList ();
    list.insert (1, 1.01);
    list.insert (2, 2.02);
    list.insert (3, 3.03);
    list.insert (4, 4.04);
    list.insert (5, 5.05);
    list.printList ();
    while (! list.isEmpty ()) {
        Link deletedLink = list.delete ();
        System.out.print ("deleted: ");
        deletedLink.printLink ();
        System.out.println ("");
    }
    list.printList ();
}

}
