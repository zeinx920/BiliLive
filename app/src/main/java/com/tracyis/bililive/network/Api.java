package com.tracyis.bililive.network;

import com.tracyis.bililive.bean.LiveBean;
import com.tracyis.bililive.bean.LiveCategoryBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Trasys on 2017/4/6.
 */
public interface Api {

    @Headers("userid:20428")
    @POST("userinfo")
    Call<Object> getPrivateData();

    @GET("/mobile/rooms?platform=android")
    Call<LiveBean> getLiveList(@Query("area_id") int area);

    @GET("/AppIndex/tags?_device=android&appkey=1d8b6e7d45233436&build=505000&mobi_app=android&platform=android&ts=1495438990&sign=27e923afa5c522c9c8c42f6e56f4bf99")
    Call<LiveCategoryBean> getTopCategory();

    @POST("login?username=test&password=test")
    Call<Object> login();

    @Headers("userid:20428")
    @POST("logout")
    Call<Object> logout();
}
