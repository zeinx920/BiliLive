package com.tracyis.bililive.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tracyis.bililive.R;
import com.tracyis.bililive.bean.LiveBean;

import java.util.ArrayList;

/**
 * Created by Trasys on 2017/5/22.
 */
public class LiveListActivity extends AppCompatActivity {
    private static final String TAG = "LiveListActivity";
    private GridView mGv;
    private LiveBean mBean;
    private ArrayList<String> mLiveTopList = new ArrayList<String>() {
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livelist);
        mGv = (GridView) findViewById(R.id.gv_live_list);

        LinearLayout ll_list = (LinearLayout) findViewById(R.id.ll_live_list);
        initData();
        initListener();

        for (int i = 0; i < mLiveTopList.size(); i++) {
            TextView customTextView = new TextView(LiveListActivity.this);
            customTextView.setText(mLiveTopList.get(i).toString());

            customTextView.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_tv));
            ll_list.setPadding(10,10,10,10);
            ll_list.addView(customTextView);
        }

    }

    private void initListener() {
        mGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LiveListActivity.this, VideoViewActivity.class);
                intent.putExtra("stream_addr", mBean.data.get(position).playurl);
                startActivity(intent);
            }
        });

    }


    private void initData() {
        mBean = (LiveBean) getIntent().getSerializableExtra("liveBean");
        mLiveTopList = (ArrayList<String>) getIntent().getSerializableExtra("topList");
        mGv.setAdapter(new MyGVAdapter());
    }


    private class MyGVAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mBean.data.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;
            if (convertView == null) {
                convertView = View.inflate(LiveListActivity.this, R.layout.item_livelist_gv, null);
                holder = new Holder();
                holder.pic = (ImageView) convertView.findViewById(R.id.iv_preview);
                holder.des = (TextView) convertView.findViewById(R.id.item_live_des);
                holder.name = (TextView) convertView.findViewById(R.id.item_live_name);
                holder.viewer = (TextView) convertView.findViewById(R.id.item_live_viewer);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }

            Glide.with(LiveListActivity.this)
                    .load(mBean.data.get(position).cover.src)
                    .into(holder.pic);
            holder.name.setText(mBean.data.get(position).owner.name + "");
            holder.des.setText(mBean.data.get(position).title + "");
            holder.viewer.setText(mBean.data.get(position).online + "");
            return convertView;
        }

        private class Holder {
            ImageView pic;
            TextView des;
            TextView name;
            TextView viewer;
        }
    }
}
