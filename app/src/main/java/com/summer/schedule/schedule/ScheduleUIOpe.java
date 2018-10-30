package com.summer.schedule.schedule;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.android.lib.base.adapter.AppsDataBindingAdapter;
import com.android.lib.base.ope.BaseUIOpe;
import com.android.lib.bean.AppViewHolder;
import com.android.lib.util.ScreenUtil;
import com.android.lib.util.dialog.DialogUtil;
import com.summer.schedule.BR;
import com.summer.schedule.R;
import com.summer.schedule.databinding.DialogUpdateBinding;
import com.summer.schedule.databinding.FragMainBinding;
import com.summer.schedule.databinding.ItemScheduleBinding;

import java.util.ArrayList;

public class ScheduleUIOpe extends BaseUIOpe<FragMainBinding> {

    public void initList(ArrayList<ScheduleBean> strs, View.OnClickListener listener){

        getBind().recycle.addItemDecoration(new ScheduleLine(getActivity(),2));
        getBind().recycle.setLayoutManager(new GridLayoutManager(getActivity(),7));
        final int w = (int) ((ScreenUtil.w-50)/7);
        getBind().recycle.setAdapter(new AppsDataBindingAdapter(getActivity(),R.layout.item_schedule, BR.itemSchedule,strs,true,listener){
            @Override
            public void onBindViewHolder(AppViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                ItemScheduleBinding itemScheduleBinding = (ItemScheduleBinding) holder.viewDataBinding;
                ViewGroup.LayoutParams params = itemScheduleBinding.getRoot().getLayoutParams();
                params.height = ScreenUtil.h>ScreenUtil.w? (int) (ScreenUtil.w/2): (int) (ScreenUtil.h/2);
                itemScheduleBinding.getRoot().setLayoutParams(params);
                if(position==0){
                    itemScheduleBinding.top.setBackgroundResource(R.drawable.coner_item_schedule_left);
                }else  if(position==6){
                    itemScheduleBinding.top.setBackgroundResource(R.drawable.coner_item_schedule_right);
                }else{
                    itemScheduleBinding.top.setBackgroundColor(Color.RED);
                }
                setTag(itemScheduleBinding.morning,position);itemScheduleBinding.morning.setTag(R.id.data1,"morning");itemScheduleBinding.morning.setOnLongClickListener(this);
                setTag(itemScheduleBinding.afternoon,position);itemScheduleBinding.afternoon.setTag(R.id.data1,"afternoon");itemScheduleBinding.afternoon.setOnLongClickListener(this);
                setTag(itemScheduleBinding.night,position);itemScheduleBinding.night.setTag(R.id.data1,"night");itemScheduleBinding.night.setOnLongClickListener(this);
            }

            public boolean onLongClick(View v) {
                if (this.listener != null) {
                    v.setTag(R.id.data1,"long");
                    this.listener.onClick(v);
                }

                return true;
            }
        });
    }

    public void notifyDataSetChanged(){
        getBind().recycle.getAdapter().notifyDataSetChanged();
    }

    public void showUpdateDialog(View.OnClickListener listener,int pos,int id){
        DialogUpdateBinding dialogUpdateBinding = DialogUpdateBinding.inflate(getActivity().getLayoutInflater());
        dialogUpdateBinding.sure.setTag(R.id.position,pos);
        DialogUtil.getInstance().showDialog(getActivity(),dialogUpdateBinding.getRoot(),"123",listener,R.id.sure);
        switch (id) {
            case R.id.morning:
                dialogUpdateBinding.sure.setTag(R.id.data, "morning");
                break;
            case R.id.afternoon:
                dialogUpdateBinding.sure.setTag(R.id.data, "afternoon");
                break;
            case R.id.night:
                dialogUpdateBinding.sure.setTag(R.id.data, "night");
                break;
        }
    }
}
