public class Clone883 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:34342816
*  Stack Overflow answer #:41166644
*  And Stack Overflow answer#:39997520
*/
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

@Override
public void onRequestPermissionsResult (int requestCode, String [] permissions, int [] grantResults) {
    super.onRequestPermissionsResult (requestCode, permissions, grantResults);
    switch (requestCode) {
        case REQUEST_READ_PHONE_STATE :
            {
                if (grantResults.length > 0 && grantResults [0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText (LoginActivity.this, "Permission granted.", Toast.LENGTH_SHORT).show ();
                    finish ();
                    startActivity (getIntent ());
                } else {
                    Toast.makeText (LoginActivity.this, "The app was not allowed to get your phone state. Hence, it cannot function properly. Please consider granting it this permission", Toast.LENGTH_LONG).show ();
                }
            } case REQUEST_ACCESS_FINE_LOCATION :
            {
                if (grantResults.length > 0 && grantResults [0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText (LoginActivity.this, "Permission granted.", Toast.LENGTH_SHORT).show ();
                    finish ();
                    startActivity (getIntent ());
                } else {
                    Toast.makeText (LoginActivity.this, "The app was not allowed to get your location. Hence, it cannot function properly. Please consider granting it this permission", Toast.LENGTH_LONG).show ();
                }
            } case REQUEST_WRITE_STORAGE :
            {
                if (grantResults.length > 0 && grantResults [0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText (LoginActivity.this, "Permission granted.", Toast.LENGTH_SHORT).show ();
                    finish ();
                    startActivity (getIntent ());
                } else {
                    Toast.makeText (LoginActivity.this, "The app was not allowed to write to your storage. Hence, it cannot function properly. Please consider granting it this permission", Toast.LENGTH_LONG).show ();
                }
            }}
}

}
