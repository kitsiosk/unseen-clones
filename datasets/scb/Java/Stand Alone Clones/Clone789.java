public class Clone789 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:4243831
*  Stack Overflow answer #:12501101
*  And Stack Overflow answer#:4244025
*/
public static int findCombinationsCount (int sum, int vals []) {
    if (sum < 0) {
        return 0;
    }
    if (vals == null || vals.length == 0) {
        return 0;
    }
    int dp [] = new int [sum + 1];
    dp [0] = 1;
    for (int i = 0;
    i < vals.length; ++ i) {
        for (int j = vals [i];
        j <= sum; ++ j) {
            dp [j] += dp [j - vals [i]];
        }
    }
    return dp [sum];
}

int findCombinationsCount (int amount, int coins []) {
    if (coins.length == 1) {
        return amount % coins [0] == 0 ? 1 : 0;
    } else {
        int total = 0;
        int [] subCoins = arrayOfCoinsExceptTheFirstOne (coins);
        for (int i = 0;
        i * coins [0] <= amount; ++ i) {
            total += findCombinationsCount (amount - i * coins [0], subCoins);
        }
        return total;
    }
}

}
