package com.timo.timolib.ui.activity.main.adapter;

import android.content.Context;

import com.timo.timolib.R;
import com.timo.timolib.bean.Adapter_TestBean;
import com.timo.trecyclerview.BaseAdapter;
import com.timo.trecyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by 蔡永汪 on 2019/8/22.
 */

public class TestAdapter extends BaseAdapter<Adapter_TestBean> {
    public TestAdapter(Context context, int layoutId, List<Adapter_TestBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, Adapter_TestBean adapter_testBean, int position) {
        holder.setText(R.id.test,adapter_testBean.getName());
    }
}
