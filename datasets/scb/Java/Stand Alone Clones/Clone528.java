public class Clone528 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6346075
*  Stack Overflow answer #:19528723
*  And Stack Overflow answer#:15986264
*/
public View getView (int position, View convertView, ViewGroup parent) {
    View rowView = convertView;
    if (rowView == null) {
        LayoutInflater inflater = context.getLayoutInflater ();
        rowView = inflater.inflate (R.layout.test_row, null);
        final TestViewHolder viewHolder = new TestViewHolder ();
        viewHolder.tvCounter = (TextView) rowView.findViewById (R.id.tvCounter);
        rowView.setTag (viewHolder);
    }
    TestViewHolder holder = (TestViewHolder) rowView.getTag ();
    final TextView tv = holder.tvCounter;
    CountDownTimer cdt = counters.get (holder.tvCounter);
    if (cdt != null) {
        cdt.cancel ();
        cdt = null;
    }
    Date date = values.get (position);
    long currentDate = Calendar.getInstance ().getTime ().getTime ();
    long limitDate = date.getTime ();
    long difference = limitDate - currentDate;
    cdt = new CountDownTimer (difference, 1000) {
        @Override
        public void onTick (long millisUntilFinished) {
            int days = 0;
            int hours = 0;
            int minutes = 0;
            int seconds = 0;
            String sDate = "";
            if (millisUntilFinished > DateUtils.DAY_IN_MILLIS) {
                days = (int) (millisUntilFinished / DateUtils.DAY_IN_MILLIS);
                sDate += days + "d";
            }
            millisUntilFinished -= (days * DateUtils.DAY_IN_MILLIS);
            if (millisUntilFinished > DateUtils.HOUR_IN_MILLIS) {
                hours = (int) (millisUntilFinished / DateUtils.HOUR_IN_MILLIS);
            }
            millisUntilFinished -= (hours * DateUtils.HOUR_IN_MILLIS);
            if (millisUntilFinished > DateUtils.MINUTE_IN_MILLIS) {
                minutes = (int) (millisUntilFinished / DateUtils.MINUTE_IN_MILLIS);
            }
            millisUntilFinished -= (minutes * DateUtils.MINUTE_IN_MILLIS);
            if (millisUntilFinished > DateUtils.SECOND_IN_MILLIS) {
                seconds = (int) (millisUntilFinished / DateUtils.SECOND_IN_MILLIS);
            }
            sDate += " " + String.format ("%02d", hours) + ":" + String.format ("%02d", minutes) + ":" + String.format ("%02d", seconds);
            tv.setText (sDate.trim ());
        }@Override
        public void onFinish () {
            tv.setText ("Finished");
        }}
    ;
    counters.put (tv, cdt);
    cdt.start ();
    return rowView;
}

public View getView (int position, View convertView, ViewGroup parent) {
    convertView = mInflater.inflate (R.layout.listview_row, null);
    TextView tvTimer = (TextView) convertView.findViewById (R.id.textview_timer);
    TextView tvName = (TextView) convertView.findViewById (R.id.textview_name);
    Item item = data.get (position);
    tvName.setText (item.getName ());
    myTimer.setTimer (tvTimer, item.getTime ());
    return convertView;
}

}
