package example.uigoogle.com.uigoogleexample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import example.uigoogle.com.uigoogleexample.R;
import example.uigoogle.com.uigoogleexample.adapter.ViewPagerAdapter;
import example.uigoogle.com.uigoogleexample.customview.SlidingTabLayout;
import example.uigoogle.com.uigoogleexample.object.TabItem;

/**
 * Created by ASUS on 31/08/2015.
 */
public class HomeFragment extends Fragment {
    private ViewPager mPager;
    private ViewPagerAdapter mPagerAdapter;
    public static SlidingTabLayout mSlidingTabLayout;
    private String mTitle[] = {"Home", "Event", "Tab 3", "Tab 4", "Tab 5", "Tab6", "Tab 7", "Tab 8"};
    private Fragment[] fragments = {new Tab1(), new Tab1(), new Tab1(), new Tab1(), new Tab1(), new Tab1(), new Tab1(), new Tab1()};

    private ArrayList<TabItem> tabItems;

    public HomeFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mPager = (ViewPager) view.findViewById(R.id.pager);
        getData();
        mPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), tabItems);
        mPager.setAdapter(mPagerAdapter);
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.white);

            }
        });
        mSlidingTabLayout.setViewPager(mPager);
        return view;
    }

    private void getData() {
        tabItems = new ArrayList<>();
        for (int i = 0; i < mTitle.length; i++) {
            TabItem tabItem = new TabItem();
            tabItem.setTitle(mTitle[i]);
            tabItem.setFragment(fragments[i]);
            tabItems.add(tabItem);
        }
    }
}
