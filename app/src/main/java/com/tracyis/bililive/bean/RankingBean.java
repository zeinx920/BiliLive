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
     * data : [{"uid":1927852,"ruid":13086801,"rank":1,"username":"莉莉茶","face":"http://i1.hdslb.com/bfs/face/8e247afa2d29a76b350127a6a8af049c4964edc4.jpg","is_alive":0,"guard_level":2},{"uid":6494413,"ruid":13086801,"rank":2,"username":"囧纸亲","face":"http://i0.hdslb.com/bfs/face/ded42582dd22188104a2fe2bf7d232f26e152a53.gif","is_alive":0,"guard_level":2},{"uid":22277053,"ruid":13086801,"rank":3,"username":"夸夸的melody","face":"http://i0.hdslb.com/bfs/face/1bb7472ed60b77483adec4d0bc9f90c9811444b9.jpg","is_alive":0,"guard_level":3},{"uid":23491292,"ruid":13086801,"rank":4,"username":"Sumurui_苏木","face":"http://i2.hdslb.com/bfs/face/1490c5e78abd6bfeb0b7c259c0e87398d1a3f94b.jpg","is_alive":0,"guard_level":3},{"uid":62592367,"ruid":13086801,"rank":5,"username":"11094","face":"http://i1.hdslb.com/bfs/face/c14bd8624645cc90706725d224bee6972ed174cb.jpg","is_alive":0,"guard_level":3},{"uid":74244866,"ruid":13086801,"rank":6,"username":"头顶锅盖的闹闹就闹囧","face":"http://i2.hdslb.com/bfs/face/7eaef991b1332bc13b351eb96db64c9c72daf353.jpg","is_alive":0,"guard_level":3},{"uid":18859447,"ruid":13086801,"rank":7,"username":"百晓生はいる","face":"http://i1.hdslb.com/bfs/face/966048d3164e71db28c1b22e118c3293ce84b50c.jpg","is_alive":0,"guard_level":3},{"uid":15606874,"ruid":13086801,"rank":8,"username":"夏暖略萌","face":"http://i1.hdslb.com/bfs/face/3611cd5f55144ad04d189a434aea095cfc2fd81b.jpg","is_alive":0,"guard_level":3},{"uid":12048009,"ruid":13086801,"rank":9,"username":"不是Av的Ay君","face":"http://i2.hdslb.com/bfs/face/cbffa287c66e642d01cc7881d7fcbdc67c6f02b5.jpg","is_alive":0,"guard_level":3},{"uid":37323871,"ruid":13086801,"rank":10,"username":"京都冈本君","face":"http://i2.hdslb.com/bfs/face/bb20bd4fbccc00ef004939e75328f67bbb8e19e8.jpg","is_alive":0,"guard_level":3},{"uid":27324288,"ruid":13086801,"rank":11,"username":"JeanineYe","face":"http://i2.hdslb.com/bfs/face/2514a9661c3fc594a7cecb0e18a4ee701ab5006c.jpg","is_alive":0,"guard_level":3},{"uid":33614548,"ruid":13086801,"rank":12,"username":"52赫兹のXs","face":"http://i0.hdslb.com/bfs/face/7f0d870348459cb85748ca50ca3595b8ccf4af56.jpg","is_alive":0,"guard_level":3},{"uid":25253657,"ruid":13086801,"rank":13,"username":"路凹凸","face":"http://i2.hdslb.com/bfs/face/8ee2b3f82fc13b3df242a3e80e315d4012faea4a.jpg","is_alive":0,"guard_level":3},{"uid":44099244,"ruid":13086801,"rank":14,"username":"迷路的喷火炔","face":"http://i1.hdslb.com/bfs/face/80c6e485c72baa946af1bad3451e415c5a258d78.jpg","is_alive":0,"guard_level":3},{"uid":2155634,"ruid":13086801,"rank":15,"username":"守护橘子の腰子","face":"http://i2.hdslb.com/bfs/face/ea092234b3e71857a9323e3389e6a649a0dfe7f2.jpg","is_alive":0,"guard_level":3}]
     */

    public int code;
    public String message;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * uid : 1927852
         * ruid : 13086801
         * rank : 1
         * username : 莉莉茶
         * face : http://i1.hdslb.com/bfs/face/8e247afa2d29a76b350127a6a8af049c4964edc4.jpg
         * is_alive : 0
         * guard_level : 2
         */

        public int uid;
        public int ruid;
        public int rank;
        public String username;
        public String face;
        public int is_alive;
        public int guard_level;
    }
}
