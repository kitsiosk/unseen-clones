public class Clone774 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7625665
*  Stack Overflow answer #:7625894
*  And Stack Overflow answer#:7626130
*/
public static void main (String...args) throws IOException {
    int [] nums = new int [10 * 1000 * 1000];
    {
        long start = System.nanoTime ();
        product2 (nums);
        long time = System.nanoTime () - start;
        System.out.printf ("Took %.3f seconds to take the product of %,d ints using an int[].%n", time / 1e9, nums.length);
    } {
        long start = System.nanoTime ();
        product (nums);
        long time = System.nanoTime () - start;
        System.out.printf ("Took %.3f seconds to take the product of %,d ints using reflections.%n", time / 1e9, nums.length);
    }}

public static void main (String arg []) {
    Integer [] v1 = {1, - 10, 3, 9, 7, 99, - 25};
    Integer [] v2 = {1, - 10, 3, 9, 7, 99, - 25};
    double p_int = ArrayMath.ScalarProduct (v1, v2);
    Double [] v1_d = {1.1, - 10.5, 3.7, 9.98, 7.4, 9.9, - 2.5};
    Double [] v2_d = {1.1, - 10.5, 3.7, 9.98, 7.4, 9.9, - 2.5};
    Double p_double = ArrayMath.ScalarProduct (v1_d, v2_d);
    System.out.println ("p_int：" + p_int);
    System.out.println ("p_double：" + p_double);
}

}
