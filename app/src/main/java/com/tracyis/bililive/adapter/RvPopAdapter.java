package com.tracyis.bililive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tracyis.bililive.R;

import java.util.ArrayList;

/**
 * Created by Trasys on 2017/5/26.
 */
public class RvPopAdapter extends RecyclerView.Adapter{
    private static final String TAG = "RvPopAdapter";
    private final ArrayList<String> mCategory;
    private final Context mContext;

    public RvPopAdapter(Context context, ArrayList roomMes) {
        mCategory = roomMes;
        mContext = context;
        Log.d(TAG, "RvAdapter: " + mCategory.size());
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_hlv, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Holder)holder).name.setText(mCategory.get(position));
    }

    @Override
    public int getItemCount() {
        return mCategory.size();
    }

    private class Holder extends RecyclerView.ViewHolder {

        private final TextView name;

        public Holder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_hlv);

        }
    }

    private class AdminDanmuHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView text;
        private final TextView level;

        public AdminDanmuHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_danmu_admin_name);
            level = (TextView) itemView.findViewById(R.id.tv_danmu_admin_level);
            text = (TextView) itemView.findViewById(R.id.tv_danmu_admin_text);

        }
    }
}
