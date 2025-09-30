public class Clone791 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:4243831
*  Stack Overflow answer #:4244025
*  And Stack Overflow answer#:4243925
*/
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
