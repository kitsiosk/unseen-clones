public class Clone383 {
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

private void sort (int [] input, int startIndx, int endIndx) {
    int endIndexOrig = endIndx;
    int startIndexOrig = startIndx;
    if (startIndx >= endIndx) return;
    int pavitVal = input [endIndx];
    while (startIndx <= endIndx) {
        while (input [startIndx] < pavitVal) startIndx ++;
        while (input [endIndx] > pavitVal) endIndx --;
        if (startIndx <= endIndx) {
            int tmp = input [startIndx];
            input [startIndx] = input [endIndx];
            input [endIndx] = tmp;
            startIndx ++;
            endIndx --;
        }
    }
    sort (input, startIndexOrig, endIndx);
    sort (input, startIndx, endIndexOrig);
}

}
