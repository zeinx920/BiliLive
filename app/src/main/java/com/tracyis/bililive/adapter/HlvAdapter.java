package com.tracyis.bililive.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tracyis.bililive.R;

import java.util.ArrayList;

/**
 * Created by Trasys on 2017/5/25.
 */
public class HlvAdapter extends BaseAdapter {
    private static final String TAG = "HlvAdapter";
    private ArrayList<String> mList;
    private Context mContext;

    public HlvAdapter(Context context, ArrayList<String> liveTopList) {
        mContext = context;
        mList = liveTopList;
    }



    @Override
    public int getCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_hlv, null);
            holder = new Holder();
            holder.name = (TextView) convertView.findViewById(R.id.tv_hlv);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        if (position == 0) {
            holder.name.setText("全部");
        } else {
            holder.name.setText(mList.get(position) + "");
        }
        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class Holder {
        TextView name;
    }

}
