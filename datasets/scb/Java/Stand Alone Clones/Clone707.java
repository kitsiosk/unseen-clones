public class Clone707 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8180430
*  Stack Overflow answer #:33962286
*  And Stack Overflow answer#:8180481
*/
@Override
public boolean equals (Object that) {
    if (this == that) return true;
    if (! (that instanceof People)) return false;
    People thatPeople = (People) that;
    return this.name.equals (thatPeople.name) && this.age == thatPeople.age;
}

public boolean equals (Object other) {
    boolean result;
    if ((other == null) || (getClass () != other.getClass ())) {
        result = false;
    } else {
        People otherPeople = (People) other;
        result = name.equals (otherPeople.name) && age == otherPeople.age;
    }
    return result;
}

}
