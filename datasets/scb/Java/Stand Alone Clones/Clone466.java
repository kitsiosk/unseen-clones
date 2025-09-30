public class Clone466 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:10370508
*  Stack Overflow answer #:10370970
*  And Stack Overflow answer#:10370758
*/
public static void main (String [] args) {
    final int ThirtyOne = 31;
    final int Thirty = 30;
    final int FebNorm = 28;
    final int FebLeap = 29;
    int numOfSundays = 0;
    int calendar [] [] = new int [12] [];
    calendar [0] = new int [ThirtyOne];
    calendar [1] = new int [FebLeap];
    calendar [2] = new int [ThirtyOne];
    calendar [3] = new int [Thirty];
    calendar [4] = new int [ThirtyOne];
    calendar [5] = new int [Thirty];
    calendar [6] = new int [ThirtyOne];
    calendar [7] = new int [ThirtyOne];
    calendar [8] = new int [Thirty];
    calendar [9] = new int [ThirtyOne];
    calendar [10] = new int [Thirty];
    calendar [11] = new int [ThirtyOne];
    int dayOfWeek = 1;
    for (int year = 1900;
    year < 2001; year ++) {
        for (int month = 0;
        month < calendar.length; month ++) {
            int dayOfMonth = 0;
            int daysInMonth;
            if (month == 1) {
                daysInMonth = isLeapYear (year) ? FebLeap : FebNorm;
            } else {
                daysInMonth = calendar [month].length;
            }
            while (dayOfWeek < 8 && dayOfMonth < daysInMonth) {
                System.out.println ("year: " + year + "\tday: " + dayOfWeek + "\tcalendar[" + month + "][" + dayOfMonth + "]: " + calendar [month] [dayOfMonth]);
                if (dayOfWeek == 7 && year > 1900) {
                    calendar [month] [dayOfMonth] ++;
                    if (dayOfMonth == 0) {
                        numOfSundays ++;
                    }
                }
                dayOfMonth ++;
                dayOfWeek ++;
                if (dayOfWeek > 7) {
                    dayOfWeek = 1;
                }
            }
        }
    }
    for (int month = 0;
    month < calendar.length; month ++) {
        System.out.println (calendar [month] [0]);
    }
    System.out.println (numOfSundays);
}

public static void main (String [] argv) {
    int counter = 0;
    for (int year = 1901, last_year = 2000;
    year <= last_year; year ++) {
        for (int month = 1, last_month = 12;
        month <= last_month; month ++) {
            Date d = new GregorianCalendar (year, month - 1, 1).getTime ();
            if (d.getDay () == 0) {
                counter ++;
                System.out.println (String.valueOf (counter) + " " + d);
            }
        }
    }
    System.out.println ("Total sunday in XX century: " + counter);
}

}
