public class Clone878 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:34342816
*  Stack Overflow answer #:35495855
*  And Stack Overflow answer#:41166644
*/
@Override
public void onRequestPermissionsResult (int requestCode, String permissions [], int [] grantResults) {
    Log.d (TAG, "Permission callback called-------");
    switch (requestCode) {
        case REQUEST_ID_MULTIPLE_PERMISSIONS :
            {
                Map < String, Integer > perms = new HashMap < > ();
                perms.put (Manifest.permission.SEND_SMS, PackageManager.PERMISSION_GRANTED);
                perms.put (Manifest.permission.ACCESS_FINE_LOCATION, PackageManager.PERMISSION_GRANTED);
                if (grantResults.length > 0) {
                    for (int i = 0;
                    i < permissions.length; i ++) perms.put (permissions [i], grantResults [i]);
                    if (perms.get (Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED && perms.get (Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        Log.d (TAG, "sms & location services permission granted");
                    } else {
                        Log.d (TAG, "Some permissions are not granted ask again ");
                        if (ActivityCompat.shouldShowRequestPermissionRationale (this, Manifest.permission.SEND_SMS) || ActivityCompat.shouldShowRequestPermissionRationale (this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                            showDialogOK ("SMS and Location Services Permission required for this app", new DialogInterface.OnClickListener () {
                                @Override
                                public void onClick (DialogInterface dialog, int which) {
                                    switch (which) {
                                        case DialogInterface.BUTTON_POSITIVE :
                                            checkAndRequestPermissions ();
                                            break;
                                        case DialogInterface.BUTTON_NEGATIVE :
                                            break;
                                    }
                                }}
                            );
                        } else {
                            Toast.makeText (this, "Go to settings and enable permissions", Toast.LENGTH_LONG).show ();
                        }
                    }
                }
            }}
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
