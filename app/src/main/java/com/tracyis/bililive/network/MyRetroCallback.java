package com.tracyis.bililive.network;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Trasys on 2017/5/20.
 */
public abstract class MyRetroCallback<T> implements Callback<T> {
    //   T1      LiveBean
    //   T2      LiveCategoryBean
    //   clazz   LiveCategoryBean.class

    private static final String TAG = "MyRetroCallback";

    //    private T1 datas;
    //    private T2 data;

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        T body = response.body();
        onSuccess(body);
    }

    @Override
    public void onFailure(Call<T> call, Throwable throwable) {
        Log.d(TAG, "onFail: "  + throwable.getMessage());
    }

    protected abstract void onSuccess(T data);

}
