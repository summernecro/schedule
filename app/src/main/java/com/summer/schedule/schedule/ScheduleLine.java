package com.summer.schedule.schedule;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.android.lib.R.color;

public class ScheduleLine extends ItemDecoration {
    Paint paint = new Paint();
    private Context context;
    private int w = 0;

    public ScheduleLine(Context context, int w) {
        this.context = context;
        this.paint.setColor(context.getResources().getColor(color.black));
        this.w = w;
    }

    public ScheduleLine(Context context, int w, int color) {
        this.context = context;
        this.paint.setColor(color);
        this.w = w;
    }


    public void onDrawOver(Canvas c, RecyclerView parent, State state) {
        int childSize = parent.getChildCount();

        for(int i = 0; i < childSize; ++i) {
            View child = parent.getChildAt(i);

            if(i==6||i==13){
                continue;
            }
            c.drawRect((float)(child.getRight()), (float)(child.getTop()), (float)(child.getRight())+w, (float)(child.getBottom()), this.paint);
//            c.drawRect((float)(child.getLeft() - child.getPaddingLeft()), (float)(child.getBottom() + child.getPaddingBottom()), (float)(child.getRight() + child.getPaddingRight()), (float)(child.getBottom() + child.getPaddingBottom() + this.w), this.paint);
//            c.drawRect((float)(child.getLeft() - child.getPaddingLeft()), (float)(child.getTop() - child.getPaddingTop()), (float)(child.getLeft() - child.getPaddingLeft() + this.w), (float)(child.getBottom() + child.getPaddingBottom()), this.paint);
//            c.drawRect((float)(child.getRight() + child.getPaddingRight()), (float)(child.getTop() - child.getPaddingTop()), (float)(child.getRight() + this.w + child.getPaddingRight()), (float)(child.getBottom() + child.getPaddingBottom()), this.paint);


//            c.drawRect((float)(child.getWidth()/3),0,child.getWidth()/3+w,child.getBottom(), this.paint);
//
//            c.drawRect((float)(child.getWidth()*2/3),0,child.getWidth()*2/3+w,child.getBottom(), this.paint);
        }

//        c.drawRect(parent.getWidth()/6,0,parent.getWidth()/6+w,parent.getBottom(),paint);
//        c.drawRect(parent.getWidth()*2/6,0,parent.getWidth()*2/6+w,parent.getBottom(),paint);
//
//        c.drawRect(parent.getWidth()*4/6,0,parent.getWidth()*4/6+w,parent.getBottom(),paint);
//
//        c.drawRect(parent.getWidth()*5/6,0,parent.getWidth()*5/6+w,parent.getBottom(),paint);

    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
        outRect.set(0,0,0,0);
    }
}
