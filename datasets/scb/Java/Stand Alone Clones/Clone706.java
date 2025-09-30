public class Clone706 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8180430
*  Stack Overflow answer #:33962286
*  And Stack Overflow answer#:8180925
*/
@Override
public boolean equals (Object that) {
    if (this == that) return true;
    if (! (that instanceof People)) return false;
    People thatPeople = (People) that;
    return this.name.equals (thatPeople.name) && this.age == thatPeople.age;
}

public boolean equals (Object obj) {
    if (obj == null) {
        return false;
    }
    if (! Person.class.isAssignableFrom (obj.getClass ())) {
        return false;
    }
    final Person other = (Person) obj;
    if ((this.name == null) ? (other.name != null) : ! this.name.equals (other.name)) {
        return false;
    }
    if (this.age != other.age) {
        return false;
    }
    return true;
}

}
