public class Clone322 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:53248559
*  Stack Overflow answer #:53248905
*  And Stack Overflow answer#:53248668
*/
public static int getHours () {
    while (true) {
        if (console.hasNextInt ()) {
            System.out.print ("**hours input accepted**");
            return console.nextInt ();
        }
        console.nextLine ();
        System.out.print (", please re-enter the hours again:");
    }
}

public static int getHours () {
    int hours = 0;
    boolean hoursNotOk = true;
    do {
        try {
            System.out.println ("Here");
            hours = console.nextInt ();
            hoursNotOk = false;
        } catch (Exception e) {
            e.printStackTrace ();
            console.nextLine ();
        } finally {
            if (hoursNotOk) {
                System.out.println (", please re-enter the hours again:");
            } else {
                System.out.println ("**hours input accepted**");
            }
        }
    } while (hoursNotOk);
    return hours;
}

}
