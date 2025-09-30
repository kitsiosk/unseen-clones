public class Clone884 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:43620487
*  Stack Overflow answer #:44145914
*  And Stack Overflow answer#:44145738
*/
static void test_02 () throws FileNotFoundException {
    final File file = new File ("43620487.txt");
    final Scanner scanner = new Scanner (file);
    int [] houseLocations = new int [73382];
    for (int counter = 0;
    counter < 73382; counter ++) {
        houseLocations [counter] = scanner.nextInt ();
    }
    final int [] uniqueHouseLocationsSorted = uniqueHouseLocationsSorted (houseLocations);
    final Random random = new Random (0);
    long sum = 0;
    for (int i = 0;
    i < 100; i ++) {
        final int transmitterRange = random.nextInt (70000) + 1;
        final int minNumOfTransmitters = minNumOfTransmitters (uniqueHouseLocationsSorted, transmitterRange);
        sum += minNumOfTransmitters;
    }
    final long start = System.currentTimeMillis ();
    for (int i = 0;
    i < 4000; i ++) {
        final int transmitterRange = random.nextInt (70000) + 1;
        final int minNumOfTransmitters = minNumOfTransmitters (uniqueHouseLocationsSorted, transmitterRange);
        sum += minNumOfTransmitters;
    }
    final long end = System.currentTimeMillis ();
    System.out.println ("Took: " + (end - start) + " milliseconds. Sum = " + sum);
}

static void test_02 () throws FileNotFoundException {
    final File file = new File ("input.txt");
    final Scanner scanner = new Scanner (file);
    int [] houseLocations = new int [73382];
    for (int counter = 0;
    counter < 73382; counter ++) {
        houseLocations [counter] = scanner.nextInt ();
    }
    scanner.close ();
    final int rounds = 400;
    final int [] uniqueHouseLocationsSorted = uniqueHouseLocationsSorted (houseLocations);
    final int transmitterRange = 73381;
    final long start = System.currentTimeMillis ();
    for (int i = 0;
    i < rounds; i ++) {
        final int minNumOfTransmitters = minNumOfTransmitters (uniqueHouseLocationsSorted, transmitterRange);
    }
    final long end = System.currentTimeMillis ();
    System.out.println ("Took: " + (end - start) + " milliseconds..");
}

}
