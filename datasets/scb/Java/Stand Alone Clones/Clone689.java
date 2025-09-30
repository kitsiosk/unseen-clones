public class Clone689 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8847165
*  Stack Overflow answer #:8847333
*  And Stack Overflow answer#:8847333
*/
public int [] randNums (int total, int minVal, int numRands) {
    if (minVal * numRands > total) {
        throw new IllegalArgumentException ();
    }
    int [] results = randNums (total - minVal * numRands, numRands);
    for (int i = 0;
    i < numRands; ++ i) {
        results [i] += minVal;
    }
    return results;
}

private int [] randNums (int total, int n) {
    final int [] results = new int [n];
    if (total == 0) {
        Arrays.fill (results, 0);
        return results;
    }
    final BigInteger [] rs = new BigInteger [n];
    final BigInteger totalPlus1 = BigInteger.valueOf (total + 1L);
    while (true) {
        for (int i = 0;
        i < n; ++ i) {
            rs [i] = new BigInteger (256, rand);
        }
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger r : rs) {
            sum = sum.add (r);
        }
        if (sum.compareTo (BigInteger.ZERO) == 0) {
            continue;
        }
        for (int i = 0;
        i < n; ++ i) {
            results [i] = sum.mod (rs [i]).mod (totalPlus1).intValue ();
        }
        return results;
    }
}

}
