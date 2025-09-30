public class Clone951 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:28356506
*  Stack Overflow answer #:37916222
*  And Stack Overflow answer#:28357193
*/
public Object instantiateItem (ViewGroup collection, int position) {
    LayoutInflater inflater = LayoutInflater.from (mContext);
    ViewGroup layout = (ViewGroup) inflater.inflate (R.layout.account_dialog_signin_viewpagers, collection, false);
    TextView tvLabel = (TextView) layout.findViewById (R.id.textView);
    switch (position) {
        case 0 :
            tvLabel.setText ("Log In");
            tvLabel.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick (View v) {
                }}
            );
            break;
        case 1 :
            tvLabel.setText ("Sign Up");
            tvLabel.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick (View v) {
                }}
            );
            break;
        case 2 :
            tvLabel.setText ("Send Reset Link");
            tvLabel.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick (View v) {
                }}
            );
            break;
    }
    collection.addView (layout);
    return layout;
}

public Object instantiateItem (final ViewGroup container, int position) {
    Button button = new Button (container.getContext ());
    ViewGroup.LayoutParams params = new ViewGroup.LayoutParams (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    button.setLayoutParams (params);
    button.setText (String.valueOf (position));
    LinearLayout layout = new LinearLayout (container.getContext ());
    layout.setOrientation (LinearLayout.VERTICAL);
    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    layout.addView (button);
    final int page = position;
    button.setOnClickListener (new View.OnClickListener () {
        @Override
        public void onClick (View v) {
            Toast.makeText (container.getContext (), "You clicked: " + page + ". page.", Toast.LENGTH_SHORT).show ();
        }}
    );
    container.addView (layout);
    return layout;
}

}
