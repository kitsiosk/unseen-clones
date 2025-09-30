public class Clone46 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2663115
*  Stack Overflow answer #:2663123
*  And Stack Overflow answer#:15123668
*/
boolean hasLoop (Node first) {
    if (first == null) return false;
    Node turtle = first;
    Node hare = first;
    while (hare.next != null && hare.next.next != null) {
        turtle = turtle.next;
        hare = hare.next.next;
        if (turtle == hare) return true;
    }
    return false;
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
