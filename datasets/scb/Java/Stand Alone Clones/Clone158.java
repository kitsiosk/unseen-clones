public class Clone158 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:37137350
*  Stack Overflow answer #:37137717
*  And Stack Overflow answer#:37138082
*/
public void insertNodeAfter (E nVal, E curVal) {
    Node < E > newNode = new Node < E > (nVal);
    Node < E > curr = head;
    while (curr != null) {
        if (curr.getNodeValue ().equals (curVal)) {
            newNode.setNext (curr.getNext ());
            curr.setNext (newNode);
            break;
        } else {
            curr = curr.getNext ();
        }
    }
}

public void insertNodeAfter (E nVal, E curVal) {
    Node < E > prev = findPrevOf (curVal);
    Node < E > curr = null;
    if (prev == null) {
        curr = head;
    } else {
        curr = prev.getNext ();
    }
    Node < E > newNode = new Node < E > (nVal);
    insert (curr, (curr == null ? curr : curr.getNext ()), newNode);
}

}
