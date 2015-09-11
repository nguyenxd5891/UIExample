package example.uigoogle.com.uigoogleexample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.uigoogle.com.uigoogleexample.R;

/**
 * Created by ASUS on 01/09/2015.
 */
public class Tab3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_1, container, false);
        return v;
    }
}
