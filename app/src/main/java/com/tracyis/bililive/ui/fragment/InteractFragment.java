package com.tracyis.bililive.ui.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
        mRvInteract.setAdapter(mRvAdapter);
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
                mRoomMes = data.data.room;
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
    }

    @OnClick({R.id.rv_interact,
            R.id.et_danmu,
            R.id.iv_interact_send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rv_interact:
                break;
            case R.id.et_danmu:
                //打开软键盘
                showSoftKeyboard();
                break;
            case R.id.iv_interact_send:
                String mes = mTvDanmu.getText().toString();
                DanmuBean.DataBean.RoomBean bean = new DanmuBean.DataBean.RoomBean();
                bean.nickname = "Admin";
                bean.text = mes;
                bean.user_level = new ArrayList<>();
                bean.user_level.add(0, "VIP");
                mRoomMes.add(mRoomMes.size(), bean);
                mRvAdapter.notifyItemInserted(mRoomMes.size());
                mTvDanmu.setText("");
                Toast.makeText(mContext, "用户发弹幕", Toast.LENGTH_SHORT).show();
                //关闭软键盘
                HideSoftKeyboard();
                break;
        }
    }

    private void showSoftKeyboard() {
        mTvDanmu.requestFocus();
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mTvDanmu, 0);
    }

    private void HideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(),
                    0);
        }
    }

}
