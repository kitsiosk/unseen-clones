public class Clone753 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6721134
*  Stack Overflow answer #:7387359
*  And Stack Overflow answer#:15007980
*/
public String getContactName (final String phoneNumber) {
    Uri uri;
    String [] projection;
    mBaseUri = Contacts.Phones.CONTENT_FILTER_URL;
    projection = new String [] {android.provider.Contacts.People.NAME};
    try {
        Class < ? > c = Class.forName ("android.provider.ContactsContract$PhoneLookup");
        mBaseUri = (Uri) c.getField ("CONTENT_FILTER_URI").get (mBaseUri);
        projection = new String [] {"display_name"};
    } catch (Exception e) {
    }
    uri = Uri.withAppendedPath (mBaseUri, Uri.encode (phoneNumber));
    Cursor cursor = this.getContentResolver ().query (uri, projection, null, null, null);
    String contactName = "";
    if (cursor.moveToFirst ()) {
        contactName = cursor.getString (0);
    }
    cursor.close ();
    cursor = null;
    return contactName;
}

private String getContactName (Context context, String number) {
    String name = null;
    String [] projection = new String [] {ContactsContract.PhoneLookup.DISPLAY_NAME, ContactsContract.PhoneLookup._ID};
    Uri contactUri = Uri.withAppendedPath (ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode (number));
    Cursor cursor = context.getContentResolver ().query (contactUri, projection, null, null, null);
    if (cursor != null) {
        if (cursor.moveToFirst ()) {
            name = cursor.getString (cursor.getColumnIndex (ContactsContract.PhoneLookup.DISPLAY_NAME));
            Log.v (TAG, "Started uploadcontactphoto: Contact Found @ " + number);
            Log.v (TAG, "Started uploadcontactphoto: Contact name  = " + name);
        } else {
            Log.v (TAG, "Contact Not Found @ " + number);
        }
        cursor.close ();
    }
    return name;
}

}
