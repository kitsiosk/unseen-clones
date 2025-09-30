public class Clone730 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:714108
*  Stack Overflow answer #:10946027
*  And Stack Overflow answer#:10083452
*/
public static void main (String [] args) {
    String [] list1 = {"a", "b", "c",};
    TimeUnit [] list2 = TimeUnit.values ();
    int [] list3 = new int [] {1, 2, 3, 4};
    int [] lengths = new int [] {list1.length, list2.length, list3.length};
    for (int [] indices : new CartesianProduct (lengths)) {
        System.out.println (Arrays.toString (indices) + " " + list1 [indices [0]] + ", " + list2 [indices [1]] + ", " + list3 [indices [2]]);
    }
}

public static void main (String [] args) {
    List < Object > lc = Arrays.asList (new Object [] {'A', 'B', 'C', 'D'});
    List < Object > lC = Arrays.asList (new Object [] {'a', 'b', 'c'});
    List < Object > li = Arrays.asList (new Object [] {1, 2, 3, 4});
    List < List < Object > > llo = new ArrayList < List < Object > > ();
    llo.add (lc);
    llo.add (lC);
    llo.add (li);
    CartesianIterable < Object > ci = new CartesianIterable < Object > (llo);
    for (List < Object > lo : ci) show (lo);
}

}
