package com.tracyis.bililive.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tracyis.bililive.holder.BaseHolder;

import java.util.List;

/**
 * Created by Trasys on 2017/6/6.
 */
public abstract class BasicAdapter<T> extends BaseAdapter {
    private static final String TAG = "BasicAdapter";

    private List<T> datas;

    @Override
    public int getCount() {
        return datas.size();
    }

    public BasicAdapter(List<T> datas) {
        this.datas = datas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseHolder holder;
        if (convertView == null) {
            holder = getSubHolder();
            convertView = holder.onInflateView();
            convertView.setTag(holder);
        } else {
            holder = (BaseHolder) convertView.getTag();
        }
        onBindView();
        T t = datas.get(position);
        holder.setData(t);

        return convertView;
    }

    protected abstract BaseHolder getSubHolder();

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private void onBindView() {

    }
}
