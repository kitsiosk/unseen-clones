public class Clone868 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:221525
*  Stack Overflow answer #:20644976
*  And Stack Overflow answer#:15008085
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

public VV remove (String key) {
    synchronized (lock) {
        Item < VV > item = cache.remove (key);
        if (item != null) {
            return item.payload;
        } else {
            return null;
        }
    }
}

}
