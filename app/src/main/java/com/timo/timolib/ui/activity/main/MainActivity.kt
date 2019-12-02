package com.timo.timolib.ui.activity.main

import com.eidlink.facesilent.FaceSdkManager
import com.eidlink.facesilent.inter.OnGetResultListener
import com.timo.timolib.R
import com.timo.timolib.mvp.MVPBaseActivity


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

class MainActivity : MVPBaseActivity<MainContract.View, MainPresenter>(), MainContract.View {
    override fun getContentResId(): Int = R.layout.activity_main
    override fun initEvent() {
        FaceSdkManager.start(this, object : OnGetResultListener {
            override fun onSuccess(p0: String?) {
                showToast(p0)
            }

            override fun onFailed(p0: String?, p1: String?) {
                showToast(p0)
            }
        })
    }
}
