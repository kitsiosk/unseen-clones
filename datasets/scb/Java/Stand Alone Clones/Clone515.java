public class Clone515 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:15376228
*  Stack Overflow answer #:15376620
*  And Stack Overflow answer#:15376442
*/
public void add (Distance d) {
    int newFeet = this.feet + d.feet;
    int newInches = this.inches + d.inches;
    if (newInches > 11) {
        newFeet ++;
        newInches = newInches - 12;
    }
    this.feet = newFeet;
    this.inches = newInches;
}

public int add (Distance newDistance) {
    int newDistanceFeet = newDistance.getFeet ();
    int newDistanceInches = newDistance.getInches ();
    int sumInches = newDistanceInches + this.getInches ();
    int sumFeet = newDistanceFeet + this.getFeet ();
    sumInches += (sumInches % 12);
    sumFeet += (sumInches / 12);
    this.setFeet (sumFeet);
    this.setInches (sumInches);
}

}
