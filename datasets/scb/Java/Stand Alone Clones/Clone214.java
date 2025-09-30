public class Clone214 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3252895
*  Stack Overflow answer #:3252975
*  And Stack Overflow answer#:3253922
*/
public static void main (String [] args) {
    ScriptEngineManager manager = new ScriptEngineManager ();
    ScriptEngine engine = manager.getEngineByName ("js");
    engine.put ("a", 1);
    engine.put ("b", 2);
    try {
        String expression = "(a + b) > 2";
        Object result = engine.eval (expression);
        System.out.println (expression + " ? " + result);
    } catch (ScriptException se) {
        se.printStackTrace ();
    }
}

public static void main (String [] args) {
    long a = 5;
    long b = 4;
    String theExpression = "a * b";
    JexlEngine jexl = new JexlEngine ();
    Expression e = jexl.createExpression (theExpression);
    JexlContext context = new MapContext ();
    context.set ("a", a);
    context.set ("b", b);
    Long result = (Long) e.evaluate (context);
    System.out.println ("The answer : " + result);
}

}
