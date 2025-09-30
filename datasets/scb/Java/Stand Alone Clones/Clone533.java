public class Clone533 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:25156195
*  Stack Overflow answer #:25157616
*  And Stack Overflow answer#:25158110
*/
@Override
public boolean equals (Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass () != obj.getClass ()) return false;
    @SuppressWarnings ("unchecked")
    final CircularList < T > other = (CircularList < T >) obj;
    if (other.length != this.length) {
        return false;
    }
    Element < T > current = this.first;
    Element < T > otherCurrent = other.first;
    int offset = 0;
    boolean found = false;
    do {
        found = checkSequence (current, otherCurrent);
        if (! found) {
            offset ++;
            otherCurrent = otherCurrent.next;
        }
    } while (! found && offset < length);
    return found;
}

public boolean equals (Object object) {
    if (this == object) {
        return true;
    }
    if (object == null) {
        return false;
    }
    if (! (object instanceof CircularList < ? >)) {
        return false;
    }
    CircularList < ? > that = (CircularList < ? >) object;
    Element < ? > first0 = first;
    Element < ? > current0 = first0;
    Element < ? > first1 = that.first;
    Element < ? > current1 = first1;
    while (true) {
        if (equalSequence (current0, current0, current1, current1)) {
            return true;
        }
        current1 = current1.next;
        if (current1 == first1) {
            return false;
        }
    }
}

}
