public class Clone141 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:14545272
*  Stack Overflow answer #:42644508
*  And Stack Overflow answer#:42644508
*/
public int sum () {
    sum = 0;
    final IntPredicate positive = v -> v > 0;
    final Index positiveIndex = new Index (positive);
    final Index negativeIndex = new Index (positive.negate ());
    while (positiveIndex.index < array.length || negativeIndex.index < array.length) {
        sum += sum < 0 ? sum (positiveIndex, negativeIndex) : sum (negativeIndex, positiveIndex);
    }
    return sum;
}

private int sum (@NotNull
Index mainIndex,@NotNull
Index secondaryIndex) {
    int localSum = 0;
    while (mainIndex.index < array.length && secondaryIndex.sign.test (array [mainIndex.index])) {
        mainIndex.index ++;
    }
    if (mainIndex.index < array.length) {
        localSum += array [mainIndex.index ++];
    } else {
        for (; secondaryIndex.index < array.length; secondaryIndex.index ++) {
            if (secondaryIndex.sign.test (array [secondaryIndex.index])) {
                localSum += array [secondaryIndex.index];
            }
        }
    }
    return localSum;
}

}
