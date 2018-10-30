package com.summer.schedule.main;

import com.android.lib.base.activity.BaseActivity;
import com.android.lib.base.activity.BaseUIActivity;
import com.android.lib.base.fragment.FragUtil;
import com.summer.schedule.R;
import com.summer.schedule.schedule.ScheduleFrag;

public class MainAct extends BaseUIActivity<MainUIOpe,MainValue> {

    @Override
    protected void initNow() {
        super.initNow();
        FragUtil.getInstance().start(getActivity(),null,"main",R.id.act_main, ScheduleFrag.getInstance());
    }
}
