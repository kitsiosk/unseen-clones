public class Clone775 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:17581738
*  Stack Overflow answer #:17581880
*  And Stack Overflow answer#:17581846
*/
public static boolean check (double x, double y, double x1, double y1, double x2, double y2) {
    double dx1 = x - x1, dx2 = x2 - x1, dy1 = y - y1, dy2 = y2 - y1;
    double dotp = dx1 * dx2 + dy1 * dy2;
    double theta = Math.acos (dotp / (Math.sqrt (dx1 * dx1 + dy1 * dy1) * Math.sqrt (dx2 * dx2 + dy2 * dy2)));
    theta = Math.abs (theta);
    if (theta > (Math.PI / 2)) return false;
    dx1 = x - x2;
    dx2 = x1 - x2;
    dy1 = y - y2;
    dy2 = y1 - y2;
    dotp = dx1 * dx2 + dy1 * dy2;
    theta = Math.acos (dotp / (Math.sqrt (dx1 * dx1 + dy1 * dy1) * Math.sqrt (dx2 * dx2 + dy2 * dy2)));
    theta = Math.abs (theta);
    if (theta > (Math.PI / 2)) return false;
    return true;
}

public static boolean check (double x1, double y1, double x2, double y2, double x, double y) {
    if (x1 == x2) {
        return y1 < y2 ? (y1 <= y && y <= y2) : (y2 <= y && y <= y1);
    }
    double m = (y2 - y1) / (x2 - x1);
    double r1 = x1 + m * y1;
    double r2 = x2 + m * y2;
    double r = x + m * y;
    return r1 < r2 ? (r1 <= r && r <= r2) : (r2 <= r && r <= r1);
}

}
