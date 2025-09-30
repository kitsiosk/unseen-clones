public class Clone15 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:76223
*  Stack Overflow answer #:76389
*  And Stack Overflow answer#:10922864
*/
public int getLastFriday (int month, int year) {
    Calendar cal = Calendar.getInstance ();
    cal.set (year, month, 1, 0, 0, 0);
    cal.set (Calendar.MILLISECOND, 0);
    int friday = - 1;
    while (cal.get (Calendar.MONTH) == month) {
        if (cal.get (Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            friday = cal.get (Calendar.DAY_OF_MONTH);
            cal.add (Calendar.DAY_OF_MONTH, 7);
        } else {
            cal.add (Calendar.DAY_OF_MONTH, 1);
        }
    }
    return friday;
}

public static Calendar getLastFriday (Calendar cal, int offset) {
    int dayofweek;
    cal.set (Calendar.MONTH, cal.get (Calendar.MONTH) + offset);
    cal.set (Calendar.DAY_OF_MONTH, cal.getActualMaximum (Calendar.DAY_OF_MONTH));
    dayofweek = cal.get (Calendar.DAY_OF_WEEK);
    if (dayofweek < Calendar.FRIDAY) cal.set (Calendar.DAY_OF_MONTH, cal.get (Calendar.DAY_OF_MONTH) - 7 + Calendar.FRIDAY - dayofweek);
    else cal.set (Calendar.DAY_OF_MONTH, cal.get (Calendar.DAY_OF_MONTH) + Calendar.FRIDAY - dayofweek);
    return cal;
}

}
