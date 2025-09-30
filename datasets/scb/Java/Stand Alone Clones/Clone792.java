public class Clone792 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:4243831
*  Stack Overflow answer #:12861239
*  And Stack Overflow answer#:34304829
*/
public static void main (String [] args) {
    int [] coins = {1, 3, 5, 10, 20, 50, 100, 200, 500};
    int amount = new Random ().nextInt (10000);
    int coinsCount = 0;
    System.out.println ("amount = " + amount);
    int [] numberOfCoins = findNumberOfCoins (coins, amount);
    for (int i = 0;
    i < numberOfCoins.length; i ++) {
        if (numberOfCoins [i] > 0) {
            System.out.println ("coins= " + coins [i] + " Count=" + numberOfCoins [i] + "\n");
            coinsCount += numberOfCoins [i];
        }
    }
    System.out.println ("numberOfCoins = " + coinsCount);
}

public static void main (String [] args) {
    int [] coins = new int [] {1, 2, 3, 4, 5};
    int money = 600;
    int [] [] recorder = new int [money + 1] [coins.length];
    for (int k = 0;
    k < coins.length; k ++) {
        recorder [0] [k] = 1;
    }
    for (int i = 1;
    i <= money; i ++) {
        int with = 0;
        int without = 0;
        for (int coin_index = 0;
        coin_index < coins.length; coin_index ++) {
            if (i - coins [coin_index] < 0) {
                with = 0;
            } else {
                with = recorder [i - coins [coin_index]] [coin_index];
            }
            if (coin_index - 1 < 0) {
                without = 0;
            } else {
                without = recorder [i] [coin_index - 1];
            }
            recorder [i] [coin_index] = with + without;
        }
    }
    System.out.print (recorder [money] [coins.length - 1]);
}

}
