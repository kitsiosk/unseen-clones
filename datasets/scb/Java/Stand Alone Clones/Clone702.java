public class Clone702 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:49407474
*  Stack Overflow answer #:49407992
*  And Stack Overflow answer#:49408321
*/
public static void printTable (String [] countries, int [] populations) {
    int countryLength = 0;
    long populationLength = 0;
    for (String country : countries) {
        if (country.length () > countryLength) countryLength = country.length ();
    }
    for (int i : populations) {
        if (String.valueOf (i).length () > populationLength) populationLength = String.valueOf (i).length ();
    }
    for (int i = 0;
    i < countries.length; i ++) System.out.format ("%-" + (countryLength + 1) + "s|%" + (populationLength + 1) + "d\n", countries [i], populations [i]);
}

public static void printTable (String [] countries, int [] populations) {
    if (countries.length != 0) {
        int longestNameInput = countries [0].length ();
        int longestPopInput = String.valueOf (populations [0]).length ();
        for (int i = 0;
        i < countries.length; i ++) {
            int countLength = countries [i].length ();
            int popLength = String.valueOf (populations [i]).length ();
            if (countLength > longestNameInput) longestNameInput = countLength;
            if (popLength > longestPopInput) longestPopInput = popLength;
        }
        for (int i = 0;
        i < countries.length; i ++) {
            System.out.print (countries [i]);
            for (int j = 0;
            j < (longestNameInput - countries [i].length ()); j ++) System.out.print (" ");
            System.out.print (" | ");
            for (int k = 0;
            k < (longestPopInput - String.valueOf (populations [i]).length ()); k ++) System.out.print (" ");
            System.out.println (populations [i]);
        }
    }
}

}
