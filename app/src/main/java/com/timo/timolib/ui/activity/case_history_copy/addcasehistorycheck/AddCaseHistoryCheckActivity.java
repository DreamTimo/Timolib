package com.timo.timolib.ui.activity.case_history_copy.addcasehistorycheck;


import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.timo.timolib.R;
import com.timo.timolib.mvp.MVPBaseActivity;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class AddCaseHistoryCheckActivity extends MVPBaseActivity<AddCaseHistoryCheckContract.View, AddCaseHistoryCheckPresenter> implements AddCaseHistoryCheckContract.View, View.OnClickListener {
    private TextView     tv_open;
    private LinearLayout case_root_1;
    private LinearLayout case_root_2;
    private LinearLayout case_root_3;
    private LinearLayout case_root_4;
    private boolean      isOpen;

    @Override
    protected int getContentResId() {
        return R.layout.activity_add_case_history_check;
    }

    @Override
    protected void initEvent() {
        tv_open = findViewById(R.id.tv_open);
        case_root_1 = findViewById(R.id.case_root_1);
        case_root_2 = findViewById(R.id.case_root_2);
        case_root_3 = findViewById(R.id.case_root_3);
        case_root_4 = findViewById(R.id.case_root_4);
        tv_open.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_open) {
            if (isOpen) {
                isOpen = false;
                case_root_1.setVisibility(View.GONE);
                case_root_2.setVisibility(View.GONE);
                case_root_3.setVisibility(View.GONE);
                case_root_4.setVisibility(View.GONE);
                tv_open.setText("[查看更多]");
            } else {
                isOpen = true;
                case_root_1.setVisibility(View.VISIBLE);
                case_root_2.setVisibility(View.VISIBLE);
                case_root_3.setVisibility(View.VISIBLE);
                case_root_4.setVisibility(View.VISIBLE);
                tv_open.setText("[收起]");
            }
        }

    }
}
