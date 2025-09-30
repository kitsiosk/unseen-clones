public class Clone854 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:37960674
*  Stack Overflow answer #:37974694
*  And Stack Overflow answer#:37991204
*/
public static void main (String [] args) {
    WSObject wsObject = new WSObject (new Foo (new Bar (new Baz (241))));
    WSObject wsObjectNull = new WSObject (new Foo (null));
    GetterResult < Integer > intResult = getterChain (wsObject, WSObject :: getFoo, Foo :: getBar, Bar :: getBar, Baz :: getInt);
    GetterResult < Integer > intResult2 = getterChain (wsObjectNull, WSObject :: getFoo, Foo :: getBar, Bar :: getBar, Baz :: getInt);
    System.out.println (intResult.result);
    System.out.println (intResult.lastIndex);
    System.out.println ();
    System.out.println (intResult2.result);
    System.out.println (intResult2.lastIndex);
}

public static void main (String [] args) {
    Address address = new Address ();
    address.setSomeCrap (null);
    Person person = new Person ();
    person.setAddress (address);
    long startTime = System.currentTimeMillis ();
    for (int i = 0;
    i < 1000000; i ++) {
        try {
            System.out.println (person.getAddress ().getSomeCrap ().getCrap ());
        } catch (NullPointerException npe) {
        }
    }
    long endTime = System.currentTimeMillis ();
    System.out.println ((endTime - startTime) / 1000F);
    long startTime1 = System.currentTimeMillis ();
    for (int i = 0;
    i < 1000000; i ++) {
        if (person != null) {
            Address address1 = person.getAddress ();
            if (address1 != null) {
                SomeCrap someCrap2 = address1.getSomeCrap ();
                if (someCrap2 != null) {
                    System.out.println (someCrap2.getCrap ());
                }
            }
        }
    }
    long endTime1 = System.currentTimeMillis ();
    System.out.println ((endTime1 - startTime1) / 1000F);
}

}
