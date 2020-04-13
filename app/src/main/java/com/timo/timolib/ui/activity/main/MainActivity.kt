package com.timo.timolib.ui.activity.main

import android.app.Activity
import android.view.View
import com.timo.timolib.R
import com.timo.timolib.mvp.MVPBaseActivity
import com.timo.timolib.ui.activity.case_history_copy.casehistory.CaseHistoryActivity
import com.timo.timolib.ui.activity.case_history_copy.identitychcek.IdentityChcekActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.content.ComponentName
import android.content.Intent
import com.timo.timolib.ui.activity.new_history_copy.addhistoryidcard.AddhistoryidcardActivity


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

class MainActivity : MVPBaseActivity<MainContract.View, MainPresenter>(), MainContract.View, View.OnClickListener {
    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.bt_case_history -> {
                val intent = Intent()
                intent.component = ComponentName("com.abc.iddecode", "com.abc.iddecode.MainActivity")
                startActivityForResult(intent, 1001)
            }
            R.id.bt_case_history -> {
                startActivityAddFinish(AddhistoryidcardActivity::class.java)
//                val intent = Intent()
//                intent.component = ComponentName("com.abc.iddecode", "com.abc.iddecode.MainActivity")
//                startActivityForResult(intent, 1001)
            }
        }
    }

    override fun getContentResId(): Int = R.layout.activity_main

    override fun initEvent() {
        bt_case_history.setOnClickListener(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1001) {
            if (resultCode == Activity.RESULT_OK) {
                tv_message.text = data!!.getStringExtra("id_info")
            } else if (resultCode == Activity.RESULT_CANCELED) {
                showToast("取消操作")
                tv_message.text = "点击了取消按钮"
            }
        }
    }
}
