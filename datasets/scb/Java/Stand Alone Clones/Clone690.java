public class Clone690 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1534804
*  Stack Overflow answer #:32879795
*  And Stack Overflow answer#:10735181
*/
public static Date addBusinessDays (Date day, int days, int weekendPattern) {
    Calendar ret = Calendar.getInstance ();
    if (day != null) {
        ret.setTime (day);
    }
    if (days != 0) {
        int startDayofWeek = ret.get (Calendar.DAY_OF_WEEK) - 1;
        int idx = days > 0 ? 0 : 3;
        int howManyWeekendDays = 0;
        int [] [] adjV = adjVector [weekendPattern];
        int numWeekendDaysInOneWeek = adjV [idx + 1].length;
        for (int i = 0;
        i < numWeekendDaysInOneWeek; i ++) {
            int adjustmentA = adjV [idx] [startDayofWeek];
            int adjustmentB = adjV [idx + 1] [i];
            howManyWeekendDays += (days - adjustmentA - adjustmentB) / (7 - numWeekendDaysInOneWeek);
        }
        int adjustmentC = adjV [idx + 2] [startDayofWeek];
        howManyWeekendDays += adjustmentC;
        ret.add (Calendar.DATE, days + howManyWeekendDays);
    }
    return ret.getTime ();
}

public static Date addBusinessDays (Date date, int days) {
    DateTime result = new DateTime (date);
    result = isWeekEnd (result) ? getPreviousBusinessDate (result) : result;
    for (int i = 0;
    i < days; i ++) {
        if (isWeekEnd (result)) {
            i --;
        }
        result = result.plusDays (1);
    }
    return result.toDate ();
}

}
