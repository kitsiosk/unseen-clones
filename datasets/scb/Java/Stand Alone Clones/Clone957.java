public class Clone957 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:625433
*  Stack Overflow answer #:38931440
*  And Stack Overflow answer#:7663966
*/
public static String getDurationBreakdown (long millis) {
    if (millis < 0) {
        throw new IllegalArgumentException ("Duration must be greater than zero!");
    }
    long days = TimeUnit.MILLISECONDS.toDays (millis);
    long hours = TimeUnit.MILLISECONDS.toHours (millis) % 24;
    long minutes = TimeUnit.MILLISECONDS.toMinutes (millis) % 60;
    long seconds = TimeUnit.MILLISECONDS.toSeconds (millis) % 60;
    long milliseconds = millis % 1000;
    return String.format ("%d Days %d Hours %d Minutes %d Seconds %d Milliseconds", days, hours, minutes, seconds, milliseconds);
}

public static String getDurationBreakdown (long millis) {
    if (millis < 0) {
        throw new IllegalArgumentException ("Duration must be greater than zero!");
    }
    long days = TimeUnit.MILLISECONDS.toDays (millis);
    millis -= TimeUnit.DAYS.toMillis (days);
    long hours = TimeUnit.MILLISECONDS.toHours (millis);
    millis -= TimeUnit.HOURS.toMillis (hours);
    long minutes = TimeUnit.MILLISECONDS.toMinutes (millis);
    millis -= TimeUnit.MINUTES.toMillis (minutes);
    long seconds = TimeUnit.MILLISECONDS.toSeconds (millis);
    StringBuilder sb = new StringBuilder (64);
    sb.append (days);
    sb.append (" Days ");
    sb.append (hours);
    sb.append (" Hours ");
    sb.append (minutes);
    sb.append (" Minutes ");
    sb.append (seconds);
    sb.append (" Seconds");
    return (sb.toString ());
}

}
