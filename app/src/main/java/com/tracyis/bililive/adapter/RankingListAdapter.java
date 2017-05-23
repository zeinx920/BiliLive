package com.tracyis.bililive.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tracyis.bililive.R;
import com.tracyis.bililive.bean.RankingBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trasys on 2017/5/23.
 */
public class RankingListAdapter extends BaseAdapter {
    private static final String TAG = "RankingListAdapter";
    private final Context mContext;
    private List<RankingBean.DataBean.ListBean> datas = new ArrayList<>();

    public RankingListAdapter(Context context, List<RankingBean.DataBean.ListBean> data) {
        mContext = context;
        datas = data;
    }

    @Override
    public int getCount() {
        return datas.size();
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
            convertView = View.inflate(mContext, R.layout.item_ranking, null);
            holder = new Holder();
            holder.devote = (TextView) convertView.findViewById(R.id.tv_ranking_devote);
            holder.rank = (TextView) convertView.findViewById(R.id.tv_ranking_rank);
            holder.name = (TextView) convertView.findViewById(R.id.tv_ranking_name);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.name.setText(datas.get(position).uname + "");
        holder.devote.setText(datas.get(position).level + "");
        holder.rank.setText(datas.get(position).level + "");
        return convertView;
    }

    private class Holder {
        TextView name;
        TextView devote;
        TextView rank;
    }
}
