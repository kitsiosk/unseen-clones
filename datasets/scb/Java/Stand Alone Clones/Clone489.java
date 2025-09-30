public class Clone489 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:36657752
*  Stack Overflow answer #:36657867
*  And Stack Overflow answer#:36657965
*/
int computeHeight (Node root) {
    int levels = 0;
    for (Node child : root.children) {
        int childHeight = computeHeight (child);
        if (childHeight > levels) {
            levels = childHeight;
        }
    }
    return levels + 1;
}

int computeHeight () {
    int maxHeight = 0;
    int [] heights = new int [parent.length];
    for (int vertex = 0;
    vertex < n; vertex ++) {
        if (heights [vertex] != 0) continue;
        int height = 0;
        for (int i = vertex;
        i != - 1; i = parent [i]) {
            if (heights [i] != 0) {
                height += heights [i];
                break;
            }
            height ++;
        }
        maxHeight = Math.max (maxHeight, height);
        for (int i = vertex;
        i != - 1; i = parent [i]) {
            if (heights [i] != 0) break;
            heights [i] = height --;
        }
    }
    return maxHeight;
}

}
