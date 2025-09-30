public class Clone620 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:16808777
*  Stack Overflow answer #:38856375
*  And Stack Overflow answer#:16809138
*/
public static void main (String...args) {
    final int MAX_VAL = 10000;
    int [] currentIndex = {0, 0, 0, 0};
    int [] remaining = {50, 50, 50, 50};
    int [] [] sequence = new int [4] [50];
    while (keepWorking (remaining)) {
        int currentMethod = chooseMethod (remaining);
        switch (currentMethod) {
            case 0 :
                sequence [currentMethod] [currentIndex [currentMethod]] = getLL (MAX_VAL);
                break;
            case 1 :
                sequence [currentMethod] [currentIndex [currentMethod]] = getAL (MAX_VAL);
                break;
            case 2 :
                sequence [currentMethod] [currentIndex [currentMethod]] = getLLIt (MAX_VAL);
                break;
            default :
                sequence [currentMethod] [currentIndex [currentMethod]] = getALIt (MAX_VAL);
                break;
        }
        remaining [currentMethod] --;
        currentIndex [currentMethod] ++;
    }
    for (int [] ar : sequence) {
        Arrays.sort (ar);
    }
    System.out.println ("Time (us\nLL    \tAL\tLL incr\t AL incr");
    for (int i = 0;
    i < sequence [0].length; i ++) {
        System.out.println (sequence [0] [i] + "\t" + sequence [1] [i] + "\t" + sequence [2] [i] + "\t" + sequence [3] [i]);
    }
    System.out.println ("\nTime normalized to fastest run of a method\nLL\tAL\tLL incr\t AL incr");
    for (int i = 0;
    i < sequence [0].length; i ++) {
        System.out.print (i);
        for (int j = 0;
        j < sequence.length; j ++) {
            int a = sequence [j] [i] / (sequence [j] [0] / 100);
            System.out.print ("\t" + a);
        }
        System.out.println ();
    }
}

public static void main (String...args) {
    final int MAX_VAL = 10000;
    List < Integer > linkedList = new LinkedList < Integer > ();
    List < Integer > arrayList = new ArrayList < Integer > ();
    for (int i = 0;
    i < MAX_VAL; i ++) {
        linkedList.add (i);
        arrayList.add (i);
    }
    long time = System.nanoTime ();
    for (int i = 0;
    i < MAX_VAL; i ++) {
        linkedList.add (MAX_VAL / 2, i);
    }
    System.out.println ("LL time:\t" + (System.nanoTime () - time));
    time = System.nanoTime ();
    for (int i = 0;
    i < MAX_VAL; i ++) {
        arrayList.add (MAX_VAL / 2, i);
    }
    System.out.println ("AL time:\t" + (System.nanoTime () - time));
    linkedList = new LinkedList < Integer > ();
    arrayList = new ArrayList < Integer > ();
    for (int i = 0;
    i < MAX_VAL; i ++) {
        linkedList.add (i);
        arrayList.add (i);
    }
    time = System.nanoTime ();
    ListIterator < Integer > li = linkedList.listIterator (MAX_VAL / 2);
    for (int i = 0;
    i < MAX_VAL; i ++) {
        li.add (i);
    }
    System.out.println ("LL iterator:\t" + (System.nanoTime () - time));
    time = System.nanoTime ();
    ListIterator < Integer > ali = arrayList.listIterator (MAX_VAL / 2);
    for (int i = 0;
    i < MAX_VAL; i ++) {
        ali.add (i);
    }
    System.out.println ("AL iterator:\t" + (System.nanoTime () - time));
}

}
