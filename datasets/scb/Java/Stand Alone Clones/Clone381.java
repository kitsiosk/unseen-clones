public class Clone381 {
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
    i < input.length; i ++) {
        for (int j = i + 1;
        j < input.length; j ++) {
            if (input [i] > input [j]) {
                int tmp = input [i];
                input [i] = input [j];
                input [j] = tmp;
            }
        }
    }
    System.out.println ("Slow sorting is done and the result is :");
    for (int i : input) {
        System.out.print (i + ",");
    }
}

}
