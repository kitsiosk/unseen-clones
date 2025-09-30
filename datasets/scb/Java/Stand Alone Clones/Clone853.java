public class Clone853 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:46459493
*  Stack Overflow answer #:46459676
*  And Stack Overflow answer#:46459686
*/
public static int [] createArray (int size) {
    int [] array = new int [size];
    int half = (size / 2) + (size % 2);
    int index = half;
    int value = 0;
    for (int i = 0;
    i < size; i ++) {
        if (i == index) {
            half = (half / 2) + (half % 2);
            index += half;
            value ++;
        }
        array [i] = value;
    }
    return array;
}

static int [] createArray (int size) {
    int [] result = new int [size];
    int limit = (size + 1) / 2;
    int start = 0, value = 0, idx = 0;
    do {
        for (int i = start;
        i < start + limit && idx < size; ++ i) result [idx ++] = value;
        start += limit;
        limit = (limit + 1) / 2;
        ++ value;
    } while (idx < size);
    return result;
}

}
