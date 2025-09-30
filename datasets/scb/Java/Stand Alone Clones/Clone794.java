public class Clone794 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:9591561
*  Stack Overflow answer #:9594404
*  And Stack Overflow answer#:9591777
*/
public String [] [] allUniqueCombinations () {
    List < String > labels = new ArrayList < String > ();
    List < List < String > > lists = new ArrayList < List < String > > ();
    for (Map.Entry < String, Vector < String > > entry : dataStructure.entrySet ()) {
        labels.add (entry.getKey ());
        lists.add (entry.getValue ());
    }
    List < List < String > > combinations = product (lists);
    int m = combinations.size () + 1;
    int n = labels.size ();
    String [] [] answer = new String [m] [n];
    for (int i = 0;
    i < n; i ++) answer [0] [i] = labels.get (i);
    for (int i = 1;
    i < m; i ++) for (int j = 0;
    j < n; j ++) answer [i] [j] = combinations.get (i - 1).get (j);
    return answer;
}

public String [] [] allUniqueCombinations () {
    int n = dataStructure.keySet ().size ();
    int solutions = 1;
    for (Vector < String > vector : dataStructure.values ()) {
        solutions *= vector.size ();
    }
    String [] [] allCombinations = new String [solutions + 1] [];
    allCombinations [0] = dataStructure.keySet ().toArray (new String [n]);
    for (int i = 0;
    i < solutions; i ++) {
        Vector < String > combination = new Vector < String > (n);
        int j = 1;
        for (Vector < String > vec : dataStructure.values ()) {
            combination.add (vec.get ((i / j) % vec.size ()));
            j *= vec.size ();
        }
        allCombinations [i + 1] = combination.toArray (new String [n]);
    }
    return allCombinations;
}

}
