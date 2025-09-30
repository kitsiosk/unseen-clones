public class Clone278 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:41529026
*  Stack Overflow answer #:42172107
*  And Stack Overflow answer#:41529368
*/
public Key secondMaxKey () {
    if (this.size () <= 1) return null;
    if (this.size () == 2) {
        if (first.key.compareTo (first.next.key) > 0) {
            return first.next.key;
        }
    }
    Key max = first.key;
    Key secondMax = first.next.key;
    Node n = first;
    for (Node x = n.next;
    x != null; x = x.next) {
        if (x.key.compareTo (max) >= 0) {
            secondMax = max;
            max = x.key;
        } else if (x.key.compareTo (secondMax) > 0) secondMax = x.key;
    }
    return secondMax;
}

public Key secondMaxKey () {
    if (size () < 2) {
        return null;
    }
    Node max = null;
    Node max_2 = null;
    Node second = first.next;
    if (first.key.compareTo (second.key) > 0) {
        max = first;
        max_2 = second;
    } else {
        max = second;
        max_2 = first;
    }
    for (Node x = second.next;
    x != null; x = x.next) {
        if (x.key.compareTo (max.key) > 0) {
            max_2 = max;
            max = x;
        } else if ((x.key.compareTo (max_2.key) > 0) && (x.key.compareTo (max.key) < 0)) {
            max_2 = x;
        }
    }
    return max_2.key;
}

}
