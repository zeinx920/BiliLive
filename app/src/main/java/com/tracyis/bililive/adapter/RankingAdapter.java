package com.tracyis.bililive.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tracyis.bililive.bean.RankingBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trasys on 2017/5/23.
 */
public class RankingAdapter extends PagerAdapter {
    private static final String TAG = "RankingAdapter";
    private String[] titles = {"七日榜","助推榜","舰队"};
    private Context mContext;
    private List<RankingBean.DataBean> data = new ArrayList<>();

    public RankingAdapter(Context context, List<RankingBean.DataBean> datas) {
        mContext=context;
        data = datas;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object == view;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ListView listView = new ListView(mContext);
        listView.setAdapter(new RankingListAdapter(mContext,data));
        container.addView(listView);
        return listView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
