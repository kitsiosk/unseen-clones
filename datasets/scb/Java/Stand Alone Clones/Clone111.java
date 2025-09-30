public class Clone111 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:354875
*  Stack Overflow answer #:24122015
*  And Stack Overflow answer#:354906
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

Node reverse (Node n, Node p) {
    if (n == null) return null;
    if (n.next == null) {
        n.next = p;
        return n;
    }
    Node r = reverse (n.next, n);
    n.next = p;
    return r;
}

}
