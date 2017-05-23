package com.tracyis.bililive.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Trasys on 2017/5/23.
 */
public abstract class BaseFragment extends Fragment {
    private static final String TAG = "BaseFragment";
    private View mView;
    protected Context mContext;
    protected int mRoom;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getContext();
        mView = initView();
        initData();
        requestNet();
        return mView;
    }

    protected void requestNet() {
    }

    protected abstract View initView();

    protected abstract void initData();

    public void setRoom(int room) {
        mRoom = room;
    }
}
