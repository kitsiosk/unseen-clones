public class Clone120 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:11875403
*  Stack Overflow answer #:11875807
*  And Stack Overflow answer#:14620088
*/
public void onCreate (Bundle savedInstanceState) {
    super.onCreate (savedInstanceState);
    setContentView (R.layout.main);
    mTextView = (TextView) findViewById (R.id.empty);
    mCountDownTimer = new CountDownTimer (mInitialTime, 1000) {
        StringBuilder time = new StringBuilder ();
        @Override
        public void onFinish () {
            mTextView.setText (DateUtils.formatElapsedTime (0));
        }@Override
        public void onTick (long millisUntilFinished) {
            time.setLength (0);
            if (millisUntilFinished > DateUtils.DAY_IN_MILLIS) {
                long count = millisUntilFinished / DateUtils.DAY_IN_MILLIS;
                if (count > 1) time.append (count).append (" days ");
                else time.append (count).append (" day ");
                millisUntilFinished %= DateUtils.DAY_IN_MILLIS;
            }
            time.append (DateUtils.formatElapsedTime (Math.round (millisUntilFinished / 1000d)));
            mTextView.setText (time.toString ());
        }}
    .start ();
}

public void onCreate (Bundle savedInstanceState) {
    super.onCreate (savedInstanceState);
    tv = new TextView (this);
    this.setContentView (tv);
    SimpleDateFormat formatter = new SimpleDateFormat ("dd.MM.yyyy, HH:mm");
    String oldTime = "19.02.2018, 12:00";
    String NewTime = "20.02.2018, 14:00";
    Date oldDate, newDate;
    try {
        oldDate = formatter.parse (oldTime);
        newDate = formatter.parse (NewTime);
        oldLong = oldDate.getTime ();
        NewLong = newDate.getTime ();
        diff = NewLong - oldLong;
    } catch (ParseException e) {
        e.printStackTrace ();
    }
    MyCount counter = new MyCount (diff, 1000);
    counter.start ();
}

}
