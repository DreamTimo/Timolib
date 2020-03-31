package com.timo.timolib.ui.activity.main

import android.view.View
import com.timo.timolib.R
import com.timo.timolib.mvp.MVPBaseActivity
import com.timo.timolib.ui.activity.case_history_copy.identitychcek.IdentityChcekActivity
import kotlinx.android.synthetic.main.activity_main.*


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

class MainActivity : MVPBaseActivity<MainContract.View, MainPresenter>(), MainContract.View, View.OnClickListener {
    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.bt_case_history->{
                startActivityNoFinish(IdentityChcekActivity::class.java)
            }
        }
    }

    override fun getContentResId(): Int = R.layout.activity_main
    override fun initEvent() {
        bt_case_history.setOnClickListener(this)
    }
}
