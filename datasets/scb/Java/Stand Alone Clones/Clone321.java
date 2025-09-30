public class Clone321 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:26617821
*  Stack Overflow answer #:26618116
*  And Stack Overflow answer#:26624249
*/
public V get (K1 key1, K2 key2) {
    if (! mapOfMap.containsKey (key1)) {
        key1 = null;
    }
    if (! mapOfMap.get (key1).containsKey (key2)) {
        key2 = null;
    }
    return mapOfMap.get (key1).get (key2);
}

public V get (K...keys) {
    if (keys == null) {
        return value;
    }
    if (expectedNumberOfKeys == - 1) {
        return null;
    }
    if (expectedNumberOfKeys == 0) {
        return value;
    }
    if (expectedNumberOfKeys != keys.length) {
        throw new IllegalArgumentException ("Expecting " + expectedNumberOfKeys + " keys.  Was " + keys.length);
    }
    Map < K, Map > currentMap = topMap;
    for (int i = 0;
    i < keys.length - 1; i ++) {
        currentMap = (Map) getDefault (currentMap, keys [i]);
    }
    V result = (V) getDefault (currentMap, keys [keys.length - 1]);
    return result;
}

}
