public class Clone781 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2545103
*  Stack Overflow answer #:1334391
*  And Stack Overflow answer#:15946901
*/
public static void main (String [] args) {
    boolean t = true;
    first : {
        second : {
            third : {
                System.out.println ("Before the break");
                if (t) {
                    break second;
                }
                System.out.println ("Not executed");
            } System.out.println ("Not executed - end of second block");
        } System.out.println ("End of third block");
    }}

public static void main (String [] args) {
    int temp = 0;
    out : for (int i = 0;
    i < 3; ++ i) {
        System.out.println ("I am here");
        for (int j = 0;
        j < 20; ++ j) {
            if (temp == 0) {
                System.out.println ("j: " + j);
                if (j == 1) {
                    temp = j;
                    continue out;
                }
            }
        }
    }
    System.out.println ("temp = " + temp);
}

}
