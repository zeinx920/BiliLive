package com.tracyis.bililive.adapter;

import android.content.Context;

import com.tracyis.bililive.bean.LiveBean;
import com.tracyis.bililive.holder.BaseHolder;
import com.tracyis.bililive.holder.LiveListHolder;

/**
 * Created by Trasys on 2017/5/25.
 */
public class LiveListGVAdapter extends BasicAdapter {

    private  Context mContext;

    public LiveListGVAdapter(Context context, LiveBean bean) {
        super(bean.data);
        mContext = context;
    }

    @Override
    protected BaseHolder getSubHolder() {
        return new LiveListHolder(mContext);
    }

    //
//    @Override
//    public int getCount() {
//        return mBean.data.size();
//    }
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        Holder holder;
//        if (convertView == null) {
//            convertView = View.inflate(mContext, R.layout.item_livelist_gv, null);
//            holder = new Holder();
//            holder.pic = (ImageView) convertView.findViewById(R.id.iv_preview);
//            holder.des = (TextView) convertView.findViewById(R.id.item_live_des);
//            holder.name = (TextView) convertView.findViewById(R.id.item_live_name);
//            holder.viewer = (TextView) convertView.findViewById(R.id.item_live_viewer);
//
//            convertView.setTag(holder);
//        } else {
//            holder = (Holder) convertView.getTag();
//        }
//
//        Glide.with(mContext)
//                .load(mBean.data.get(position).cover.src)
//                .into(holder.pic);
//        holder.name.setText(mBean.data.get(position).owner.name + "");
//        holder.des.setText(mBean.data.get(position).title + "");
//        holder.viewer.setText(mBean.data.get(position).online + "");
//        return convertView;
//    }
//
//    private class Holder {
//        ImageView pic;
//        TextView des;
//        TextView name;
//        TextView viewer;
//    }
}
