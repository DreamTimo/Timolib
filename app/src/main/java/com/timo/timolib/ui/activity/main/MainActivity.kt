package com.timo.timolib.ui.activity.main

import com.timo.timolib.R
import com.timo.timolib.bean.Adapter_TestBean
import com.timo.timolib.mvp.MVPBaseActivity
import com.timo.timolib.ui.fragment.TestFragment


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

class MainActivity : MVPBaseActivity<MainContract.View, MainPresenter>(), MainContract.View {
    var data: ArrayList<Adapter_TestBean>? = null
    override fun getContentResId(): Int = R.layout.activity_main
    var fragment: TestFragment? = TestFragment()
    override fun initEvent() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment, fragment!!)
        transaction.show(fragment!!)
        transaction.commitAllowingStateLoss()
    }
}
