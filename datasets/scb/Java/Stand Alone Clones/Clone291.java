public class Clone291 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:24885223
*  Stack Overflow answer #:51867820
*  And Stack Overflow answer#:30976972
*/
public MyViewHolder (View view) {
    super (view);
    view.setOnClickListener ((v) -> {
        int adapterPosition = getAdapterPosition ();
        if (adapterPosition >= 0) {
            clicks.onItemSelected (myObject, adapterPosition);
        }
    });
}

public MyViewHolder (View itemView) {
    super (itemView);
    image = (ImageView) itemView.findViewById (R.id.horizontal_list_image);
    title = (TextView) itemView.findViewById (R.id.horizontal_list_title);
    price = (TextView) itemView.findViewById (R.id.horizontal_list_price);
    image.setOnClickListener (this);
    title.setOnClickListener (this);
    price.setOnClickListener (this);
}

}
