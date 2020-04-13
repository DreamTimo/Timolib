package com.timo.timolib.ui.activity.case_history_copy.casehistory.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.timo.timolib.R;
import com.timo.timolib.bean.CaseHistoryBean;
import com.timo.trecyclerview.BaseAdapter;
import com.timo.trecyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by caiyongwang on 2020/4/1.
 */

public class CaseHistoryAdapter extends BaseAdapter<CaseHistoryBean> {
    public CaseHistoryAdapter(Context context, int layoutId, List<CaseHistoryBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, CaseHistoryBean data, int position) {

        if (TextUtils.isEmpty(data.getCode())) {
            holder.setText(R.id.tv_title, "申请流水号：");
        } else {
            holder.setText(R.id.tv_title, "申请流水号：" + data.getCode());
        }

        if (TextUtils.isEmpty(data.getStatus())) {
            holder.setText(R.id.tv_status, "");
        } else {
            holder.setText(R.id.tv_status, data.getStatus());
        }

        if (TextUtils.isEmpty(data.getContent())) {
            holder.setText(R.id.tv_content, "");
        } else {
            holder.setText(R.id.tv_content, data.getContent());
        }
        if (TextUtils.isEmpty(data.getCount())) {
            holder.setText(R.id.tv_count, "");
        } else {
            holder.setText(R.id.tv_count, data.getCount());
        }
        if (TextUtils.isEmpty(data.getData())) {
            holder.setText(R.id.tv_date, "");
        } else {
            holder.setText(R.id.tv_date, data.getData());
        }

        holder.setOnClickListener(R.id.bt_confirm, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("支付");
            }
        });
    }
}
