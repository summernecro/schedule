package com.summer.schedule.schedule;

import android.text.TextUtils;

import com.android.lib.base.ope.BaseValue;
import com.android.lib.constant.ValueConstant;
import com.android.lib.util.GsonUtil;
import com.android.lib.util.SPUtil;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleValue extends BaseValue {

    private ArrayList<ScheduleBean> datas= new ArrayList<>();

    @Override
    public void initValue() {
        super.initValue();
        String str = SPUtil.getInstance().getStr("ScheduleBean");
        if(TextUtils.isEmpty(str)){
            for(int i=0;i<14;i++){
                ScheduleBean scheduleBean = new ScheduleBean();
                scheduleBean.setTitle(i+"");
                datas.add(scheduleBean);
            }
        }else{
            datas = GsonUtil.getInstance().fromJson(str,new TypeToken<ArrayList<ScheduleBean>>(){}.getType());
        }

    }
}
