package com.timo.timolib.ui.activity.main

import com.timo.timolib.R
import com.timo.timolib.mvp.MVPBaseActivity


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

class MainActivity : MVPBaseActivity<MainContract.View, MainPresenter>(), MainContract.View {
    override fun getContentResId(): Int = R.layout.activity_main
    override fun initEvent() {
    }
}
