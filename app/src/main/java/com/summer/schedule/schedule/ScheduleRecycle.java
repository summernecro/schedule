package com.summer.schedule.schedule;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.android.lib.util.ScreenUtil;

public class ScheduleRecycle extends RecyclerView {


    public ScheduleRecycle(@NonNull Context context) {
        super(context);
    }

    public ScheduleRecycle(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        //super.onMeasure(widthSpec, heightSpec);
        setMeasuredDimension(7*((int) (ScreenUtil.w-50)/7),MeasureSpec.getSize(heightSpec));
    }
}
