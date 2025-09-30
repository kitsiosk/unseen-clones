public class Clone660 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:40093859
*  Stack Overflow answer #:40094313
*  And Stack Overflow answer#:40094624
*/
public static void main (String [] args) {
    String scaleOne;
    String scaleTwo;
    System.out.println ("What scale is your temp currently in?\n" + "1: Fahrenheit\n" + "2: Celsius\n" + "3: Kelvin\n" + "Please enter 1, 2, or 3: \n");
    scaleOne = getScale ();
    System.out.println ("What scale would you like to convert to?\n" + "1: Fahrenheit\n" + "2: Celsius\n" + "3: Kelvin\n" + "Please enter 1, 2, or 3:\n ");
    scaleTwo = getScale ();
    System.out.print ("Your final temp is: " + convert (scaleOne, scaleTwo));
}

public static void main (String [] args) {
    char cont = 'E';
    do {
        temp1 = getTemp ();
        scale1 = scaleOne ();
        scale2 = toScale ();
        System.out.print ("Your final temp is: " + convert () + ' ' + scale2);
    } while (cont == 'N');
}

}
