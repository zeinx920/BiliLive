package com.tracyis.bililive.bean;

import java.util.List;

/**
 * Created by Trasys on 2017/5/20.
 */
public class Region {
    private static final String TAG = "Region";

    /**
     * tid : 13
     * reid : 0
     * name : 番剧
     * children : [{"tid":33,"reid":13,"name":"连载动画"},{"tid":32,"reid":13,"name":"完结动画"},{"tid":51,"reid":13,"name":"资讯"},{"tid":152,"reid":13,"name":"官方延伸"}]
     */

    public int tid;
    public int reid;
    public String name;
    public List<ChildrenBean> children;

    public static class ChildrenBean {
        /**
         * tid : 33
         * reid : 13
         * name : 连载动画
         */

        public int tid;
        public int reid;
        public String name;
    }
}
