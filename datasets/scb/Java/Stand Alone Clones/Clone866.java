public class Clone866 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:221525
*  Stack Overflow answer #:20644976
*  And Stack Overflow answer#:224256
*/
public V put (K key, V value) {
    readWriteLock.writeLock ().lock ();
    V old;
    try {
        old = super.put (key, value);
    } finally {
        readWriteLock.writeLock ().unlock ();
    }
    return old;
}

public void put (K key, V val) {
    while (currentSize >= maxSize) {
        freeSpace ();
    }
    if (map.containsKey (key)) {
        get (key);
        return;
    }
    ListNode < K > ln = queue.add (key);
    ValueHolder < K, V > rv = new ValueHolder < K, V > (val, ln);
    map.put (key, rv);
    currentSize ++;
}

}
