package com.timo.timolib;

import android.app.Application;

import com.timo.base.BaseTools;

/**
 * Created by 蔡永汪 on 2019/8/9.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BaseTools.init(this, true, "timo");
    }
}
