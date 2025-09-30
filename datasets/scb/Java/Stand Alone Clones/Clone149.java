public class Clone149 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19988770
*  Stack Overflow answer #:19990067
*  And Stack Overflow answer#:19989830
*/
public static void main (String [] args) {
    Random rand = new Random ();
    List < Item > items = new ArrayList < > ();
    int a = 1, b = 1, c = 1, d = 1, e = 1;
    for (int i = 0;
    i < 100; i ++) {
        int randomNumber = rand.nextInt (5) + 1;
        CATEGORY_TYPE categoryType = null;
        int num = 0;
        switch (randomNumber) {
            case 1 :
                categoryType = CATEGORY_TYPE.A;
                num = a ++;
                break;
            case 2 :
                categoryType = CATEGORY_TYPE.B;
                num = b ++;
                break;
            case 3 :
                categoryType = CATEGORY_TYPE.C;
                num = c ++;
                break;
            case 4 :
                categoryType = CATEGORY_TYPE.D;
                num = d ++;
                break;
            case 5 :
                categoryType = CATEGORY_TYPE.E;
                num = e ++;
                break;
        }
        String dummyData = "Item " + categoryType.toString () + num;
        Item item = new Item (dummyData, categoryType);
        items.add (item);
    }
    List < Item > categoryAItemsList = new ArrayList < > ();
    List < Item > categoryBItemsList = new ArrayList < > ();
    List < Item > categoryCItemsList = new ArrayList < > ();
    List < Item > categoryDItemsList = new ArrayList < > ();
    List < Item > categoryEItemsList = new ArrayList < > ();
    for (Item item : items) {
        if (item.getCategoryType () == CATEGORY_TYPE.A) categoryAItemsList.add (item);
        else if (item.getCategoryType () == CATEGORY_TYPE.B) categoryBItemsList.add (item);
        else if (item.getCategoryType () == CATEGORY_TYPE.C) categoryCItemsList.add (item);
        else if (item.getCategoryType () == CATEGORY_TYPE.D) categoryDItemsList.add (item);
        else if (item.getCategoryType () == CATEGORY_TYPE.E) categoryEItemsList.add (item);
    }
    List < Item [] > subsetStoringListA = new ArrayList < > ();
    List < Item [] > subsetStoringListB = new ArrayList < > ();
    List < Item [] > subsetStoringListC = new ArrayList < > ();
    List < Item [] > subsetStoringListD = new ArrayList < > ();
    List < Item [] > subsetStoringListE = new ArrayList < > ();
    processSubsets (categoryAItemsList.toArray (new Item [0]), 2, subsetStoringListA);
    processSubsets (categoryBItemsList.toArray (new Item [0]), 2, subsetStoringListB);
    processSubsets (categoryCItemsList.toArray (new Item [0]), 2, subsetStoringListC);
    processSubsets (categoryDItemsList.toArray (new Item [0]), 2, subsetStoringListD);
    processSubsets (categoryEItemsList.toArray (new Item [0]), 1, subsetStoringListE);
    System.out.println (" A groups number: " + subsetStoringListA.size ());
    System.out.println (" B groups number: " + subsetStoringListB.size ());
    System.out.println (" C groups number: " + subsetStoringListC.size ());
    System.out.println (" D groups number: " + subsetStoringListD.size ());
    System.out.println (" E groups number: " + subsetStoringListE.size ());
}

public static void main (String [] args) {
    int [] constraints = {2, 1, 0, 1};
    List < boolean [] > items = new ArrayList < boolean [] > ();
    boolean [] i1 = {true, false, true, false};
    boolean [] i2 = {true, false, false, false};
    boolean [] i3 = {false, true, false, true};
    boolean [] i4 = {false, false, false, true};
    items.add (i1);
    items.add (i2);
    items.add (i3);
    items.add (i4);
    backtrack (constraints, items);
}

}
