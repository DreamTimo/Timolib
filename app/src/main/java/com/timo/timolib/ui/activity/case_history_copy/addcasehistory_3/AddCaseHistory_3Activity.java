package com.timo.timolib.ui.activity.case_history_copy.addcasehistory_3;


import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.timo.timolib.R;
import com.timo.timolib.mvp.MVPBaseActivity;
import com.timo.timolib.ui.activity.case_history_copy.addcasehistorycheck.AddCaseHistoryCheckActivity;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class AddCaseHistory_3Activity extends MVPBaseActivity<AddCaseHistory_3Contract.View, AddCaseHistory_3Presenter> implements AddCaseHistory_3Contract.View, CommonTitleBar.OnTitleBarListener, View.OnClickListener {
    private CommonTitleBar mTitlebar;
    private TextView       tv_description;
    private TextView       tv_choice_modle_1,tv_choice_modle_2;
    private LinearLayout   ll_modle_1,ll_modle_2;
    private Button         bt_confirm;
    private int            type;//0代表自取，1代表快递邮寄
    @Override
    protected int getContentResId() {
        return R.layout.activity_add_case_history_3;
    }

    @Override
    protected void initEvent() {
        mTitlebar = findViewById(R.id.titlebar);
        bt_confirm = findViewById(R.id.bt_confirm);
        tv_choice_modle_1 = findViewById(R.id.tv_choice_modle_1);
        ll_modle_1 = findViewById(R.id.ll_modle_1);
        tv_choice_modle_2 = findViewById(R.id.tv_choice_modle_2);
        ll_modle_2 = findViewById(R.id.ll_modle_2);
        bt_confirm.setOnClickListener(this);
        tv_choice_modle_1.setOnClickListener(this);
        tv_choice_modle_2.setOnClickListener(this);
        mTitlebar.setListener(this);
        tv_description = findViewById(R.id.tv_description);
        SpannableString     demoSpannable       = new SpannableString("凭自提码并携带本人以及患者身份证取件。");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#FF5B5B"));
        demoSpannable.setSpan(foregroundColorSpan, 0, 16, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        tv_description.setText(demoSpannable);


    }

    @Override
    public void onClicked(View v, int action, String extra) {
        if (action == CommonTitleBar.ACTION_LEFT_BUTTON) {
            finish();
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bt_confirm) {
            startActivityNoFinish(AddCaseHistoryCheckActivity.class);
        } else if (view.getId() == R.id.tv_choice_modle_1) {
            type=0;
            tv_choice_modle_1.setBackgroundResource(R.mipmap.case_choiced);
            tv_choice_modle_1.setTextColor(Color.parseColor("#00799F"));
            tv_choice_modle_2.setBackgroundResource(R.drawable.shape_choice_modle_normal);
            tv_choice_modle_2.setTextColor(Color.parseColor("#999999"));
            ll_modle_1.setVisibility(View.VISIBLE);
            ll_modle_2.setVisibility(View.GONE);
        } else if (view.getId() == R.id.tv_choice_modle_2) {
            type=1;
            tv_choice_modle_2.setBackgroundResource(R.mipmap.case_choiced);
            tv_choice_modle_2.setTextColor(Color.parseColor("#00799F"));
            tv_choice_modle_1.setBackgroundResource(R.drawable.shape_choice_modle_normal);
            tv_choice_modle_1.setTextColor(Color.parseColor("#999999"));
            ll_modle_2.setVisibility(View.VISIBLE);
            ll_modle_1.setVisibility(View.GONE);
        }
    }
}
