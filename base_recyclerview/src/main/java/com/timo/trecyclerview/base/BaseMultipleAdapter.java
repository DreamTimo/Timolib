/*
 *    Copyright (C) 2019  安讯达盛（北京）科技有限公司  htttp://www.aksofy.com
 *    File: BaseMultipleAdapter.java
 *    Current modification time: 2019年11月18日 11:40:36
 *    Last modified:2019年11月18日 11:38:11
 *    Author:2019 - 2020 gaoyanan
 *    Author:2019 - 2020 wangjun
 *    Email:aksofy18600030126@163.com
 *    Tell: 65842871
 */

/*
 */

/*
 */

/*
 */

package com.timo.trecyclerview.base;

import android.content.Context;
import android.view.LayoutInflater;


import java.util.List;

/**
 * Created by zhy on 16/4/9.
 */
public abstract class BaseMultipleAdapter<T> extends MultiItemTypeAdapter<T> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public BaseMultipleAdapter(final Context context, final int layoutId, List<T> datas) {
        super(context, datas);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;

        addItemViewDelegate(new ItemViewDelegate<T>() {
            @Override
            public int getItemViewLayoutId() {
                return layoutId;
            }

            @Override
            public boolean isForViewType(T item, int position) {
                return true;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position) {
                BaseMultipleAdapter.this.convert(holder, t, position);
            }
        });
    }

    protected abstract void convert(ViewHolder holder, T t, int position);

}
