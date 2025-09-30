public class Clone405 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:31934208
*  Stack Overflow answer #:31934883
*  And Stack Overflow answer#:31934529
*/
public static void main (String [] args) {
    List < String > list1 = new LinkedList < > (Arrays.asList ("Cat", "Mouse", "Dog"));
    List < String > list2 = new LinkedList < > (Arrays.asList ("Dog", "Mouse", "Cat"));
    List < String > list3 = new LinkedList < > (Arrays.asList ("Dog", "Horse", "Cat"));
    List < String > list4 = new LinkedList < > (Arrays.asList ("Dog", "Tiger", "Lion"));
    List < List < String > > list = new LinkedList < > (Arrays.asList (list1, list2, list3, list4));
    boolean flag = false;
    boolean matchFlag = true;
    for (int i = 0;
    i < list.size (); i ++) {
        for (int j = i + 1;
        j < list.size (); j ++) {
            if (list.get (i).size () == list.get (j).size ()) {
                matchFlag = true;
                for (String str : list.get (i)) {
                    flag = false;
                    for (String string : list.get (j)) {
                        if (str.equals (string)) {
                            flag = true;
                        }
                    }
                    if (flag == false) {
                        matchFlag = false;
                        break;
                    }
                }
                if (matchFlag) {
                    list.remove (j);
                    j --;
                }
            }
        }
    }
    System.out.println (list.size ());
    for (int i = 0;
    i < list.size (); i ++) {
        System.out.println (list.get (i));
    }
}

public static void main (String [] args) {
    List < Animal > list1 = new LinkedList < > (Arrays.asList (Cat, Mouse, Dog));
    List < Animal > list2 = new LinkedList < > (Arrays.asList (Dog, Mouse, Cat));
    List < Animal > list3 = new LinkedList < > (Arrays.asList (Dog, Horse, Cat));
    List < Animal > list4 = new LinkedList < > (Arrays.asList (Dog, Tiger, Lion));
    List < List < Animal > > list = new LinkedList < > (Arrays.asList (list1, list2, list3, list4));
    Set < List < Animal > > sorted = new LinkedHashSet < > ();
    for (List < Animal > animals : list) {
        List < Animal > arList = new ArrayList < > (animals);
        Collections.sort (arList);
        sorted.add (new LinkedList < > (arList));
    }
    for (List < Animal > animals : sorted) {
        System.out.println (animals);
    }
}

}
