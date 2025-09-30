public class Clone353 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2662172
*  Stack Overflow answer #:2744638
*  And Stack Overflow answer#:2744638
*/
public void sublayout (int width, int height) {
    if (managerWidth == 0) {
        managerWidth = searchEdit.getPreferredWidth ();
    }
    if (managerHeight == 0) {
        managerHeight = searchEdit.getPreferredHeight ();
    }
    super.sublayout (managerWidth, managerHeight);
    setExtent (managerWidth, managerHeight);
}

protected void sublayout (int maxWidth, int maxHeight) {
    int currX = 0;
    int currY = 0;
    Field currField;
    currField = this.getField (0);
    switch (ScreenConfig.getInstance ().getScreen ()) {
        case ScreenConfig.SCREEN_320_240 :
            currX = 5;
            currY = 3;
            break;
        case ScreenConfig.SCREEN_480_360 :
        case ScreenConfig.SCREEN_480_320 :
            currX = 5;
            currY = 1;
            break;
    }
    this.setPositionChild (currField, currX, currY);
    this.layoutChild (currField, currField.getPreferredWidth (), currField.getPreferredHeight ());
    setExtent (this.getPreferredWidth (), this.getPreferredHeight ());
}

}
