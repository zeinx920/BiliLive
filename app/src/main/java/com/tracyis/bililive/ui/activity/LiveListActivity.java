package com.tracyis.bililive.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.tracyis.bililive.R;
import com.tracyis.bililive.adapter.HlvAdapter;
import com.tracyis.bililive.adapter.LiveListGVAdapter;
import com.tracyis.bililive.bean.LiveBean;
import com.tracyis.bililive.view.HorizontalListView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Trasys on 2017/5/22.
 */
public class LiveListActivity extends AppCompatActivity {
    private static final String TAG = "LiveListActivity";
    @InjectView(R.id.tb_liveList)
    Toolbar mTbLiveList;
    private GridView mGv;
    private HorizontalListView mHlv;
    private LiveBean mBean;
    private String mTitle;
    private ArrayList<String> mLiveTopList = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livelist);
        ButterKnife.inject(this);
        mGv = (GridView) findViewById(R.id.gv_live_list);
        mHlv = (HorizontalListView) findViewById(R.id.hlv_livelist);

        initData();
        initTopicView();
        initListener();
    }

    private void initTopicView() {
        mHlv.setAdapter(new HlvAdapter(this,mLiveTopList));
    }

    private void initListener() {
        mGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LiveListActivity.this, VideoViewActivity.class);
                intent.putExtra("stream_addr", mBean.data.get(position).playurl);
                intent.putExtra("room_id", mBean.data.get(position).room_id);
                startActivity(intent);
            }
        });
        mTbLiveList.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initData() {
        mBean = (LiveBean) getIntent().getSerializableExtra("liveBean");
        mTitle = (String) getIntent().getSerializableExtra("tb_title");
        mTbLiveList.setTitle(mTitle);
        mLiveTopList = (ArrayList<String>) getIntent().getSerializableExtra("topList");
        mGv.setAdapter(new LiveListGVAdapter(this, mBean));
    }
}
