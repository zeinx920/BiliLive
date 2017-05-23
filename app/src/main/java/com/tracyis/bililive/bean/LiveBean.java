package com.tracyis.bililive.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Trasys on 2017/5/20.
 */
public class LiveBean implements Serializable{
    private static final String TAG = "LiveBean";


    /**
     * code : 0
     * message : ok
     * data : [{"owner":{"face":"http://i1.hdslb.com/bfs/face/7ea6b9bd3a6ec2a103d964ea6ae4db553a74c323.jpg","mid":13557341,"name":"黑灵是哥哥"},"cover":{"src":"http://i0.hdslb.com/bfs/live/5447ad127caafb9f1178e7580e90d999d76e46e8.jpg","height":180,"width":320},"title":"声控王者:B站第一李白打野退,"broadcast_type":0,"area":"手游直播","area_id":12},{"owner":{"face":"http://i1.hdslb.com/dcast_type":0,"area":"手游直播","area_id":12},{"owner":{"face":"http://i1.hdslb.com/bfs/face/d4acdae5cadc712280afbe03cd23f1bd51f5f377.jpg","mid":26714418,"name":"神樣存在的貓"},"cover":{"src":"http://i0.hdslb.com/bfs/live/962faf3bcbd3f36f8642f8b686bdd9b74c2a5ffc.jpg","height":180,"width":320},"title":"【王者弱鸡】5.20一起抠脚不孤单","room_id":4196529,"online":1294,"playurl":"http://txy.live-play.acgvideo.com/live-txy/618905/live_26714418_6338952.flv?wsSecret=41eb5b0c3c6d394636f5717401da3222&wsTime=1495272537","accept_quality":"4","broadcast_type":0,"area":"手游直播","area_id":12}]
     */

    public int code;
    public String message;
    public List<DataBean> data;

    public static class DataBean implements Serializable{
        /**
         * owner : {"face":"http://i1.hdslb.com/bfs/face/7ea6b9bd3a6ec2a103d964ea6ae4db553a74c323.jpg","mid":13557341,"name":"黑灵是哥哥"}
         * cover : {"src":"http://i0.hdslb.com/bfs/live/5447ad127caafb9f1178e7580e90d999d76e46e8.jpg","height":180,"width":320}
         * title : 声控王者:B站第一李白打野退站倒数12天
         * room_id : 209929
         * online : 23422
         * playurl : http://live-play.acgvideo.com/live/268/live_13557341_9215495.flv?wsSecret=57e6a448fd452df50fc27c0d0755b8ec&wsTime=58f88661
         * accept_quality : 4
         * broadcast_type : 0
         * area : 手游直播
         * area_id : 12
         */

        public OwnerBean owner;
        public CoverBean cover;
        public String title;
        public int room_id;
        public int online;
        public String playurl;
        public String accept_quality;
        public int broadcast_type;
        public String area;
        public int area_id;

        public static class OwnerBean implements Serializable{
            /**
             * face : http://i1.hdslb.com/bfs/face/7ea6b9bd3a6ec2a103d964ea6ae4db553a74c323.jpg
             * mid : 13557341
             * name : 黑灵是哥哥
             */

            public String face;
            public int mid;
            public String name;
        }

        public static class CoverBean implements Serializable{
            /**
             * src : http://i0.hdslb.com/bfs/live/5447ad127caafb9f1178e7580e90d999d76e46e8.jpg
             * height : 180
             * width : 320
             */

            public String src;
            public int height;
            public int width;
        }
    }
}
