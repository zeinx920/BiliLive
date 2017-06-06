package com.tracyis.bililive.holder;

import android.content.Context;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tracyis.bililive.R;
import com.tracyis.bililive.bean.LiveBean;
import com.tracyis.bililive.view.RoundedImageView;

import butterknife.InjectView;

/**
 * Created by Trass on 2017/6/6.
 */
public class LiveListHolder extends BaseHolder<LiveBean.DataBean> {
    private static final String TAG = "LiveListHolder";
    @InjectView(R.id.iv_preview)
    RoundedImageView ivPreview;
    @InjectView(R.id.item_live_des)
    TextView itemLiveDes;
    @InjectView(R.id.item_live_name)
    TextView itemLiveName;
    @InjectView(R.id.item_live_viewer)
    TextView itemLiveViewer;
    private Context mContext;


    public LiveListHolder(Context context) {
        super(context);
        mContext = context;
    }


    @Override
    public void setData(LiveBean.DataBean bean) {
        Glide.with(mContext)
                .load(bean.cover.src)
                .into(ivPreview);
        itemLiveName.setText(bean.owner.name + "");
        itemLiveDes.setText(bean.title + "");
        itemLiveViewer.setText(bean.online + "");
    }

    @Override
    protected int getResId() {
        return R.layout.item_livelist_gv;
    }
}
