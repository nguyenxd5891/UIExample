package example.uigoogle.com.uigoogleexample.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

import java.util.ArrayList;

import example.uigoogle.com.uigoogleexample.R;
import example.uigoogle.com.uigoogleexample.activity.MainActivity;
import example.uigoogle.com.uigoogleexample.adapter.RecyclerAdapter;
import example.uigoogle.com.uigoogleexample.listener.HidingScrollListener;
import example.uigoogle.com.uigoogleexample.object.ItemList;

/**
 * Created by ASUS on 01/09/2015.
 */
public class Tab1 extends Fragment {
    private ArrayList<ItemList> itemLists = new ArrayList<>();
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private LinearLayout container;
    ActionScroll actionScroll;

    public void setActionScroll(ActionScroll actionScroll) {
        this.actionScroll = actionScroll;
    }

    public void setContainer(LinearLayout container) {
        this.container = container;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_1, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        getData();
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new RecyclerAdapter(getActivity(), itemLists);
        recyclerView.setAdapter(recyclerAdapter);

//        recyclerView.addOnScrollListener(new HidingScrollListener(getActivity()) {
//
//
//            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
//            @Override
//            public void onMoved(int distance) {
//                MainActivity.container1.setTranslationY(-distance);
//            }
//
//            @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
//            @Override
//            public void onShow() {
//                MainActivity.container1.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
//            }
//
//            @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
//            @Override
//            public void onHide() {
//                MainActivity.container1.animate().translationY(-MainActivity.mToolbarHeight).setInterpolator(new AccelerateInterpolator(2)).start();
//            }
//        });
        return v;


    }

    private void getData() {
        for (int i = 0; i < 30; i++) {
            ItemList itemList = new ItemList();
            itemList.setTitle("Item" + i);
            itemLists.add(itemList);
        }
    }

    public static interface ActionScroll {
        public void onScrollListener();
    }
}

