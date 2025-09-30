public class Clone110 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:354875
*  Stack Overflow answer #:24122015
*  And Stack Overflow answer#:356071
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

public ListNode reverse (ListNode toBeNextNode, ListNode currentNode) {
    ListNode currentHead = currentNode;
    if ((currentNode == null || currentNode.next == null) && toBeNextNode == null) return currentHead;
    if (currentNode.next != null) currentHead = reverse (currentNode, currentNode.next);
    currentNode.next = toBeNextNode;
    return currentHead;
}

}
