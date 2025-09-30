public class Clone510 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:23292197
*  Stack Overflow answer #:23292304
*  And Stack Overflow answer#:23292532
*/
public void shuffle () {
    int [] temp = new int [TOTALCARDS];
    for (int i = 0;
    i < temp.length; i ++) {
        temp [i] = i;
    }
    for (int i = 0;
    i < temp.length; i ++) {
        deck.push (protoDeck [temp [i]]);
    }
}

public void shuffle (int numberOfCards) {
    for (int i = 0;
    i < numberOfCards; i ++) {
        int j = rand.nextInt (protoDeck.length - i) + i;
        Card tmp = deck [i];
        deck [i] = deck [j];
        deck [j] = tmp;
    }
}

}
