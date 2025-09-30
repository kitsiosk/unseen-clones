public class Clone869 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:221525
*  Stack Overflow answer #:20644976
*  And Stack Overflow answer#:224256
*/
public V remove (Object key) {
    readWriteLock.writeLock ().lock ();
    V value;
    try {
        value = super.remove (key);
    } finally {
        readWriteLock.writeLock ().unlock ();
    }
    return value;
}

public K remove () {
    if (head == null) return null;
    K val = head.value;
    if (head.next == null) {
        head = null;
        tail = null;
    } else {
        head = head.next;
        head.prev = null;
    }
    return val;
}

}
