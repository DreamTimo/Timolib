package com.timo.timolib.ui.activity.case_history_copy.addcasehistory_1;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.bigkoo.pickerview.lib.WheelView;
import com.timo.timolib.R;
import com.timo.timolib.inter.OnPopupConfirmListener;
import com.timo.timolib.mvp.MVPBaseActivity;
import com.timo.timolib.ui.activity.case_history_copy.addcasehistory_2.AddCaseHistory_2Activity;
import com.timo.timolib.utils.PopupUtils;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class AddCaseHistory_1Activity extends MVPBaseActivity<AddCaseHistory_1Contract.View, AddCaseHistory_1Presenter> implements AddCaseHistory_1Contract.View, CommonTitleBar.OnTitleBarListener, View.OnClickListener {
    private CommonTitleBar mTitlebar;
    private Button         bt_confirm;
    private RelativeLayout rl_check;
    private TextView       tv_check_name;
    private List<String> data = new LinkedList<>(Arrays.asList("本人", "委托人"));
    private String posi_check;

    @Override
    protected int getContentResId() {
        return R.layout.activity_add_case_history_1;
    }

    @Override
    protected void initEvent() {
        mTitlebar = findViewById(R.id.titlebar);
        bt_confirm = findViewById(R.id.bt_confirm);
        rl_check = findViewById(R.id.rl_check);
        tv_check_name = findViewById(R.id.tv_check_name);
        mTitlebar.setListener(this);
        bt_confirm.setOnClickListener(this);
        rl_check.setOnClickListener(this);
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
            if (TextUtils.isEmpty(posi_check)) {
                showToast("请选择与就诊人关系");
                return;
            }
            startActivityNoFinish(AddCaseHistory_2Activity.class,posi_check);
        } else if (view.getId() == R.id.rl_check) {
            PopupUtils.show(this, rl_check, data, new OnPopupConfirmListener() {
                @Override
                public void onConfirm(int position) {
                    posi_check = position + "";
                    tv_check_name.setText(data.get(position));
                }
            });
        }
    }


}
