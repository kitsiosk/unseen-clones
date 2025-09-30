public class Clone565 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3482711
*  Stack Overflow answer #:3482767
*  And Stack Overflow answer#:3482765
*/
@Override
public boolean equals (Object obj) {
    if (obj == null) {
        return false;
    }
    if (obj == this) {
        return true;
    }
    if (obj.getClass () != this.getClass ()) {
        return false;
    }
    MyClass other = (MyClass) obj;
    return new EqualsBuilder ().appendSuper (super.equals (obj)).append (field1, other.field1).append (field2, other.field2).append (field3, other.field3).isEquals ();
}

public boolean equals (Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass () != obj.getClass ()) return false;
    Connection other = (Connection) obj;
    if (dstAddr == null) {
        if (other.dstAddr != null) return false;
    } else if (! dstAddr.equals (other.dstAddr)) return false;
    if (dstPort != other.dstPort) return false;
    if (protocol == null) {
        if (other.protocol != null) return false;
    } else if (! protocol.equals (other.protocol)) return false;
    if (srcAddr == null) {
        if (other.srcAddr != null) return false;
    } else if (! srcAddr.equals (other.srcAddr)) return false;
    if (srcPort != other.srcPort) return false;
    return true;
}

}
