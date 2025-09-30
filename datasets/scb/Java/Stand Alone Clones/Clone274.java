public class Clone274 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:46812878
*  Stack Overflow answer #:46813404
*  And Stack Overflow answer#:46813322
*/
@Override
public void onRequestPermissionsResult (int requestCode,@NonNull
String [] permissions,@NonNull
int [] grantResults) {
    switch (requestCode) {
        case REQUEST_CODE_CAMERA :
            if (grantResults [0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText (this, "Thanks for your permission", LENGTH_SHORT).show ();
                openScanBarCodeAcitvity ();
            } else {
                Toast.makeText (this, "We need your permission to open camera", LENGTH_SHORT).show ();
            }
        default :
            super.onRequestPermissionsResult (requestCode, permissions, grantResults);
            break;
    }
}

@Override
public void onRequestPermissionsResult (int requestCode,@NonNull
String [] permissions,@NonNull
int [] grantResults) {
    super.onRequestPermissionsResult (requestCode, permissions, grantResults);
    if (requestCode == REQUEST_CODE_CAMERA && grantResults [0] == PackageManager.PERMISSION_GRANTED) {
    } else {
    }
}

}
