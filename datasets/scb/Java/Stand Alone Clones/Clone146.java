public class Clone146 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:17305257
*  Stack Overflow answer #:17305727
*  And Stack Overflow answer#:17305383
*/
void permute (char [] alphabet, int k) {
    int permutationNumber = (int) Math.pow (alphabet.length, k);
    for (int i = 0;
    i < permutationNumber; i ++) {
        for (int j = 0;
        j < k; j ++) {
            System.out.print (alphabet [(i + (j * i / alphabet.length)) % alphabet.length]);
        }
        System.out.println ();
    }
}

static void permute (int level, String prefix) {
    if (level == 0) {
        System.out.println (prefix);
        return;
    }
    for (int i = 0;
    i < s.length (); i ++) permute (level - 1, prefix + s.charAt (i));
}

}
