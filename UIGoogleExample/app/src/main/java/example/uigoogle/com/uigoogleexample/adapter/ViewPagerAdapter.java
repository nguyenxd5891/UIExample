package example.uigoogle.com.uigoogleexample.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import example.uigoogle.com.uigoogleexample.fragment.Tab1;
import example.uigoogle.com.uigoogleexample.fragment.Tab2;
import example.uigoogle.com.uigoogleexample.fragment.Tab3;
import example.uigoogle.com.uigoogleexample.fragment.Tab4;
import example.uigoogle.com.uigoogleexample.fragment.Tab5;
import example.uigoogle.com.uigoogleexample.object.TabItem;

/**
 * Created by ASUS on 01/09/2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<TabItem> tabItems;


    public ViewPagerAdapter(FragmentManager fm, ArrayList<TabItem> tabItems) {
        super(fm);
        this.tabItems = tabItems;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment tab = tabItems.get(position).getFragment();
        return tab;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabItems.get(position).getTitle();
    }

    @Override
    public int getCount() {

        return tabItems.size();
    }
}
