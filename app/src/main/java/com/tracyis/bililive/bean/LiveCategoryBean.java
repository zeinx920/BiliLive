package com.tracyis.bililive.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Trasys on 2017/5/20.
 */
public class LiveCategoryBean implements Serializable{
    private static final String TAG = "LiveCategoryBean";

    /**
     * code : 0
     * message : ok
     * data : {"11":["户外旅行","海外留学","才艺表演","个人自拍"],"10":["唱歌","舞蹈","乐器"],"6":["日常聊天","学习","萌宠","厨艺","手机直播"],"9":["绘画","大触","手绘","板绘","素描","钢笔画"],"2":["手工","声优","cosplay","ASMR"],"1":["使命召唤13","文明6","战地1","minecraft","以撒","东方","尼尔机械纪元"],"3":["守望先锋","炉石传说","三国杀","坦克世界","剑网3","战舰世界","最终幻想14","DNF"],"4":["英雄联盟","DOTA2","星际争霸2","CSGO","风暴英雄","CF","神之浩劫"],"12":["王者荣耀","崩坏3","阴阳师","Fate/GO","梦100","少女前线","ICHU","魔法少女小圆","狼人杀"],"7":["电影","电视","音乐台"],"8":["聊天","音乐"],"99":["投稿"]}
     */

    public int code;
    public String message;
    public DataBean data;

    public static class DataBean implements Serializable{
        @SerializedName("11")
        public List<String> _$11;
        @SerializedName("10")
        public List<String> _$10;
        @SerializedName("6")
        public List<String> _$6;
        @SerializedName("9")
        public List<String> _$9;
        @SerializedName("2")
        public List<String> _$2;
        @SerializedName("1")
        public List<String> _$1;
        @SerializedName("3")
        public List<String> _$3;
        @SerializedName("4")
        public List<String> _$4;
        @SerializedName("12")
        public List<String> _$12;
        @SerializedName("7")
        public List<String> _$7;
        @SerializedName("8")
        public List<String> _$8;
        @SerializedName("99")
        public List<String> _$99;
    }
}
