/*
 *    Copyright (C) 2019  安讯达盛（北京）科技有限公司  htttp://www.aksofy.com
 *    File: BaseAdapterTools.java
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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by  on 2019/8/22.
 */

public class BaseAdapterTools {
    private BaseAdapterTools() {
    }

    public static void setRecyclerView(Context context, RecyclerView recyclerView, BaseAdapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public static void setRecyclerView(Context context, RecyclerView recyclerView, boolean vertical, BaseAdapter adapter) {
        if (vertical) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
        } else {
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(layoutManager);
        }
        recyclerView.setAdapter(adapter);
    }
}
