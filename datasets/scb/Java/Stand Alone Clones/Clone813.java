public class Clone813 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:9162705
*  Stack Overflow answer #:31268081
*  And Stack Overflow answer#:34944232
*/
@Override
public boolean onKeyDown (int keyCode, KeyEvent event) {
    if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)) {
        return true;
    } else if ((keyCode == KeyEvent.KEYCODE_VOLUME_UP)) {
        return true;
    } else return super.onKeyDown (keyCode, event);
}

@Override
public boolean onKeyDown (int keyCode, KeyEvent event) {
    super.onKeyDown (keyCode, event);
    if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
        Toast.makeText (MainActivity.this, "Down working", Toast.LENGTH_SHORT).show ();
        return true;
    }
    return false;
}

}
