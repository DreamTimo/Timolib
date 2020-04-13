package com.timo.timolib.ui.activity.case_history_copy.casehistory;

import android.content.Context;

import com.timo.timolib.bean.CaseHistoryBean;
import com.timo.timolib.mvp.BasePresenter;
import com.timo.timolib.mvp.BaseView;

import java.util.List;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class CaseHistoryContract {
    public interface View extends BaseView {
        void onGetData(List<CaseHistoryBean> data);
    }

    interface  Presenter extends BasePresenter<View> {
       void getData();
    }
}
