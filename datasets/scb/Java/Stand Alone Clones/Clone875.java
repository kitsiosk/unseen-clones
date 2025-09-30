public class Clone875 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:28275607
*  Stack Overflow answer #:28275978
*  And Stack Overflow answer#:28276281
*/
public void duplication () {
    int max = 100;
    int min = 1;
    boolean duplicate = false;
    Random rand = new Random ();
    int [] all = new int [20];
    for (int x = 0;
    x < 20; x ++) {
        duplicate = false;
        int randomNum = rand.nextInt ((max - min) + 1) + min;
        for (int i : all) {
            if (i == randomNum) {
                duplicate = true;
                break;
            }
        }
        if (duplicate) {
            x --;
        } else {
            all [x] = randomNum;
        }
    }
}

public static void duplication () {
    int max = 100;
    int min = 1;
    Random rand = new Random ();
    int index = 0;
    int [] all = new int [20];
    while (index < 20) {
        boolean duplicate = false;
        int randomNum = rand.nextInt ((max - min) + 1) + min;
        for (int i = 0;
        i < all.length; i ++) {
            if (all [i] == randomNum) {
                duplicate = true;
                break;
            }
        }
        if (! duplicate) {
            all [index ++] = randomNum;
        }
    }
}

}
