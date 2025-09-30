public class Clone408 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:31174840
*  Stack Overflow answer #:31175366
*  And Stack Overflow answer#:31175187
*/
static void rotate (int [] array, int k) {
    int size = array.length;
    if (size <= 1) return;
    k = k % size;
    if (k == 0) return;
    for (int i = 0, start = 0, from = 0, to = - 1, move = array [0];
    i < size; ++ i, from = to) {
        to = (from + k) % size;
        int temp = array [to];
        array [to] = move;
        move = to == start ? array [to = ++ start] : temp;
    }
}

public int [] rotate (int [] nums, int k) {
    if (k > nums.length) k = k % nums.length;
    int [] result = new int [nums.length];
    System.arraycopy (nums, k + 1, result, 0, k);
    System.arraycopy (nums, 0, result, k + 1, nums.length - 1);
    nums = result;
    return result;
}

}
