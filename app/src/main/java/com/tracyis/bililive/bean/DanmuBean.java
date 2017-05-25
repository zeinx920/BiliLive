package com.tracyis.bililive.bean;

import java.util.List;

/**
 * Created by Trasys on 2017/5/23.
 */
public class DanmuBean {
    private static final String TAG = "DanmuBean";


    /**
     * code : 0
     * message : OK
     * data : {"room":[{"text":"忘了这茬","uid":26389822,"nickname":"氿shi","timeline":"2017-05-23 15:18:40","isadmin":0,"vip":0,"svip":0,"medal":[1,"焦糖","奶油小布丁131",247,6406234],"title":[""],"user_level":[19,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":1495512069,"user_title":"","guard_level":0},{"text":"好漂亮啊，喜欢这种画风","uid":68021492,"nickname":"魑魅魍魉つ红瞳木子","timeline":"2017-05-23 15:18:47","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[0,0,9868950,">50000"],"rank":10000,"teamid":0,"rnd":356828794,"user_title":"","guard_level":0},{"text":"(°∀°)ﾉ喜欢的话可以点波订阅，不迷路","uid":8425458,"nickname":"安叁菌","timeline":"2017-05-23 15:19:43","isadmin":1,"vip":0,"svip":0,"medal":[10,"焦糖","奶油小布丁131",247,10512625],"title":["title-95-1"],"user_level":[23,0,5805790,">50000"],"rank":10000,"teamid":0,"rnd":1495520925,"user_title":"title-95-1","guard_level":0},{"text":"细节扣的真好QAQ","uid":1504934,"nickname":"阙傲傲不傲傲","timeline":"2017-05-23 15:23:16","isadmin":0,"vip":0,"svip":0,"medal":[4,"焦糖","奶油小布丁131",247,6406234],"title":["title-111-1"],"user_level":[22,0,5805790,">50000"],"rank":10000,"teamid":0,"rnd":1495519653,"user_title":"title-111-1","guard_level":0},{"text":"上次录播结束了？","uid":32037399,"nickname":"王小仙儿被注册了","timeline":"2017-05-23 15:27:13","isadmin":0,"vip":0,"svip":0,"medal":[5,"焦糖","奶油小布丁131",247,5805790],"title":[""],"user_level":[20,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":1704791887295208111,"user_title":"","guard_level":0},{"text":"结束了","uid":8425458,"nickname":"安叁菌","timeline":"2017-05-23 15:27:22","isadmin":1,"vip":0,"svip":0,"medal":[10,"焦糖","奶油小布丁131",247,10512625],"title":["title-95-1"],"user_level":[23,0,5805790,">50000"],"rank":10000,"teamid":0,"rnd":1495520925,"user_title":"title-95-1","guard_level":0},{"text":"没上传吗？","uid":32037399,"nickname":"王小仙儿被注册了","timeline":"2017-05-23 15:28:19","isadmin":0,"vip":0,"svip":0,"medal":[5,"焦糖","奶油小布丁131",247,5805790],"title":[""],"user_level":[20,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":1807734744192265254,"user_title":"","guard_level":0},{"text":"等大哥整理完，会上传的","uid":8425458,"nickname":"安叁菌","timeline":"2017-05-23 15:28:33","isadmin":1,"vip":0,"svip":0,"medal":[10,"焦糖","奶油小布丁131",247,10512625],"title":["title-95-1"],"user_level":[23,0,5805790,">50000"],"rank":10000,"teamid":0,"rnd":1495520925,"user_title":"title-95-1","guard_level":0},{"text":"6666","uid":32037399,"nickname":"王小仙儿被注册了","timeline":"2017-05-23 15:28:50","isadmin":0,"vip":0,"svip":0,"medal":[5,"焦糖","奶油小布丁131",247,5805790],"title":[""],"user_level":[20,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":1302476648697523350,"user_title":"","guard_level":0},{"text":"坐等2333","uid":32037399,"nickname":"王小仙儿被注册了","timeline":"2017-05-23 15:29:00","isadmin":0,"vip":0,"svip":0,"medal":[5,"焦糖","奶油小布丁131",247,5805790],"title":[""],"user_level":[20,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":209516586790483413,"user_title":"","guard_level":0}],"admin":[]}
     */

    public int code;
    public String message;
    public DataBean data;

    public static class DataBean {
        public List<RoomBean> room;

        public static class RoomBean {
            /**
             * text : 忘了这茬
             * uid : 26389822
             * nickname : 氿shi
             * timeline : 2017-05-23 15:18:40
             * isadmin : 0
             * vip : 0
             * svip : 0
             * medal : [1,"焦糖","奶油小布丁131",247,6406234]
             * title : [""]
             * user_level : [19,0,6406234,">50000"]
             * rank : 10000
             * teamid : 0
             * rnd : 1495512069
             * user_title :
             * guard_level : 0
             */

            public String text;
            public int uid;
            public String nickname;
            public String timeline;
            public int isadmin;
            public int vip;
            public int svip;
            public int rank;
            public int teamid;
            public double rnd;
            public String user_title;
            public int guard_level;
            public List<String> medal;
            public List<String> title;
            public List<String> user_level;
        }
    }
}
