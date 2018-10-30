package com.summer.schedule.schedule;

import com.android.lib.base.ope.BaseValue;
import com.android.lib.bean.BaseBean;

public class ScheduleBean extends BaseBean {

    private String title;

    private String morning;

    private String afternoon;

    private String night;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMorning() {
        return morning;
    }

    public void setMorning(String morning) {
        this.morning = morning;
    }

    public String getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(String afternoon) {
        this.afternoon = afternoon;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }
}
