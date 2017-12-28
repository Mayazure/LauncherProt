package com.example.mayazure.launcherprot.mart;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Mayazure on 2017/12/27.
 */

public class HorizontalScrollViewEx extends ViewGroup {


    public HorizontalScrollViewEx(Context context) {
        super(context);
    }

    public HorizontalScrollViewEx(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HorizontalScrollViewEx(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public HorizontalScrollViewEx(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int measuredWidth = 0;
        int measuredHeight = 0;
        final int childCount = getChildCount();
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int widthSpaceSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpaceSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        if(childCount == 0){
            setMeasuredDimension(0,0);
        }else if(widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST){
            final View chileView = getChildAt(0);
            measuredWidth = chileView.getMeasuredWidth()*childCount;
            measuredHeight = chileView.getMeasuredHeight();
            setMeasuredDimension(measuredWidth, measuredHeight);
        }else if(widthSpecMode == MeasureSpec.AT_MOST){
            final View childView = getChildAt(0);
            measuredHeight = childView.getMeasuredHeight();
            setMeasuredDimension(widthSpaceSize, measuredHeight);
        }else if( widthSpecMode == MeasureSpec.AT_MOST){
            final View childView = getChildAt(0);
            measuredWidth = childView.getMeasuredWidth();
            setMeasuredDimension(measuredWidth, heightSpaceSize);
        }
    }

    private int mChildrenSize;
    private int mChildWidth;

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childLeft = 0;
        final int childCount = getChildCount();
        mChildrenSize = childCount;

        for(int i=0;i<childCount;i++){
            final View childView = getChildAt(0);
            if(childView.getVisibility()!=View.GONE){
                final int childWidth = childView.getMeasuredWidth();
                mChildWidth = childWidth;
                childView.layout(childLeft,0,childLeft+childWidth,childView.getMeasuredHeight());
                childLeft+=childWidth;
            }
        }

    }
}


