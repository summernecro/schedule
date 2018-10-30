package com.summer.schedule.schedule;

import android.databinding.DataBindingUtil;
import android.text.TextUtils;
import android.view.View;

import com.android.lib.base.fragment.BaseUIFrag;
import com.android.lib.util.dialog.DialogUtil;
import com.summer.schedule.R;
import com.summer.schedule.databinding.DialogUpdateBinding;

public class ScheduleFrag extends BaseUIFrag<ScheduleUIOpe,ScheduleValue>  {

    public static ScheduleFrag getInstance(){
        ScheduleFrag scheduleFrag = new ScheduleFrag();
        return scheduleFrag;
    }

    @Override
    public void initNow() {
        super.initNow();
        getPU().initList(getPV().getDatas(),this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.morning:
            case R.id.afternoon:
            case R.id.night:
                if("onClick".equals(v.getTag(R.id.data1))){
                    return;
                }
                getPU().showUpdateDialog(this, (Integer) v.getTag(R.id.position),v.getId());
                break;
            case R.id.sure:
                DialogUpdateBinding dialogUpdateBinding = DataBindingUtil.bind((View) v.getTag(R.id.data1));
                if(!TextUtils.isEmpty(dialogUpdateBinding.txt.getText())){
                    switch ((String)v.getTag(R.id.data)){
                        case "morning":
                            getPV().getDatas().get((Integer) v.getTag(R.id.position)).setMorning(dialogUpdateBinding.txt.getText().toString());
                            break;
                        case "afternoon":
                            getPV().getDatas().get((Integer) v.getTag(R.id.position)).setAfternoon(dialogUpdateBinding.txt.getText().toString());
                            break;
                        case "night":
                            getPV().getDatas().get((Integer) v.getTag(R.id.position)).setNight(dialogUpdateBinding.txt.getText().toString());
                            break;
                    }
                }
                DialogUtil.getInstance().dismiss();
                getPU().notifyDataSetChanged();
                break;
        }
    }
}
