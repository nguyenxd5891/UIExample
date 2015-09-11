package example.uigoogle.com.uigoogleexample.object;

import android.support.v4.app.Fragment;

/**
 * Created by ASUS on 04/09/2015.
 */
public class TabItem {
    private Fragment fragment;
    private String title;

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
