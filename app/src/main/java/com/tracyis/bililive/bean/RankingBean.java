package com.tracyis.bililive.bean;

import java.util.List;

/**
 * Created by Trasys on 2017/5/23.
 */
public class RankingBean {
    private static final String TAG = "RankingBean";

    /**
     * code : 0
     * message : OK
     * data : {"status":2,"unlogin":1,"unwear":1,"uname":"","rank":0,"medal_name":"","medal_level":0,"medal_color":0,"list":[{"medal_name":"捞粉","level":15,"uname":"black五仁月饼","color":16746162,"face":"http://i2.hdslb.com/bfs/face/bbcc6dd505a088c31b35ad857a4778f991ff5a63.jpg"},{"medal_name":"捞粉","level":13,"uname":"萌萌哒的A","color":16746162,"face":"http://i1.hdslb.com/bfs/face/7d81bd746c73b6d69da6caa4fb93ec6b908c1c65.jpg"},{"medal_name":"捞粉","level":12,"uname":"蒼青是暖色的","color":10512625,"face":"http://i0.hdslb.com/bfs/face/f491198233491e7691b382c246b7c328197bd8f1.jpg"},{"medal_name":"捞粉","level":12,"uname":"戚凌少爷","color":10512625,"face":"http://i0.hdslb.com/bfs/face/a8a824aae46cba96236b5e178e805b3f7974fedc.jpg"},{"medal_name":"捞粉","level":12,"uname":"学长的狼","color":10512625,"face":"http://i1.hdslb.com/bfs/face/f848f8e0d3d0dd545e2df5163e59552114577cb5.jpg"},{"medal_name":"捞粉","level":11,"uname":"锦瑞在放空","color":10512625,"face":"http://i0.hdslb.com/bfs/face/992df1ca386c2616f632ad228e8e9683e5e53a4e.jpg"},{"medal_name":"捞粉","level":11,"uname":"avalor","color":10512625,"face":"http://static.hdslb.com/images/member/noface.gif"},{"medal_name":"捞粉","level":10,"uname":"Im花雨","color":10512625,"face":"http://i1.hdslb.com/bfs/face/a25e095f7248fdf81d503c68553256ae926a2723.jpg"},{"medal_name":"捞粉","level":10,"uname":"Amazoncom","color":10512625,"face":"http://static.hdslb.com/images/member/noface.gif"},{"medal_name":"捞粉","level":10,"uname":"汽水骑着沐沐带我入欧","color":10512625,"face":"http://i1.hdslb.com/bfs/face/cbfce30705b315529b47d6f354b3b0f4793b291f.jpg"}]}
     */

    public int code;
    public String message;
    public DataBean data;

    public static class DataBean {
        /**
         * status : 2
         * unlogin : 1
         * unwear : 1
         * uname :
         * rank : 0
         * medal_name :
         * medal_level : 0
         * medal_color : 0
         * list : [{"medal_name":"捞粉","level":15,"uname":"black五仁月饼","color":16746162,"face":"http://i2.hdslb.com/bfs/face/bbcc6dd505a088c31b35ad857a4778f991ff5a63.jpg"},{"medal_name":"捞粉","level":13,"uname":"萌萌哒的A","color":16746162,"face":"http://i1.hdslb.com/bfs/face/7d81bd746c73b6d69da6caa4fb93ec6b908c1c65.jpg"},{"medal_name":"捞粉","level":12,"uname":"蒼青是暖色的","color":10512625,"face":"http://i0.hdslb.com/bfs/face/f491198233491e7691b382c246b7c328197bd8f1.jpg"},{"medal_name":"捞粉","level":12,"uname":"戚凌少爷","color":10512625,"face":"http://i0.hdslb.com/bfs/face/a8a824aae46cba96236b5e178e805b3f7974fedc.jpg"},{"medal_name":"捞粉","level":12,"uname":"学长的狼","color":10512625,"face":"http://i1.hdslb.com/bfs/face/f848f8e0d3d0dd545e2df5163e59552114577cb5.jpg"},{"medal_name":"捞粉","level":11,"uname":"锦瑞在放空","color":10512625,"face":"http://i0.hdslb.com/bfs/face/992df1ca386c2616f632ad228e8e9683e5e53a4e.jpg"},{"medal_name":"捞粉","level":11,"uname":"avalor","color":10512625,"face":"http://static.hdslb.com/images/member/noface.gif"},{"medal_name":"捞粉","level":10,"uname":"Im花雨","color":10512625,"face":"http://i1.hdslb.com/bfs/face/a25e095f7248fdf81d503c68553256ae926a2723.jpg"},{"medal_name":"捞粉","level":10,"uname":"Amazoncom","color":10512625,"face":"http://static.hdslb.com/images/member/noface.gif"},{"medal_name":"捞粉","level":10,"uname":"汽水骑着沐沐带我入欧","color":10512625,"face":"http://i1.hdslb.com/bfs/face/cbfce30705b315529b47d6f354b3b0f4793b291f.jpg"}]
         */

        public int status;
        public int unlogin;
        public int unwear;
        public String uname;
        public int rank;
        public String medal_name;
        public int medal_level;
        public int medal_color;
        public List<ListBean> list;

        public static class ListBean {
            /**
             * medal_name : 捞粉
             * level : 15
             * uname : black五仁月饼
             * color : 16746162
             * face : http://i2.hdslb.com/bfs/face/bbcc6dd505a088c31b35ad857a4778f991ff5a63.jpg
             */

            public String medal_name;
            public int level;
            public String uname;
            public int color;
            public String face;
        }
    }
}
