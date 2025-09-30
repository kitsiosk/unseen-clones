public class Clone136 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:9155105
*  Stack Overflow answer #:9156368
*  And Stack Overflow answer#:9155402
*/
public void onActivityResult (int requestCode, int resultCode, Intent data) {
    super.onActivityResult (requestCode, resultCode, data);
    if (resultCode == RESULT_OK) {
        switch (requestCode) {
            case SELECT_IMAGE :
                String imagePath = getPath (data.getData ());
                Savingimagepath (imagePath);
                img.setImageDrawable (Drawable.createFromPath (imagePath));
                break;
        }
    }
}

@Override
protected void onActivityResult (int requestCode, int resultCode, Intent data) {
    super.onActivityResult (requestCode, resultCode, data);
    if (requestCode == IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
        DBHelper dbHelper = new DBHelper (this);
        SQLiteDatabase sql = dbHelper.getWritableDatabase ();
        sql.execSQL ("insert statement for inserting path to database");
        sql.close ();
        dbHelper.close ();
    }
}

}
