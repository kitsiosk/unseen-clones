public class Clone933 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:17609756
*  Stack Overflow answer #:17610552
*  And Stack Overflow answer#:17611315
*/
public remove (Element element) {
    for (Element e : myLinkedList) {
        if (e.equals (element)) {
            if (next != 0) previousPtr = nextPtr;
            else previousPtr = null;
        }
    }
}

public void remove (E element) {
    Node n = head;
    Node tmp;
    while (n != null && ! n.data.equals (element)) {
        tmp = n;
        n = n.previous;
    }
    if (n == null) {
        System.out.println ("Element " + element + " not found.");
    } else {
        tmp.prev = n.prev;
        n.prev = null;
        System.out.println ("Element " + element + " removed.");
    }
}

}
