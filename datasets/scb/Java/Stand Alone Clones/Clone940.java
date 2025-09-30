public class Clone940 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:20575925
*  Stack Overflow answer #:20575978
*  And Stack Overflow answer#:20576100
*/
public String getString () {
    String result = "";
    while (true) {
        String message = inputGenerator.getMessage ();
        result += message;
        if (! message.startsWith ("hi")) {
            break;
        }
    }
    return result;
}

public String getString () {
    StringBuilder msg = new StringBuilder ();
    String read;
    do {
        read = inputGenerator.getMessage ();
        msg.append (read);
    } while (read.toLowerCase ().startsWith ("hi"));
    return msg.toString ();
}

}
