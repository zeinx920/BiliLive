package com.tracyis.bililive.ui.fragment;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.tracyis.bililive.R;
import com.tracyis.bililive.adapter.RvAdapter;
import com.tracyis.bililive.bean.DanmuBean;
import com.tracyis.bililive.network.MyRetroCallback;
import com.tracyis.bililive.network.MyRetrofit;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit2.Call;

/**
 * Created by Trasys on 2017/5/23.
 */
public class InteractFragment extends BaseFragment {
    private static final String TAG = "InteractFragment";
    @InjectView(R.id.rv_interact)
    RecyclerView mRvInteract;
    @InjectView(R.id.et_danmu)
    EditText mTvDanmu;
    @InjectView(R.id.iv_interact_send)
    ImageView mIvSend;
    private View mView;
    private List<DanmuBean.DataBean.RoomBean> mRoomMes = new ArrayList<>();
    private RvAdapter mRvAdapter;
    private boolean isRefresh = true;

    @Override
    protected View initView() {
        Log.d(TAG, "initView: 弹幕页面");
        mView = LayoutInflater.from(mContext).inflate(R.layout.fragment_interact, null);
        ButterKnife.inject(this, mView);
        return mView;
    }

    @Override
    protected void initData() {
        mRvAdapter = new RvAdapter(mContext, mRoomMes);
        mRvInteract.setLayoutManager(new LinearLayoutManager(mContext));
        mRvInteract.setHasFixedSize(true);
        mRvInteract.setAdapter(mRvAdapter);

        new Thread() {
            @Override
            public void run() {
                while (isRefresh) {
                    try {
                        Thread.sleep(5000);
                        handler.sendMessage(handler.obtainMessage());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
    }

    public Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            refreshDanmu();
        }
    };

    private void refreshDanmu() {
        Log.d(TAG, "refreshDanmu: 定时刷新弹幕");
        mRoomMes.clear();
        requestNet();
    }

    @Override
    public void requestNet() {
        Call<DanmuBean> rankingBeanCall = MyRetrofit
                .getInstance()
                .getApi()
                .getDanmuList(mRoom);
//        try {
//            Response<DanmuBean> execute = rankingBeanCall.execute();
//            DanmuBean body = execute.body();
//            Log.d(TAG, "requestNet: "+body.data.room.get(0).text);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        rankingBeanCall.enqueue(new MyRetroCallback<DanmuBean>() {
            @Override
            protected void onSuccess(DanmuBean data) {

                //巨坑!!
                // mRoomMes = data.data.room; 千万不要使用
                mRoomMes.addAll(data.data.room);
                Log.d(TAG, "onSuccess: 请求网络数据" + mRoomMes.size());
                mRvInteract.smoothScrollToPosition(mRoomMes.size());
                mRvAdapter.notifyDataSetChanged();
            }

            @Override
            protected void onFail(String err) {
                Log.d(TAG, "onFail: " + err);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
        isRefresh = false;
    }

    @OnClick({R.id.rv_interact,
            R.id.et_danmu,
            R.id.iv_sendgift,
            R.id.iv_interact_send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rv_interact:
              break;
            case R.id.iv_sendgift:
                Toast.makeText(getContext(), "刷礼物", Toast.LENGTH_SHORT).show();
                break;
            case R.id.et_danmu:
                showSoftKeyboard();
                break;
            case R.id.iv_interact_send:
                String mes = mTvDanmu.getText().toString();
                if (!TextUtils.isEmpty(mes)) {
                    DanmuBean.DataBean.RoomBean bean = new DanmuBean.DataBean.RoomBean();
                    bean.nickname = "Admin";
                    bean.text = mes;
                    bean.user_level = new ArrayList<>();
                    bean.user_level.add(0, "VIP");
                    mRoomMes.add(mRoomMes.size(), bean);
                    mRvAdapter.notifyItemInserted(mRoomMes.size());
                    mTvDanmu.setText("");
                    mRvInteract.smoothScrollToPosition(mRoomMes.size());
                    Toast.makeText(mContext, "用户发弹幕", Toast.LENGTH_SHORT).show();
                    HideSoftKeyboard();
                }
                Toast.makeText(getContext(), "弹幕不能为空", Toast.LENGTH_SHORT).show();

                break;
        }
    }

    //打开软键盘
    private void showSoftKeyboard() {
        mTvDanmu.requestFocus();
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mTvDanmu, 0);
    }

    //关闭软键盘
    private void HideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(),
                    0);
        }
    }
}
