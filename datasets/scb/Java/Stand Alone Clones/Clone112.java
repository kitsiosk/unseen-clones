public class Clone112 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:354875
*  Stack Overflow answer #:24122015
*  And Stack Overflow answer#:3079734
*/
public static Node reverse (Node root) {
    if (root == null || root.next == null) {
        return root;
    }
    Node curr, prev, next;
    curr = root;
    prev = next = null;
    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}

public Node reverse (Node previous, Node current) {
    if (previous == null) return null;
    if (previous.equals (head)) previous.setNext (null);
    if (current == null) {
        head = previous;
        return head;
    } else {
        Node temp = current.getNext ();
        current.setNext (previous);
        reverse (current, temp);
    }
    return null;
}

}
