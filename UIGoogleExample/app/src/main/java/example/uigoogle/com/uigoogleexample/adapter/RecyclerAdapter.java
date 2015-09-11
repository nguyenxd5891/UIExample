package example.uigoogle.com.uigoogleexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import example.uigoogle.com.uigoogleexample.R;
import example.uigoogle.com.uigoogleexample.object.ItemList;

/**
 * Created by ASUS on 07/09/2015.
 */
public class RecyclerAdapter extends RecyclerView.Adapter {
    private ArrayList<ItemList> itemLists;
    private Context mContext;

    public RecyclerAdapter(Context context, ArrayList<ItemList> itemLists) {
        this.mContext = context;
        this.itemLists = itemLists;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_item_recycler_view, parent, false);
        viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemList itemList = itemLists.get(position);
        ((ViewHolder) holder).tvTitle.setText(itemList.getTitle());

    }

    @Override
    public int getItemCount() {
        return itemLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }
}
