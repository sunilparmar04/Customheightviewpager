package in.sunil.customheightviewpager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import in.sunil.customheightviewpager.fragments.TabOneFragment;
import in.sunil.customheightviewpager.fragments.TabTwoFragment;
import in.sunil.customheightviewpager.util.AutoheightFragmentPagerAdapter;
import in.sunil.customheightviewpager.util.DynamicHeightViewPager;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTablayout;
    private DynamicHeightViewPager mViewpager;
    private ViewPagerAdapter mViewpagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initTablayout();
    }

    private void initViews() {
        mTablayout = findViewById(R.id.tablayout);
        mViewpager = findViewById(R.id.viewpager);
    }

    private void initTablayout() {
        mViewpagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        TabOneFragment fragment1 = new TabOneFragment();

        mViewpagerAdapter.addFragment(fragment1, "Tab 1");

        TabTwoFragment fragment2 = new TabTwoFragment();
        mViewpagerAdapter.addFragment(fragment2, "Tab 2");

        mViewpager.setAdapter(mViewpagerAdapter);

        mTablayout.setupWithViewPager(mViewpager);

    }


    public class ViewPagerAdapter extends AutoheightFragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        public List<Fragment> getmFragmentList() {
            return mFragmentList;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        @Override
        public void setPrimaryItem(ViewGroup container, int position, Object object) {

            super.setPrimaryItem(container, position, object);

        }

    }
}
