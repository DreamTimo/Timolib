package com.timo.timolib.ui.activity.case_history_copy.casehistory;

import com.timo.timolib.bean.CaseHistoryBean;
import com.timo.timolib.mvp.BasePresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class CaseHistoryPresenter extends BasePresenterImpl<CaseHistoryContract.View> implements CaseHistoryContract.Presenter {

    @Override
    public void getData() {
        List<CaseHistoryBean> data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            data.add(new CaseHistoryBean("111111" + i, "状态" + i, "门诊", i + "份", "2020-4-1"));
        }
        mView.onGetData(data);
    }
}
