package com.tracyis.bililive.network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Trasys on 2017/5/20.
 */
public abstract class MyRetroCallback<T1> implements Callback<T1> {
    //   T1      LiveBean
    //   T2      LiveCategoryBean
    //   clazz   LiveCategoryBean.class
    private static final String TAG = "MyRetroCallback";

    //    private T1 datas;
    //    private T2 data;

    @Override
    public void onResponse(Call<T1> call, Response<T1> response) {
        T1 body = response.body();
        onSuccess(body);
    }


    @Override
    public void onFailure(Call<T1> call, Throwable throwable) {
        onFail(throwable.getMessage());
    }

    protected abstract void onSuccess(T1 data);
    protected abstract void onFail(String err);

}
