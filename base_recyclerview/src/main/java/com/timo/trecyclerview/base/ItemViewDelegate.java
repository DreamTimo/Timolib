/*
 *    Copyright (C) 2019  安讯达盛（北京）科技有限公司  htttp://www.aksofy.com
 *    File: ItemViewDelegate.java
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

/**
 * Created by zhy on 16/6/22.
 */
public interface ItemViewDelegate<T> {

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(ViewHolder holder, T t, int position);

}
