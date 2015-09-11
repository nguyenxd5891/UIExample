package example.uigoogle.com.uigoogleexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import example.uigoogle.com.uigoogleexample.object.NavRowItem;
import example.uigoogle.com.uigoogleexample.R;

/**
 * Created by ASUS on 31/08/2015.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {
    List<NavRowItem> mNavRowItems;
    private LayoutInflater mInflater;
    private Context mContext;

    public NavigationDrawerAdapter(List<NavRowItem> mNavRowItems, Context mContext) {
        this.mNavRowItems = mNavRowItems;
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.nav_row_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NavRowItem currentItem = mNavRowItems.get(position);
        holder.icon.setImageResource(R.mipmap.ic_launcher);
        holder.title.setText(currentItem.getTitle());
    }


    @Override
    public int getItemCount() {
        return mNavRowItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.ivIcon);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }
}
