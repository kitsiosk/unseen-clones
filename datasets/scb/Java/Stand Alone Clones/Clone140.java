public class Clone140 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:10243482
*  Stack Overflow answer #:10245203
*  And Stack Overflow answer#:10245186
*/
public static void main (String [] args) {
    int n = 6;
    int radius = 100;
    Point centre = new Point (200, 200);
    double angle = Math.toRadians (360 / n);
    List < Point > points = new ArrayList < Point > ();
    points.add (centre);
    for (int i = 0;
    i < n; i ++) {
        double theta = i * angle;
        int dx = (int) (radius * Math.sin (theta));
        int dy = (int) (- radius * Math.cos (theta));
        Point p = new Point (centre.x + dx, centre.y + dy);
        points.add (p);
    }
    draw (points);
}

public static void main (String [] args) {
    EventQueue.invokeLater (new Runnable () {
        @Override
        public void run () {
            createAndShowGUI ();
        }}
    );
}

}
