public class Clone504 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:20127922
*  Stack Overflow answer #:20128076
*  And Stack Overflow answer#:20128606
*/
@Override
protected void onCreate (Bundle savfedInstanceState) {
    super.onCreate (savedInstanceState);
    setContentView (R.layout.indexpage);
    listView = (ListView) findViewById (R.id.pageList);
    editTextB = (EditText) findViewById (R.id.searchB);
    listView.setAdapter (new PagesAdapter (this));
    listView.setOnItemClickListener (new OnItemClickListener () {
        public void onItemClick (AdapterView < ? > parent, View view, int position, long id) {
        }}
    );
}

protected void onCreate (Bundle savedInstanceState) {
    super.onCreate (savedInstanceState);
    setContentView (R.layout.activity_main);
    listView = (ListView) findViewById (R.id.pageList);
    editTextB = (EditText) findViewById (R.id.searchB);
    adapter1 = new PagesAdapter (this);
    listView.setAdapter (adapter1);
    adapter1.notifyDataSetChanged ();
    listView.setOnItemClickListener (this);
    editTextB.addTextChangedListener (new TextWatcher () {
        @Override
        public void onTextChanged (CharSequence cs, int arg1, int arg2, int arg3) {
            IndexPageActivity.this.adapter1.getFilter ().filter (cs.toString ());
            adapter1.notifyDataSetChanged ();
        }@Override
        public void beforeTextChanged (CharSequence arg0, int arg1, int arg2, int arg3) {
        }@Override
        public void afterTextChanged (Editable arg0) {
        }}
    );
}

}
