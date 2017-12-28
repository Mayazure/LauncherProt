package com.example.mayazure.launcherprot.mview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by Mayazure on 2017/12/26.
 * This ViewGroup gives horizontal layout and scroll view
 * Child can be view or viewgroup, but
 * every child view will takes up one entire page.
 */

public class MHorizontalPageScrollView extends ViewGroup {

    private int overScrollSize = 1080;
    private int pageSize = 1080;
    private int pageCount = 0;
    private int minScrollSzie = 300;
    private int currentPage = 0;
    private int sidePadding = 20;

    private Scroller mScroller;

    public MHorizontalPageScrollView(Context context) {
        super(context);
    }

    public MHorizontalPageScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MHorizontalPageScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MHorizontalPageScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (changed) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childView = getChildAt(i);
                childView.layout(overScrollSize + i * pageSize, 0, overScrollSize + i * pageSize + childView.getMeasuredWidth(), childView.getMeasuredHeight());
            }
        }
        scrollTo(overScrollSize,0);
    }

    public void addView(View v){

    }

    public void removeView(View v){

    }
}
