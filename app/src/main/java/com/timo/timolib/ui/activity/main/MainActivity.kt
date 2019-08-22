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
//        data = ArrayList()
//        data!!.add(Adapter_TestBean("111"))
//        data!!.add(Adapter_TestBean("222"))
//        data!!.add(Adapter_TestBean("333"))
//        data!!.add(Adapter_TestBean("444"))
//        data!!.add(Adapter_TestBean("444"))
//        data!!.add(Adapter_TestBean("444"))
//        data!!.add(Adapter_TestBean("444"))
//        data!!.add(Adapter_TestBean("444"))
//        data!!.add(Adapter_TestBean("444"))
//        data!!.add(Adapter_TestBean("444"))
//        data!!.add(Adapter_TestBean("444"))
//        data!!.add(Adapter_TestBean("444"))
//        data!!.add(Adapter_TestBean("444"))
//        data!!.add(Adapter_TestBean("444"))
//        data!!.add(Adapter_TestBean("444"))
//        data!!.add(Adapter_TestBean("444"))
//        data!!.add(Adapter_TestBean("444"))
//        data!!.add(Adapter_TestBean("444"))
//
//
//        xrc!!.setLoadingMoreEnabled(false)
//        xrc!!.setPullRefreshEnabled(false)
//        BaseAdapterTools.setRecyclerView(this, xrc, TestAdapter(this, R.layout.adapter_item_test, data))
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment, fragment!!)
        transaction.show(fragment!!)
        transaction.commitAllowingStateLoss()
    }
}
