public class Clone790 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:4243831
*  Stack Overflow answer #:12501101
*  And Stack Overflow answer#:4243925
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

int findCombinationsCount (int amount, int coins [], int checkFromIndex) {
    if (amount == 0) return 1;
    else if (amount < 0 || coins.length == checkFromIndex) return 0;
    else {
        int withFirstCoin = findCombinationsCount (amount - coins [checkFromIndex], coins, checkFromIndex);
        int withoutFirstCoin = findCombinationsCount (amount, coins, checkFromIndex + 1);
        return withFirstCoin + withoutFirstCoin;
    }
}

}
