public class Clone351 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:32714787
*  Stack Overflow answer #:52573709
*  And Stack Overflow answer#:38236485
*/
@Override
public void onRequestPermissionsResult (int requestCode, String permissions [], int [] grantResults) {
    switch (requestCode) {
        case Constants.PERMISSIONS_REQUEST_CALL_PHONE :
            {
                if (grantResults [0] == PackageManager.PERMISSION_GRANTED) {
                    checkPermissionsAndCall ();
                }
            }}
}

public void onRequestPermissionsResult (int requestCode,@NonNull
String [] permissions,@NonNull
int [] grantResults) {
    int index = (requestCode>> 16) & 0xffff;
    if (index != 0) {
        index --;
        String who = mPendingFragmentActivityResults.get (index);
        mPendingFragmentActivityResults.remove (index);
        if (who == null) {
            Log.w (TAG, "Activity result delivered for unknown Fragment.");
            return;
        }
        Fragment frag = mFragments.findFragmentByWho (who);
        if (frag == null) {
            Log.w (TAG, "Activity result no fragment exists for who: " + who);
        } else {
            frag.onRequestPermissionsResult (requestCode & 0xffff, permissions, grantResults);
        }
    }
}

}
