package com.summer.schedule.schedule;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.android.lib.util.ScreenUtil;

public class ScheduleItem extends RelativeLayout {

    private int num = 7;

    public ScheduleItem(@NonNull Context context) {
        super(context);
        init();
    }

    public ScheduleItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        int w = (int) ((ScreenUtil.h-50)/num);
        ViewGroup.LayoutParams params = getLayoutParams();
        params.width = w;
        setLayoutParams(params);


    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
//        int w = (int) ((ScreenUtil.h-50)/num);
//        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec),w-1);
//    }
}
