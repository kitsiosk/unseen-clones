public class Clone939 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:31715310
*  Stack Overflow answer #:31715374
*  And Stack Overflow answer#:31715446
*/
public static void main (String [] args) {
    LocalDateTime from = LocalDateTime.parse ("2015-07-24T09:39:14.000Z", ISODateTimeFormat.dateTime ());
    LocalDateTime to = LocalDateTime.parse ("2015-07-24T09:45:44.000Z", ISODateTimeFormat.dateTime ());
    LocalTime fromTime = from.toLocalTime ();
    LocalTime toTime = to.toLocalTime ();
    System.out.println (fromTime + " - " + toTime);
    System.out.println (fromTime + " before " + toTime + " = " + fromTime.isBefore (toTime));
    System.out.println (fromTime + " after " + toTime + " = " + fromTime.isAfter (toTime));
    System.out.println (fromTime + " equals " + toTime + " = " + fromTime.equals (toTime));
    System.out.println (fromTime + " compareTo " + toTime + " = " + fromTime.compareTo (toTime));
}

public static void main (String [] args) throws ParseException {
    String st1 = "2015-07-24T09:39:14.000Z";
    String st2 = "2015-07-24T09:45:44.000Z";
    String time1 = st1.substring (st1.indexOf ("T") + 1, st1.indexOf (".0"));
    String time2 = st2.substring (st2.indexOf ("T") + 1, st2.indexOf (".0"));
    Date dateTime1 = new java.text.SimpleDateFormat ("HH:mm").parse (time1);
    Date dateTime2 = new java.text.SimpleDateFormat ("HH:mm").parse (time2);
    System.out.println (dateTime1.after (dateTime2));
}

}
