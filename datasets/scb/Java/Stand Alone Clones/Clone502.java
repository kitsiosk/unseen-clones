public class Clone502 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:53921303
*  Stack Overflow answer #:53924329
*  And Stack Overflow answer#:53921805
*/
public static void main (String [] args) {
    List < Point > points = new ArrayList < Point > ();
    points.add (createPoint ("A", 1, 0));
    points.add (createPoint ("B", 1, 1));
    points.add (createPoint ("C", 1, 2));
    points.add (createPoint ("D", 2, 2));
    points.add (createPoint ("E", 3, 1));
    points.add (createPoint ("F", 4, 1));
    points.add (createPoint ("G", 5, 1));
    points.add (createPoint ("H", 5, 2));
    List < Integer > indices = computeTurningPointIndices (points);
    System.out.println ("Turning points are at " + indices);
    List < Point > turningPoints = indices.stream ().map (i -> points.get (i)).collect (Collectors.toList ());
    System.out.println ("They are " + turningPoints);
    System.out.println ("Collinear:");
    indices.add (0, 0);
    indices.add (points.size () - 1);
    for (int i = 0;
    i < indices.size () - 1; i ++) {
        int i0 = indices.get (i);
        int i1 = indices.get (i + 1);
        List < Point > collinear = points.subList (i0, i1 + 1);
        System.out.println ("    " + collinear);
    }
}

public static void main (String [] args) {
    ArrayList < Point > positions = new ArrayList < Point > ();
    positions.add (new Point (1, 0));
    positions.add (new Point (1, 1));
    positions.add (new Point (1, 2));
    positions.add (new Point (2, 2));
    positions.add (new Point (3, 1));
    positions.add (new Point (4, 1));
    positions.add (new Point (5, 1));
    positions.add (new Point (5, 2));
    ArrayList < Point > turns = new ArrayList < Point > ();
    for (int i = 0;
    i < positions.size (); i ++) {
        turns.add (null);
    }
    int counter = 0;
    if (positions.size () > 2) {
        Point base = positions.get (0);
        Point next = positions.get (1);
        int x = (next.x - base.x);
        double slope = 1.0 * (next.y - base.y) / (next.x - base.x);
        for (int i = 2;
        i < positions.size (); i ++) {
            Point newpoint = positions.get (i);
            double newslope = 1.0 * (newpoint.y - next.y) / (newpoint.x - next.x);
            if (newslope != slope) {
                counter ++;
                turns.set (i - 1, positions.get (i - 1));
                slope = newslope;
            }
            next = newpoint;
        }
    }
    System.out.println ("Collinear points:");
    for (int i = 0;
    i < positions.size (); i ++) {
        System.out.print ("(" + positions.get (i).x + ", " + positions.get (i).y + ") ");
        if (turns.get (i) != null) {
            System.out.println ();
            System.out.print ("(" + positions.get (i).x + ", " + positions.get (i).y + ") ");
        }
    }
    System.out.println ();
    System.out.println ();
    if (counter > 0) {
        System.out.println ("Turns at these points: ");
        for (Point p : turns) {
            if (p != null) System.out.print ("(" + p.x + ", " + p.y + ") ");
        }
    } else {
        System.out.println ("There are no turns!");
    }
}

}
