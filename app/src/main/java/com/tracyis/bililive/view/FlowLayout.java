package com.tracyis.bililive.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FlowLayout extends ViewGroup {
    private Line mCurrentLine;
    private ArrayList<Line> mLines = new ArrayList<>();
    private int mVerticalSpace = 15;

    public FlowLayout(Context context) {
        this(context,null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //由于测量和layout会重复调用，因此保证line的指针为初始位置，lines集合是初始状态
        mLines.clear();
        mCurrentLine = null;
        Log.e("flowlayout", "onMeasure");
        //4.开始测量,获取宽高信息
        int width = MeasureSpec.getSize(widthMeasureSpec);
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int maxWidth = width - getPaddingLeft() - getPaddingRight();
        //5.测量孩子
        int childCount = getChildCount();
        for(int i=0;i<childCount;i++){
            View child = getChildAt(i);
//            child.measure(widthMeasureSpec,heightMeasureSpec);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            //6.添加孩子到line中,还要把当前的line添加到flowlayout
           if(mCurrentLine == null){
               mCurrentLine = new Line(15, maxWidth);
               mLines.add(mCurrentLine);
               mCurrentLine.addChild(child);
           }else{
               //第一次以后需要判断是否可以添加孩子
               if(mCurrentLine.canAddChild(child)){
                   mCurrentLine.addChild(child);
               }else{
                   //剩余空间不足，要创建新的line
                   mCurrentLine = new Line(15, maxWidth);
                   mLines.add(mCurrentLine);
                   mCurrentLine.addChild(child);
               }
           }
        }

        //7.测量自己,height要通过line做累加处理
        int height = getPaddingTop() + getPaddingBottom(); //支持padding
        for(Line line : mLines){
            height += line.mHeight;
            height += mVerticalSpace;
        }
        setMeasuredDimension(width,height);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.e("flowlayout", "onLayout");
        int top = t + getPaddingTop();
        int left = l + getPaddingLeft();
        for(Line line :mLines){
            line.onLayout(left,top);
            //8.每次layout一行以后，更新top值
            top += line.mHeight;
            top += mVerticalSpace;
        }
    }

    public class Line {
        private ArrayList<View> mViews = new ArrayList<>();
        private int mUsedWidth;
        private int mMaxWidth;
        private int mSpace;
        private int mHeight;

        public Line(int mSpace, int mMaxWidth) {
            this.mSpace = mSpace;
            this.mMaxWidth = mMaxWidth;
        }

        //1.添加孩子
        public void addChild(View child){
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            //3.更新line的变量
            mUsedWidth += childWidth;
            if(mViews.size() > 0) {
                mUsedWidth += mSpace;
            }
            mViews.add(child);
            mHeight = childHeight > mHeight ? childHeight : mHeight;
        }

        //2.是否可以添加
        public boolean canAddChild(View child){
            if(mViews.size()==0){
                //第一个孩子必须放置
                return true;
            }
            //剩余空间没有当前view的宽度大，就会添加失败
            int childWidth = child.getMeasuredWidth();
            if(mUsedWidth + childWidth + mSpace > mMaxWidth){
                return false;
            }
            return true;
        }

        public void onLayout(int l, int t) {
            int avg = (mMaxWidth - mUsedWidth) / mViews.size();
            for(int i=0;i<mViews.size();i++){
                View child = mViews.get(i);
                //10.让childWidth增加avg,需要重新测量，肯定也会重新onlayout
                int childWidth = child.getMeasuredWidth();
                int childHeight = child.getMeasuredHeight();
                int childWidthSpec = MeasureSpec.makeMeasureSpec(childWidth + avg, MeasureSpec.EXACTLY);
                int childHeightSpec = MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY);
                child.measure(childWidthSpec,childHeightSpec);
                childWidth = child.getMeasuredWidth();
//                childHeight = child.getMeasuredHeight();
                int left = l;
                int right = left + childWidth;
                int top  = t;
                int bottom = top + childHeight;
                //9.平摊剩余空间到每一个孩子上
                child.layout(left,top,right,bottom);
                //刷新left值
                l += childWidth;
                l += mSpace;
            }
        }
    }
}
