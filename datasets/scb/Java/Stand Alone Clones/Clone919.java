public class Clone919 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:9205572
*  Stack Overflow answer #:9205683
*  And Stack Overflow answer#:9205743
*/
public String getNextMonth (boolean maxDate) {
    Calendar calendar = Calendar.getInstance ();
    if (maxDate) {
        calendar.set (year, monthNo, 1);
    } else {
        calendar.set (year, monthNo, day);
    }
    if (monthNo == 11) {
        calendar.add (calendar.MONTH, 1);
    } else {
        calendar.add (calendar.MONTH, 1);
    }
    int maxD = calendar.getActualMaximum (calendar.DAY_OF_MONTH);
    calendar.set (year, monthNo, maxD);
}

public String getNextMonth (boolean maxDate) {
    Calendar calendar = Calendar.getInstance ();
    calendar.set (year, monthNo, 1);
    calendar.add (Calendar.MONTH, 1);
    if (maxDate) {
        int maxD = calendar.getActualMaximum (Calendar.DAY_OF_MONTH);
        calendar.set (Calendar.DAY_OF_MONTH, maxD);
    } else {
        calendar.set (Calendar.DAY_OF_MONTH, day);
    }
    String date = (calendar.get (Calendar.YEAR)) + "-" + (calendar.get (Calendar.MONTH) + 1) + "-" + calendar.get (Calendar.DAY_OF_MONTH);
    calendar.clear ();
    return date;
}

}
