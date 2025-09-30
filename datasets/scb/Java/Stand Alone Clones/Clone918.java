public class Clone918 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:53428224
*  Stack Overflow answer #:53428891
*  And Stack Overflow answer#:53428427
*/
@Override
public void onBindViewHolder (MyViewHolder holder, final int position) {
    AnimalObject animalObject = list.get (position);
    holder.title.setText (animalObject.name);
    holder.itemView.setOnClickListener (new View.OnClickListener () {
        @Override
        public void onClick (View v) {
            AnimalObject animalObject = list.get (position);
            int currentCheckedStatus = animalObject.ischecked ();
            for (int i = 0;
            i < list.size (); i ++) {
                if (i == position) {
                    animalObject.setIschecked (! currentCheckedStatus);
                } else {
                    animalObject.setIschecked (false);
                }
            }
            notifyDataSetChanged ();
        }}
    );
    holder.checkBox.setChecked (animalObject.ischecked ());
}

@Override
public void onBindViewHolder (final Main_Page_Payment_Cash_Adapter.ViewHolder holder, final int position) {
    holder.itemView.setOnClickListener (new View.OnClickListener () {
        @Override
        public void onClick (View v) {
            row_index = position;
            notifyDataSetChanged ();
        }}
    );
    if (row_index == position) {
    } else {
    }
}

}
