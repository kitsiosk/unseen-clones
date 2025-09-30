public class Clone163 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:20059529
*  Stack Overflow answer #:20073469
*  And Stack Overflow answer#:20060733
*/
boolean unsignedMultiplyOverflows (final long a, final long b) {
    if ((a == 0L) || (b == 0L)) {
        return false;
    }
    if ((a == 1L) || (b == 1L)) {
        return false;
    }
    if ((a < 0L) || (b < 0L)) {
        return true;
    }
    final boolean unsignedMultiplyOverflows = (a > ((Long.MAX_VALUE / b) * 2L) + ((((Long.MAX_VALUE % b) * 2L) + 1L) / b));
    return unsignedMultiplyOverflows;
}

static boolean unsignedMultiplyOverflows (final long a, final long b) {
    if (a == 0 || b == 0) {
        return false;
    }
    final long aHalf = a>>> 1;
    final long bHalf = b>>> 1;
    final byte aLastBit = (byte) (a & 1);
    final byte bLastBit = (byte) (b & 1);
    if (aLastBit == 0) {
        return Long.MAX_VALUE / b < aHalf;
    } else if (bLastBit == 0) {
        return Long.MAX_VALUE / a < bHalf;
    } else {
        return (Long.MAX_VALUE - bHalf) / b < aHalf;
    }
}

}
