public class Clone929 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:9194497
*  Stack Overflow answer #:9194671
*  And Stack Overflow answer#:10156770
*/
public int compare (int x, int y) {
    if (x & 1 == y & 1) {
        if (x & 1 == 0) {
            return Integer.compare (x, y);
        } else {
            return Integer.compare (y, x);
        }
    }
    if (x & 1 == 0) {
        return - 1;
    }
    return 1;
}

@Override
public int compare (Integer o1, Integer o2) {
    if (o1 % 2 == 0) {
        if (o2 % 2 == 0) {
            if (o1 < o2) return - 1;
            else return 1;
        } else {
            return - 1;
        }
    } else {
        if (o2 % 2 != 0) {
            if (o1 < o2) return 1;
            else return - 1;
        } else {
            return 1;
        }
    }
}

}
