public class Clone845 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:23838985
*  Stack Overflow answer #:23838995
*  And Stack Overflow answer#:23838998
*/
public int tortoiseMoves () {
    int i = tGen ();
    if (i >= 1 && i <= 5) {
        int fastplod = 3;
        return fastplod;
    } else if (i >= 6 && i <= 8) {
        int slowplod = 1;
        return slowplod;
    } else if (i >= 9 && i <= 10) {
        int slip = - 6;
        return slip;
    } else {
        return 0;
    }
}

public int tortoiseMoves () {
    switch (tGen ()) {
        case 1 :
        case 2 :
        case 3 :
        case 4 :
        case 5 :
            return 3;
        case 6 :
        case 7 :
        case 8 :
            return 1;
        case 9 :
        case 10 :
            return - 6;
        default :
            return 0;
    }
}

}
