package com.tracyis.bililive.network;

import com.tracyis.bililive.bean.DanmuBean;
import com.tracyis.bililive.bean.LiveBean;
import com.tracyis.bililive.bean.LiveCategoryBean;
import com.tracyis.bililive.bean.RankingBean;

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

    @POST("/appApi/v1.0/common/sendPhoneCode")
    Call<Object> register(@Query("mobilePhone") String phone);

    @GET("/mobile/rooms?platform=android")
    Call<LiveBean> getLiveList(@Query("area_id") int area);

    @GET("/AppIndex/tags?_device=android&appkey=1d8b6e7d45233436&build=505000&mobi_app=android&platform=android&ts=1495438990&sign=27e923afa5c522c9c8c42f6e56f4bf99")
    Call<LiveCategoryBean> getTopCategory();

    @GET("/AppRoom/msg?_device=android&appkey=1d8b6e7d45233436&build=505000&mobi_app=android&platform=android&room_id=14682&ts=1495524590&sign=3732dbd4e25f10024fc14e11ff00d885")
    Call<DanmuBean> getDanmuList(@Query("room_id") int room_id);

    @GET("/AppRoom/guardRank?_device=android&appkey=1d8b6e7d45233436&build=505000&mobi_app=android&page=1&page_size=15&platform=android&ruid=700152&ts=1495515600&sign=7a98896752c160e5126c415f85df2cdd")
    Call<RankingBean> getRankingList();
}
