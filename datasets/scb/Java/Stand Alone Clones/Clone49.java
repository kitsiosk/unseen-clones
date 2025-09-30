public class Clone49 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2663115
*  Stack Overflow answer #:3158029
*  And Stack Overflow answer#:15123668
*/
static boolean hasLoop (Node first) {
    if (first == null) return false;
    Node slow, fast;
    slow = fast = first;
    while (true) {
        slow = slow.next;
        if (fast.next == null) fast = null;
        else fast = fast.next.next;
        if (fast == null) return false;
        if (slow == fast) return true;
    }
}

public static boolean hasLoop (Node root) {
    if (root == null) return false;
    Node slow = root, fast = root;
    int taken = 0, limit = 2;
    while (fast.next != null) {
        fast = fast.next;
        taken ++;
        if (slow == fast) return true;
        if (taken == limit) {
            taken = 0;
            limit <<= 1;
            slow = fast;
        }
    }
    return false;
}

}
