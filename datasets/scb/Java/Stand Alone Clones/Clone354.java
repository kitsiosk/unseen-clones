public class Clone354 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:30838179
*  Stack Overflow answer #:30838328
*  And Stack Overflow answer#:30838405
*/
public static void main (String [] args) {
    double [] [] data = {{97, 36, 79}, {94, 74, 60}, {68, 76, 58}, {64, 87, 56}, {68, 27, 73}, {74, 99, 42}, {7, 93, 87}, {51, 69, 40}, {38, 23, 33}, {57, 86, 31}};
    double [] xArr = new double [data.length];
    double [] yArr = new double [data.length];
    double [] bubbleSizeArr = new double [data.length];
    for (int i = 0;
    i < data.length; i ++) {
        xArr [i] = data [i] [0];
        yArr [i] = data [i] [1];
        bubbleSizeArr [i] = data [i] [2];
    }
    for (int i = 0;
    i < data.length; i ++) {
        System.out.printf ("%5.2f %5.2f %5.2f%n", xArr [i], yArr [i], bubbleSizeArr [i]);
    }
}

public static void main (String [] args) {
    double [] [] data = {{97, 36, 79}, {94, 74, 60}, {68, 76, 58}, {64, 87, 56}, {68, 27, 73}, {74, 99, 42}, {7, 93, 87}, {51, 69, 40}, {38, 23, 33}, {57, 86, 31}};
    double data1 [] = new double [data.length];
    double data2 [] = new double [data.length];
    double data3 [] = new double [data.length];
    for (int x = 0;
    x < data.length; x ++) {
        for (int y = 0;
        y < data [x].length; y ++) {
            if (y == 0) data1 [x] = data [x] [y];
            else if (y == 1) data2 [x] = data [x] [y];
            else if (y == 2) data3 [x] = data [x] [y];
        }
    }
    for (int i = 0;
    i < data1.length; i ++) {
        System.out.print (data1 [i] + " ");
        System.out.print (data2 [i] + " ");
        System.out.print (data3 [i] + " ");
        System.out.println ();
    }
}

}
