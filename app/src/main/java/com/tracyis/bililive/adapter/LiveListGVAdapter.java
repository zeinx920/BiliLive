package com.tracyis.bililive.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tracyis.bililive.R;
import com.tracyis.bililive.bean.LiveBean;

/**
 * Created by Trasys on 2017/5/25.
 */
public class LiveListGVAdapter extends BaseAdapter {

    private  Context mContext;
    private  LiveBean mBean;

    public LiveListGVAdapter(Context context, LiveBean bean) {
        mContext = context;
        mBean = bean;
    }

    @Override
    public int getCount() {
        return mBean.data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_livelist_gv, null);
            holder = new Holder();
            holder.pic = (ImageView) convertView.findViewById(R.id.iv_preview);
            holder.des = (TextView) convertView.findViewById(R.id.item_live_des);
            holder.name = (TextView) convertView.findViewById(R.id.item_live_name);
            holder.viewer = (TextView) convertView.findViewById(R.id.item_live_viewer);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        Glide.with(mContext)
                .load(mBean.data.get(position).cover.src)
                .into(holder.pic);
        holder.name.setText(mBean.data.get(position).owner.name + "");
        holder.des.setText(mBean.data.get(position).title + "");
        holder.viewer.setText(mBean.data.get(position).online + "");
        return convertView;
    }

    private class Holder {
        ImageView pic;
        TextView des;
        TextView name;
        TextView viewer;
    }
}
