package com.tracyis.bililive.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.tracyis.bililive.R;
import com.tracyis.bililive.adapter.RvAdapter;
import com.tracyis.bililive.bean.DanmuBean;
import com.tracyis.bililive.network.MyRetroCallback;
import com.tracyis.bililive.network.MyRetrofit;

import java.util.List;

import retrofit2.Call;

/**
 * Created by Trasys on 2017/5/23.
 */
public class InteractFragment extends BaseFragment {
    private static final String TAG = "InteractFragment";
    private RecyclerView mRv_danmu;
    private View mView;
    private List<DanmuBean.DataBean.RoomBean> mRoomMes;
    private RvAdapter mRvAdapter;

    @Override
    protected View initView() {
        Log.d(TAG, "initView: 弹幕页面");
        mView = LayoutInflater.from(mContext).inflate(R.layout.fragment_interact, null);
        mRv_danmu = (RecyclerView) mView.findViewById(R.id.rv_interact);
        return mView;
    }
    @Override
    protected void initData() {
        mRvAdapter = new RvAdapter(mContext,mRoomMes);
        mRv_danmu.setAdapter(mRvAdapter);
    }

    @Override
    protected void requestNet() {
        Log.d(TAG, "requestNet: 请求网络");
        Call<DanmuBean> rankingBeanCall = MyRetrofit
                .getInstance()
                .getApi()
                .getDanmuList(mRoom);
        rankingBeanCall.enqueue(new MyRetroCallback<DanmuBean>() {
            @Override
            protected void onSuccess(DanmuBean data) {
                mRoomMes = data.data.room;
                mRvAdapter.notifyDataSetChanged();
                Log.d(TAG, "onSuccess: " +data.data.room.get(0).text);

            }

            @Override
            protected void onFail(String err) {
                Log.d(TAG, "onFail: "+err);

            }
        });

    }
}
