package com.tracyis.bililive.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tracyis.bililive.R;

/**
 * Created by Administrator on 2017/5/23 0023.
 */

public class View_item extends LinearLayout {
    TextView mItemName;
    TextView mContent;
    private String mTitle;
    private String mContentText;

    public View_item(Context context) {
        this(context, null);
    }


    public View_item(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public View_item(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View inflate = inflater.inflate(R.layout.view_item_check, this);
         mItemName = (TextView) inflate.findViewById(R.id.item_name);
         mContent = (TextView) inflate.findViewById(R.id.content);

        //获取属性值
        TypedArray at = context.obtainStyledAttributes(attrs, R.styleable.ItemLinearLayout);
        String title = at.getString(R.styleable.ItemLinearLayout_title);
        String content = at.getString(R.styleable.ItemLinearLayout_content);
        //如果字符串为null，则设置默认的为""
        setDefaultText(title);
        setDefaultText(content);

        mTitle = title;
        mContentText = content;
        mItemName.setText(mTitle);
        mContent.setText(mContentText);
        at.recycle();
    }
    /**
     * 如果字符串为null，设置默认的""字符串
     *
     * @param text
     */
    private void setDefaultText(String text) {
        if (text == null) {
            text = "";
        }
    }

    public void setTitleText(String title) {
        mTitle = title;
    }

    public void setContentText(String contentText) {
        mContentText = contentText;
    }

}
