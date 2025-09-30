public class Clone117 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:5270272
*  Stack Overflow answer #:16858565
*  And Stack Overflow answer#:39383891
*/
public static void main (String args []) {
    System.out.println ("Enter the date(dd/mm/yyyy):");
    Scanner scan = new Scanner (System.in);
    String Date = scan.nextLine ();
    try {
        boolean dateValid = dateValidate (Date);
        if (dateValid == true) {
            SimpleDateFormat df = new SimpleDateFormat ("dd/MM/yy");
            java.util.Date date = df.parse (Date);
            df.applyPattern ("EEE");
            String day = df.format (date);
            if (day.compareTo ("Sat") == 0 || day.compareTo ("Sun") == 0) {
                System.out.println (day + ": Weekend");
            } else {
                System.out.println (day + ": Weekday");
            }
        } else {
            System.out.println ("Invalid Date!!!");
        }
    } catch (Exception e) {
        System.out.println ("Invalid Date Formats!!!");
    }
}

public static void main (String [] args) throws ParseException {
    String month = "08";
    String day = "05";
    String year = "2015";
    String inputDateStr = String.format ("%s/%s/%s", day, month, year);
    Date inputDate = new SimpleDateFormat ("dd/MM/yyyy").parse (inputDateStr);
    Calendar calendar = Calendar.getInstance ();
    calendar.setTime (inputDate);
    String dayOfWeek = calendar.getDisplayName (Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase ();
    System.out.println (dayOfWeek);
}

}
