package com.tracyis.bililive.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.tracyis.bililive.R;

/**
 * Created by Trasys on 2017/5/22.
 */
public class CustomTextView extends TextView {
    private static final String TAG = "CustomeTextView";

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

      View.inflate(getContext(), R.layout.customtextview,null);
    }
}
