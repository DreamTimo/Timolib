package com.timo.timolib.ui.activity.case_history_copy.identitychcek


import com.timo.timolib.R
import com.timo.timolib.bean.Fruit
import com.timo.timolib.mvp.MVPBaseActivity
import com.timo.timolib.utils.DensityUtil
import kotlinx.android.synthetic.main.activity_identity_check.*


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

class IdentityChcekActivity : MVPBaseActivity<IdentityChcekContract.View, IdentityChcekPresenter>(), IdentityChcekContract.View {
    private var data: ArrayList<Fruit>? = null

    override fun getContentResId(): Int {
        return R.layout.activity_identity_check
    }

    override fun initEvent() {
        data = java.util.ArrayList<Fruit>()
        for (i in 0..4) {
            data!!.add(Fruit("苹果" + i, 5))
            data!!.add(Fruit("香蕉" + i, 6))
            data!!.add(Fruit("橘子" + i, 7))
            data!!.add(Fruit("火龙果" + i, 8))
            data!!.add(Fruit("西瓜" + i, 9))
            data!!.add(Fruit("猕猴桃" + i, 10))
            data!!.add(Fruit("芒果" + i, 11))
            data!!.add(Fruit("猕猴桃" + i, 12))
        }
        pop_check.init(data!!.size, DensityUtil.dip2px(this, 180F)) { position -> data!![position].name }
    }
}
