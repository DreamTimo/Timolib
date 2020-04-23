package com.timo.timolib.ui.activity.main

import android.util.Log
import android.view.View
import com.timo.timolib.R
import com.timo.timolib.inter.OnPayPassClickListener
import com.timo.timolib.mvp.MVPBaseActivity
import com.timo.timolib.view.pin.PayPassDialog
import kotlinx.android.synthetic.main.activity_main.*


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

class MainActivity : MVPBaseActivity<MainContract.View, MainPresenter>(), MainContract.View, View.OnClickListener {
    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.ll_edit -> {
                var dialog = PayPassDialog(context)
                dialog.setListener(object : OnPayPassClickListener {
                    override fun onKeyDown(key: String?) {
                        if (data!!.size < 5 && key == "X") {
                            return
                        }

                        if (data!!.size < 6) {
                            data!!.add(key!!)
                        }
                        setKey()
                        if (data!!.size >= 6) {
                            dialog.dismiss()
                            var sb = StringBuffer()
                            data!!.forEach { a ->
                                sb.append(a)
                            }
                            showToast("获取结果：" + sb.toString())
                        }
                    }

                    override fun onDelete() {
                        if (data!!.size >= 1) {
                            data!!.removeAt(data!!.size - 1)
                        }
                        setKey()
                    }

                    override fun onPayClose() {
                        dialog.dismiss()
                    }
                })
            }
        }
    }

    private fun setKey() {
        tv_1.text = ""
        tv_2.text = ""
        tv_3.text = ""
        tv_4.text = ""
        tv_5.text = ""
        tv_6.text = ""
        data!!.forEachIndexed { position, data ->
            when (position) {
                0 -> {
                    tv_1.text = data
                }
                1 -> {
                    tv_2.text = data
                }
                2 -> {
                    tv_3.text = data
                }
                3 -> {
                    tv_4.text = data
                }
                4 -> {
                    tv_5.text = data
                }
                5 -> {
                    tv_6.text = data
                }
            }
        }
    }

    override fun getContentResId(): Int = R.layout.activity_main
    var data: ArrayList<String>? = ArrayList()
    override fun initEvent() {
        ll_edit.setOnClickListener(this)
    }
}
