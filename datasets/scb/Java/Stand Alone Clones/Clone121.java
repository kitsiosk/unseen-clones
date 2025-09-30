public class Clone121 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:4066729
*  Stack Overflow answer #:21952775
*  And Stack Overflow answer#:34431323
*/
public static void main (String [] args) {
    LinkedList < String > list = new LinkedList < > ();
    while (! StdIn.isEmpty ()) {
        String input = StdIn.readString ();
        if (input.equals ("print")) {
            StdOut.println (list.toString ());
            continue;
        }
        if (input.charAt (0) == ('+')) {
            list.add (input.substring (1));
            continue;
        }
        if (input.charAt (0) == ('-')) {
            list.remove (input.substring (1));
            continue;
        }
        break;
    }
}

public static void main (String [] args) {
    Node root = null;
    DataInputStream reader = new DataInputStream (System.in);
    int op = 0;
    while (op != 6) {
        try {
            System.out.println ("Enter Option:\n1:Insert Front 2:Delete Front 3:Insert Rear 4:Delete Rear 5:Display List 6:Exit");
            op = Integer.parseInt (reader.readLine ());
            switch (op) {
                case 1 :
                    System.out.println ("Enter Value: ");
                    int val = Integer.parseInt (reader.readLine ());
                    root = insertNodeFront (val, root);
                    display (root);
                    break;
                case 2 :
                    root = removeNodeFront (root);
                    display (root);
                    break;
                case 3 :
                    System.out.println ("Enter Value: ");
                    val = Integer.parseInt (reader.readLine ());
                    root = insertNodeRear (val, root);
                    display (root);
                    break;
                case 4 :
                    root = removeNodeRear (root);
                    display (root);
                    break;
                case 5 :
                    display (root);
                    break;
                default :
                    System.out.println ("Invalid Option");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
    System.out.println ("Exited!!!");
    try {
        reader.close ();
    } catch (IOException e) {
        e.printStackTrace ();
    }
}

}
