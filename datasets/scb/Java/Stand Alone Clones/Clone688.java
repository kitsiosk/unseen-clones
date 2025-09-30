public class Clone688 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8847165
*  Stack Overflow answer #:8847413
*  And Stack Overflow answer#:8848083
*/
public static int [] genRandoms (int n, int numberOfRandoms, int min) {
    int randomArray [] = new int [numberOfRandoms];
    for (int i = 0;
    i < numberOfRandoms; i ++) {
        randomArray [i] = min;
    }
    for (int i = min * numberOfRandoms;
    i < n; i ++) {
        randomArray [randomRange (numberOfRandoms)] += 1;
    }
    return randomArray;
}

public static int [] genRandoms (int total, int numberOfRandoms, int minimumValue) {
    int [] ret = new int [numberOfRandoms];
    Random rnd = new Random ();
    int totalLeft = total;
    for (int i = 0;
    i < numberOfRandoms; i ++) {
        final int rollsLeft = numberOfRandoms - i;
        int thisMax = totalLeft - (rollsLeft - 1) * minimumValue;
        int thisMin = Math.max (minimumValue, totalLeft / rollsLeft);
        int range = thisMax - thisMin;
        if (range < 0) throw new IllegalArgumentException ("Cannot have " + minimumValue + " * " + numberOfRandoms + " < " + total);
        int rndValue = range;
        for (int j = 0;
        j * j < rollsLeft; j ++) rndValue = rnd.nextInt (rndValue + 1);
        totalLeft -= ret [i] = rndValue + thisMin;
    }
    Collections.shuffle (Arrays.asList (ret), rnd);
    return ret;
}

}
