/*
 *    Copyright (C) 2019  安讯达盛（北京）科技有限公司  htttp://www.aksofy.com
 *    File: BaseAdapter.java
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

package com.timo.trecyclerview;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.Toast;


import com.timo.trecyclerview.base.ItemViewDelegate;
import com.timo.trecyclerview.base.MultiItemTypeAdapter;
import com.timo.trecyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by zhy on 16/4/9.
 */
public abstract class BaseAdapter<T> extends MultiItemTypeAdapter<T> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    protected int mHeight;
    protected String mParams;
    protected int mType;


    public BaseAdapter(final Context context, final int layoutId, List<T> datas) {
        super(context, datas);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;

        addItemViewDelegate(1, new ItemViewDelegate<T>() {
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
                BaseAdapter.this.convert(holder, t, position);
            }
        });
    }
    public BaseAdapter(final Context context, final int layoutId, List<T> datas,final String params) {
        super(context, datas);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
        mParams = params;
        addItemViewDelegate(1, new ItemViewDelegate<T>() {
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
                BaseAdapter.this.convert(holder, t, position);
            }
        });
    }
    public BaseAdapter(final Context context, final int layoutId, List<T> datas,final String params,int type) {
        super(context, datas);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
        mParams = params;
        mType = type;
        addItemViewDelegate(1, new ItemViewDelegate<T>() {
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
                BaseAdapter.this.convert(holder, t, position);
            }
        });
    }
    public BaseAdapter(final Context context, final int layoutId, List<T> datas,final int height) {
        super(context, datas);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
        mHeight = height;
        addItemViewDelegate(1, new ItemViewDelegate<T>() {
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
                BaseAdapter.this.convert(holder, t, position);
            }
        });
    }
    protected abstract void convert(ViewHolder holder, T t, int position);
    public void showToast(String message) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }
}
