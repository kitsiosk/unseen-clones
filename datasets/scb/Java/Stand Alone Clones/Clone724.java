public class Clone724 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13668588
*  Stack Overflow answer #:25629429
*  And Stack Overflow answer#:46772360
*/
public void onPageScrollStateChanged (int state) {
    Log.v ("onPageScrollStateChanged", String.valueOf (state));
    if (state == ViewPager.SCROLL_STATE_IDLE) {
        int index = pager.getCurrentItem ();
        if (index == 0) pager.setCurrentItem (adapter.getCount () - 2, false);
        else if (index == adapter.getCount () - 1) pager.setCurrentItem (1, false);
    }
}

public void onPageScrollStateChanged (int state) {
    if (state == ViewPager.SCROLL_STATE_IDLE) {
        PagerAdapter pagerAdapter = viewPager.getAdapter ();
        if (pagerAdapter != null) {
            int itemCount = pagerAdapter.getCount ();
            if (itemCount < 2) {
                return;
            }
            int index = viewPager.getCurrentItem ();
            if (index == 0) {
                viewPager.setCurrentItem (itemCount - 2, false);
            } else if (index == itemCount - 1) {
                viewPager.setCurrentItem (1, false);
            }
        }
    }
}

}
