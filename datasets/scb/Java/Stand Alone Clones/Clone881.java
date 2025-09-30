public class Clone881 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:34342816
*  Stack Overflow answer #:47569952
*  And Stack Overflow answer#:41166644
*/
public void onRequestPermissionsResult (int requestCode,@NonNull
String [] permissions,@NonNull
int [] grantResults) {
    if (requestCode == mRequestCode) {
        if (grantResults.length > 0) {
            for (int grantResult : grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    mRequestPermissionListener.onFailed ();
                    return;
                }
            }
            mRequestPermissionListener.onSuccess ();
        } else {
            mRequestPermissionListener.onFailed ();
        }
    }
}

@Override
public void onRequestPermissionsResult (int requestCode,@NonNull
String [] permissions,@NonNull
int [] grantResults) {
    super.onRequestPermissionsResult (requestCode, permissions, grantResults);
    switch (requestCode) {
        case PermissionsUtil.PERMISSION_ALL :
            {
                if (grantResults.length > 0) {
                    List < Integer > indexesOfPermissionsNeededToShow = new ArrayList < > ();
                    for (int i = 0;
                    i < permissions.length; ++ i) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale (this, permissions [i])) {
                            indexesOfPermissionsNeededToShow.add (i);
                        }
                    }
                    int size = indexesOfPermissionsNeededToShow.size ();
                    if (size != 0) {
                        int i = 0;
                        boolean isPermissionGranted = true;
                        while (i < size && isPermissionGranted) {
                            isPermissionGranted = grantResults [indexesOfPermissionsNeededToShow.get (i)] == PackageManager.PERMISSION_GRANTED;
                            i ++;
                        }
                        if (! isPermissionGranted) {
                            showDialogNotCancelable ("Permissions mandatory", "All the permissions are required for this app", new DialogInterface.OnClickListener () {
                                @Override
                                public void onClick (DialogInterface dialogInterface, int i) {
                                    checkPermissions ();
                                }}
                            );
                        }
                    }
                }
            }}
}

}
