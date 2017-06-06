package com.tracyis.bililive.ui.fragment;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.tracyis.bililive.R;
import com.tracyis.bililive.adapter.RankingAdapter;
import com.tracyis.bililive.bean.RankingBean;
import com.tracyis.bililive.network.MyRetroCallback;
import com.tracyis.bililive.network.MyRetrofit;
import com.tracyis.bililive.view.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * Created by Trasys on 2017/5/23.
 */
public class RankingFragment extends BaseFragment {
    private static final String TAG = "RankingFragment";
    private ViewPager mVp;
    private TabPageIndicator mTpi;
    private List<RankingBean.DataBean> mDatas = new ArrayList<>();
    private RankingAdapter mRankingAdapter;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_ranking, null);
        mVp = (ViewPager) view.findViewById(R.id.vp_ranking);
        mTpi = (TabPageIndicator) view.findViewById(R.id.tpi_ranking);
        return view;
    }

    @Override
    protected void initData() {
        mRankingAdapter = new RankingAdapter(mContext, mDatas);
        mVp.setAdapter(mRankingAdapter);
        mTpi.setViewPager(mVp);
    }

    @Override
    protected void initListener() {
        mTpi.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mVp.setCurrentItem(position);
                Call<RankingBean> rankingBeanCall = MyRetrofit
                        .getInstance()
                        .getApi()
                        .getRankingList();
                rankingBeanCall.enqueue(new MyRetroCallback<RankingBean>() {
                    @Override
                    protected void onSuccess(RankingBean data) {
                        mDatas.addAll(data.data);
                        mRankingAdapter.notifyDataSetChanged();
                        Log.d(TAG, "onSuccess: " + mDatas.get(0));
                    }
                });
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void requestNet() {
        Call<RankingBean> rankingBeanCall = MyRetrofit
                .getInstance()
                .getApi()
                .getRankingList();
        Log.d(TAG, "requestNet: 排行请求");
        rankingBeanCall.enqueue(new MyRetroCallback<RankingBean>() {
            @Override
            protected void onSuccess(RankingBean data) {
                mDatas.addAll(data.data);
                Log.d(TAG, "onSuccess: " + mDatas.get(0).username);
                mRankingAdapter.notifyDataSetChanged();
            }

        });

    }
}
