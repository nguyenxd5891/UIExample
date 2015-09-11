package example.uigoogle.com.uigoogleexample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.uigoogle.com.uigoogleexample.R;

/**
 * Created by ASUS on 31/08/2015.
 */
public class GameFragment extends Fragment {
    public GameFragment() {
    
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        return view;
    }
}
