package com.tracyis.bililive.holder;

import android.content.Context;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Trasys on 2017/6/6.
 */
public abstract class BaseHolder<T> {
    private static final String TAG = "BaseHolder";
    private Context mContext;

    public BaseHolder(Context context) {
        mContext = context;
    }

    public abstract void setData(T t);

    public View onInflateView() {
        View view = View.inflate(mContext, getResId(), null);
        ButterKnife.inject(this, view);
        return view;
    }

    protected abstract int getResId();
}
