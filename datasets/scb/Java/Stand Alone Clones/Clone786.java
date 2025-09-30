public class Clone786 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:21383181
*  Stack Overflow answer #:21383241
*  And Stack Overflow answer#:21383230
*/
public void makeGrid (int size) {
    this.lines = size;
    grid = new Cell [size] [size];
    for (int i = 0;
    i < size; i ++) for (int j = 0;
    j < size; j ++) {
        grid [i] [j] = new Cell ();
    }
}

public void makeGrid (int size) {
    this.lines = size;
    grid = new Cell [size] [size];
    for (int i = 0;
    i < size; i ++) {
        for (int j = 0;
        j < size; j ++) {
            grid [i] [j] = new Cell ();
        }
    }
}

}
