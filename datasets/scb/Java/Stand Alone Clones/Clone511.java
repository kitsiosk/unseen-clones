public class Clone511 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:43409886
*  Stack Overflow answer #:43410302
*  And Stack Overflow answer#:43410264
*/
private static boolean isBetween (int currentMonth, int currentDay, int monthFrom, int dayFrom, int monthUntil, int dayUntil) {
    int currentYear = 2000;
    LocalDate dateFrom = LocalDate.of (currentYear, monthFrom, dayFrom);
    LocalDate dateUntil = LocalDate.of (currentYear, monthUntil, dayUntil);
    if (dateFrom.isAfter (dateUntil)) {
        dateUntil = dateUntil.plusYears (1);
    }
    LocalDate currentDateThisYear = LocalDate.of (currentYear, currentMonth, currentDay);
    LocalDate currentDateNextYear = currentDateThisYear.plusYears (1);
    if (! (currentDateThisYear.isBefore (dateFrom) || currentDateThisYear.isAfter (dateUntil))) {
        return true;
    } else if (! (currentDateNextYear.isBefore (dateFrom) || currentDateNextYear.isAfter (dateUntil))) {
        return true;
    }
    return false;
}

public static boolean isBetween (int currentMonth, int currentDay, int fromMonth, int fromDay, int untilMonth, int untilDay) {
    MonthDay current = MonthDay.of (currentMonth, currentDay);
    MonthDay from = MonthDay.of (fromMonth, fromDay);
    MonthDay until = MonthDay.of (untilMonth, untilDay);
    if (from.compareTo (until) <= 0) {
        return from.compareTo (current) <= 0 && current.compareTo (until) <= 0;
    } else {
        return current.compareTo (until) <= 0 || current.compareTo (from) >= 0;
    }
}

}
