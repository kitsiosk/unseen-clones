public class Clone62 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:16000196
*  Stack Overflow answer #:16000210
*  And Stack Overflow answer#:16002052
*/
public static void main (String [] args) {
    Integer [] arr = new Integer [1000];
    for (int i = 0;
    i < arr.length; i ++) {
        arr [i] = i;
    }
    Collections.shuffle (Arrays.asList (arr));
    System.out.println (Arrays.toString (arr));
}

public static void main (String [] args) {
    int [] nums = new int [N];
    for (int i = 0;
    i < nums.length; ++ i) {
        nums [i] = i;
    }
    Random randomGenerator = new Random ();
    int randomIndex;
    int randomValue;
    for (int i = 0;
    i < nums.length; ++ i) {
        randomIndex = randomGenerator.nextInt (nums.length);
        randomValue = nums [randomIndex];
        nums [randomIndex] = nums [i];
        nums [i] = randomValue;
    }
}

}
