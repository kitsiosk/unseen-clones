public class Clone613 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:47049325
*  Stack Overflow answer #:47049435
*  And Stack Overflow answer#:47049435
*/
@Override
public void onClick (View view) {
    mSort.setOnClickListener (new View.OnClickListener () {
        @Override
        public void onClick (View view) {
            Collections.sort (mKickStarter, new Comparator < Kickstarter > () {
                @Override
                public int compare (Kickstarter item1, Kickstarter item2) {
                    return item1.getTitle ().compareToIgnoreCase (item2.getTitle ());
                }}
            );
        }}
    );
    mAdapter.notifyDataSetChanged ();
}

public void onClick (View view) {
    Collections.sort (mKickStarter, new Comparator < Kickstarter > () {
        @Override
        public int compare (Kickstarter item1, Kickstarter item2) {
            return item1.getTitle ().compareToIgnoreCase (item2.getTitle ());
        }}
    );
}

}
