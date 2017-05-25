package com.tracyis.bililive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tracyis.bililive.R;
import com.tracyis.bililive.bean.DanmuBean;

import java.util.List;

/**
 * Created by Trasys on 2017/5/23.
 */
public class RvAdapter extends RecyclerView.Adapter {
    private static final String TAG = "RvAdapter";
    private final List<DanmuBean.DataBean.RoomBean> mRoomMes;
    private final Context mContext;


    public RvAdapter(Context context, List<DanmuBean.DataBean.RoomBean> roomMes) {
        mRoomMes = roomMes;
        mContext = context;
        Log.d(TAG, "RvAdapter: " + mRoomMes.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_danmu, null);
        return new DanmuHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((DanmuHolder) holder).name.setText(mRoomMes.get(position).nickname);
        ((DanmuHolder) holder).text.setText(mRoomMes.get(position).text);
        if (mRoomMes.get(position).user_level.get(0) != null) {
            ((DanmuHolder) holder).level.setText(mRoomMes.get(position).user_level.get(0) + "");
        }
    }

    @Override
    public int getItemCount() {
        return mRoomMes.size();
    }

    private class DanmuHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView text;
        private final TextView level;

        public DanmuHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_danmu_name);
            level = (TextView) itemView.findViewById(R.id.tv_danmu_level);
            text = (TextView) itemView.findViewById(R.id.tv_danmu_text);

        }
    }

    private class AdminDanmuHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView text;
        private final TextView level;

        public AdminDanmuHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_danmu_admin_name);
            level = (TextView) itemView.findViewById(R.id.tv_danmu_admin_level);
            text = (TextView) itemView.findViewById(R.id.tv_danmu_admin_text);

        }
    }
}
