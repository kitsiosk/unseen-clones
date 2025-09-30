public class Clone382 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:370258
*  Stack Overflow answer #:31291537
*  And Stack Overflow answer#:31291537
*/
public void sort (int [] input, Speed speed) {
    SortStrategy strategy = null;
    switch (speed) {
        case SLOW :
            strategy = new SlowBubbleSortStrategy ();
            break;
        case MEDIUM :
            strategy = new MediumInsertationSortStrategy ();
            break;
        case FAST :
            strategy = new FastQuickSortStrategy ();
            break;
        default :
            strategy = new MediumInsertationSortStrategy ();
    }
    strategy.sort (input);
}

public void sort (int [] input) {
    for (int i = 0;
    i < input.length - 1; i ++) {
        int k = i + 1;
        int nxtVal = input [k];
        while (input [k - 1] > nxtVal) {
            input [k] = input [k - 1];
            k --;
            if (k == 0) break;
        }
        input [k] = nxtVal;
    }
    System.out.println ("Medium sorting is done and the result is :");
    for (int i : input) {
        System.out.print (i + ",");
    }
}

}
