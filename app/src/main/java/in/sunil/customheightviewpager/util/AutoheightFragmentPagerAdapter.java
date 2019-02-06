package in.sunil.customheightviewpager.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public abstract class AutoheightFragmentPagerAdapter extends FragmentPagerAdapter {
    private int mCurrentPosition = -1;

    public AutoheightFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);

        if (position != mCurrentPosition && container instanceof DynamicHeightViewPager) {
            Fragment fragment = (Fragment) object;
            DynamicHeightViewPager pager = (DynamicHeightViewPager) container;

            if (fragment != null && fragment.getView() != null) {
                mCurrentPosition = position;
                pager.measureCurrentView(fragment.getView());
            }
        }
    }
}