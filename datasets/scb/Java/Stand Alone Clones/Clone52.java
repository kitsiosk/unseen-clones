public class Clone52 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:28302267
*  Stack Overflow answer #:28306663
*  And Stack Overflow answer#:28303290
*/
@Test
public void testFooThrowsAtFirstAndSecondTime () {
    Throwable firstException = exceptionThrownBy (new Statement () {
        public void evaluate () throws Throwable {
            foo ();
        }}
    );
    assertEquals (Exception.class, firstException.getClass ());
    Throwable secondException = exceptionThrownBy (new Statement () {
        public void evaluate () throws Throwable {
            foo ();
        }}
    );
    assertEquals (Exception.class, secondException.getClass ());
    foo ()
}

@Test
public void testFooThrowsAtFirstAndSecondTime () throws Exception {
    try {
        foo ();
        fail ("foo did not throw an exception");
    } catch (Exception ex) {
    }
    try {
        foo ();
        fail ("foo did not throw an exception");
    } catch (Exception ex) {
    }
    foo ();
}

}
