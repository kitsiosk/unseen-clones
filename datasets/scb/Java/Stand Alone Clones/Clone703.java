public class Clone703 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:49407474
*  Stack Overflow answer #:49407992
*  And Stack Overflow answer#:49407821
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
    int defaultLength = 10;
    int maxCountryLength = stream (countries).mapToInt (String :: length).max ().orElse (defaultLength);
    int maxPopulationLength = stream (populations).mapToObj (Integer :: toString).mapToInt (String :: length).max ().orElse (defaultLength);
    for (int i = 0;
    i < countries.length; i ++) {
        System.out.format ("%-" + maxCountryLength + "s | %" + maxPopulationLength + "d\n", countries [i], populations [i]);
    }
}

}
