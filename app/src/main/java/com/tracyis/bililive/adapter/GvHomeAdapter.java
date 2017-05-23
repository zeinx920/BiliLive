package com.tracyis.bililive.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tracyis.bililive.R;

/**
 * Created by Trasys on 2017/5/20.
 */
public class GvHomeAdapter extends BaseAdapter {
    private static final String TAG = "GvHomeAdaer";
    private final Context mContext;
    private final String[] items;
    private final int[] pics = {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,
            R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,
            R.drawable.pic7,R.drawable.pic8,R.drawable.pic9,
            R.drawable.pic10,R.drawable.pic11,};



    public GvHomeAdapter(Context context) {
        mContext = context;
        items = mContext.getResources().getStringArray(R.array.live_category);
    }

    @Override
    public int getCount() {
        return items.length;
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
        if (convertView ==null){
            convertView = View.inflate(mContext,R.layout.item_home_gv,null);
            holder = new Holder();
            holder.pic = (ImageView) convertView.findViewById(R.id.iv_gv_pic);
            holder.name = (TextView) convertView.findViewById(R.id.tv_gv_name);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }
        holder.name.setText(items[position]);
        holder.pic.setImageResource(pics[position]);
        return convertView;
    }

    private  class Holder{
        ImageView pic;
        TextView name;
    }
}
