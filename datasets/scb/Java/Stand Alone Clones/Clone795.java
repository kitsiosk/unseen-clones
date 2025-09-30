public class Clone795 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:35830072
*  Stack Overflow answer #:35832164
*  And Stack Overflow answer#:35830396
*/
public static double exp (double x, int n) {
    double sum = 1.0;
    double term = 1.0;
    for (int i = 1;
    i <= n; ++ i) {
        term *= x / i;
        sum += term;
    }
    return sum;
}

public static double exp (double x, int n) {
    return DoubleStream.iterate (1, new DoubleUnaryOperator () {
        private int i = 1;
        @Override
        public double applyAsDouble (double operand) {
            return operand * x / i ++;
        }}
    ).limit (n).sum ();
}

}
