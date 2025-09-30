public class Clone864 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:33706467
*  Stack Overflow answer #:33706602
*  And Stack Overflow answer#:33706653
*/
@Override
public View getView (final int position, View convertView, ViewGroup parent) {
    final ViewHolder holder;
    if (convertView == null) {
        holder = new ViewHolder ();
        convertView = inflater.inflate (R.layout.row1, null);
        holder.checkbox = (CheckBox) convertView.findViewById (R.id.add_food_item);
        convertView.setTag (holder);
    } else {
        holder = (ViewHolder) convertView.getTag ();
    }
    final ItemInList element = list.get (position);
    holder.checkbox.setChecked (element.isSelected ());
    holder.checkbox.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
        @Override
        public void onCheckedChanged (CompoundButton buttonView, boolean isChecked) {
            element.setSelected (buttonView.isChecked ());
            if (element.isSelected ()) {
                array.add (element.getName ());
            } else {
                if (position < array.size ()) array.remove (position);
            }
        }}
    );
    return convertView;
}

public View getView (final int position, View convertview, ViewGroup parent) {
    View v = convertview;
    LayoutInflater vi = (LayoutInflater) getSystemService (Context.LAYOUT_INFLATER_SERVICE);
    v = vi.inflate (R.layout.row_layout, null);
    final x obj = items.get (position);
    TextView txt_name = (TextView) v.findViewById (R.id.txt_name);
    CheckBox checkBox1 = (CheckBox) findViewById (R.id.checkBox1);
    if (checkBox1.isChecked ()) {
        new_al.add (x_list.get (position));
    }
    btn_clear.setOnItemClickListener (new Listener () {
        public void onClick (View v) {
            x_list.clear ();
            x_list.add (new_al);
        }}
    );
    notifyDataSetChanged ();
    return v;
}

}
