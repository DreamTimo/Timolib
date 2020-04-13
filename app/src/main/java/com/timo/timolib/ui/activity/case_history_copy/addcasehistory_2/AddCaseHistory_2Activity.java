package com.timo.timolib.ui.activity.case_history_copy.addcasehistory_2;


import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.timo.base.base.BaseConstancts;
import com.timo.timolib.R;
import com.timo.timolib.inter.OnPopupConfirmListener;
import com.timo.timolib.mvp.MVPBaseActivity;
import com.timo.timolib.ui.activity.case_history_copy.addcasehistory_3.AddCaseHistory_3Activity;
import com.timo.timolib.utils.PopupUtils;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class AddCaseHistory_2Activity extends MVPBaseActivity<AddCaseHistory_2Contract.View, AddCaseHistory_2Presenter> implements AddCaseHistory_2Contract.View, View.OnClickListener, CommonTitleBar.OnTitleBarListener {
    private String         type;//0:代表本人 1代表委托人
    private CommonTitleBar mTitlebar;
    private TextView     tv_download;
    private TextView     add_case;
    private TextView     tv_choice_count;
    private Button       bt_confirm;
    private LinearLayout ll_type;
    private String       posi_check;
    private List<String> data = new LinkedList<>(Arrays.asList("1份", "2份", "3份", "4份", "5份"));

    @Override
    protected int getContentResId() {
        return R.layout.activity_add_case_history_2;
    }

    @Override
    protected void initEvent() {
        type = getIntent().getStringExtra(BaseConstancts.base_params);
        mTitlebar = findViewById(R.id.titlebar);
        ll_type=findViewById(R.id.ll_type);
        tv_choice_count=findViewById(R.id.tv_choice_count);
        add_case=findViewById(R.id.add_case);
        bt_confirm=findViewById(R.id.bt_confirm);
        mTitlebar.setListener(this);
        tv_choice_count.setOnClickListener(this);
        add_case.setOnClickListener(this);
        bt_confirm.setOnClickListener(this);
        if (type.equals("0")){
            ll_type.setVisibility(View.GONE);
        }else {
            ll_type.setVisibility(View.VISIBLE);
        }
        tv_download=findViewById(R.id.tv_download);
        SpannableString     demoSpannable        = new SpannableString("点击下载《委托书模版》打印后手工签字拍照上传，或依模版格式内容自行书写拍照上传。");
        ForegroundColorSpan foregroundColorSpan  = new ForegroundColorSpan(Color.parseColor("#FF5B5B"));
        ClickableSpan clickDemoSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                showToast("委托书下载");
            }
        };
        demoSpannable.setSpan(foregroundColorSpan, 4, 11, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        demoSpannable.setSpan(clickDemoSpan, 4, 11, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        tv_download.setText(demoSpannable);
        tv_download.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.tv_choice_count){
            PopupUtils.show(this, tv_choice_count, data, new OnPopupConfirmListener() {
                @Override
                public void onConfirm(int position) {
                    posi_check = position + "";
                    tv_choice_count.setText(data.get(position));
                }
            });
        }else if (view.getId()==R.id.bt_confirm){
            if (TextUtils.isEmpty(posi_check)){
                showToast("请选择复印份数");
                return;
            }
            startActivityNoFinish(AddCaseHistory_3Activity.class);

        }else if (view.getId()==R.id.add_case){
            showToast("添加病历");
        }
    }

    @Override
    public void onClicked(View v, int action, String extra) {
        if (action == CommonTitleBar.ACTION_LEFT_BUTTON) {
            finish();
        }
    }
}
