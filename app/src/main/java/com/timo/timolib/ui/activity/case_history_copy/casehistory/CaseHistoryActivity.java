package com.timo.timolib.ui.activity.case_history_copy.casehistory;


import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.timo.timolib.R;
import com.timo.timolib.bean.CaseHistoryBean;
import com.timo.timolib.mvp.MVPBaseActivity;
import com.timo.timolib.ui.activity.case_history_copy.addcasehistory_1.AddCaseHistory_1Activity;
import com.timo.timolib.ui.activity.case_history_copy.casehistory.adapter.CaseHistoryAdapter;
import com.timo.trecyclerview.BaseAdapterTools;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

import java.util.List;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class CaseHistoryActivity extends MVPBaseActivity<CaseHistoryContract.View, CaseHistoryPresenter> implements CaseHistoryContract.View, CommonTitleBar.OnTitleBarListener {
    private CommonTitleBar     mTitlebar;
    private XRecyclerView      xrv_case_history;
    private CaseHistoryAdapter adapter;

    @Override
    protected int getContentResId() {
        return R.layout.activity_case_history;
    }

    @Override
    protected void initEvent() {
        mTitlebar = findViewById(R.id.titlebar);
        mTitlebar.setListener(this);
        xrv_case_history = findViewById(R.id.xrv_case_history);
        mPresenter.getData();
    }

    @Override
    public void onClicked(View v, int action, String extra) {
        if (action == CommonTitleBar.ACTION_LEFT_BUTTON) {
            finish();
        } else if (action == CommonTitleBar.ACTION_RIGHT_TEXT) {
            startActivityNoFinish(AddCaseHistory_1Activity.class);
        }
    }

    @Override
    public void onGetData(List<CaseHistoryBean> data) {
        if (adapter == null) {
            adapter = new CaseHistoryAdapter(this, R.layout.item_case_hitory, data);
            xrv_case_history.setPullRefreshEnabled(false);
            xrv_case_history.setPullRefreshEnabled(false);
            BaseAdapterTools.setRecyclerView(this, xrv_case_history, adapter);
        } else {
            adapter.setDatas(data);
            adapter.notifyDataSetChanged();
        }
    }
}
