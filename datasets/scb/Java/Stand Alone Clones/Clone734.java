public class Clone734 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:113511
*  Stack Overflow answer #:31220250
*  And Stack Overflow answer#:113583
*/
@Override
public int hashCode () {
    int result = 17;
    result = 31 * result + (booleanField ? 1 : 0);
    result = 31 * result + byteField;
    result = 31 * result + charField;
    result = 31 * result + shortField;
    result = 31 * result + intField;
    result = 31 * result + (int) (longField ^ (longField>>> 32));
    result = 31 * result + Float.floatToIntBits (floatField);
    long doubleFieldBits = Double.doubleToLongBits (doubleField);
    result = 31 * result + (int) (doubleFieldBits ^ (doubleFieldBits>>> 32));
    result = 31 * result + Arrays.hashCode (arrayField);
    result = 31 * result + referenceField.hashCode ();
    result = 31 * result + (nullableReferenceField == null ? 0 : nullableReferenceField.hashCode ());
    return result;
}

public int hashCode () {
    int hashCode = 1;
    Iterator i = iterator ();
    while (i.hasNext ()) {
        Object obj = i.next ();
        hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode ());
    }
    return hashCode;
}

}
