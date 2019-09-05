package com.timo.timolib.ui.fragment

import android.Manifest
import android.view.View

import com.eidlink.identitysdk.IdentityManager
import com.eidlink.identitysdk.bean.ResultBean
import com.eidlink.identitysdk.bean.ResultErrorBean
import com.eidlink.identitysdk.inter.OnGetResultListener
import com.timo.base.base.base_fragment.BaseFragment
import com.timo.base.tools.permissions.permission_interface.PermissiOnGrantedListener
import com.timo.timolib.R
import kotlinx.android.synthetic.main.fragment_test.*

/**
 * Created by 蔡永汪 on 2019/8/22.
 */

class TestFragment : BaseFragment() {
    override fun getContentResId(): Int {
        return R.layout.fragment_test
    }

    private val appid = "10SJ1908011315132187"

    override fun initEvent(view: View) {
        tv_nfc.setOnClickListener({
            toGetPermissions(object : PermissiOnGrantedListener {
                override fun onGranted() {
                    IdentityManager.start(activity, "11111111111111", appid, object : OnGetResultListener {
                        override fun onSuccess(data: ResultBean) {
                            showToast("人证合一成功")
                            tv_message.setText(data.toString())
                        }

                        override fun onFailed(errorData: ResultErrorBean) {
                            tv_message.setText(errorData.toString())
                        }
                    })
                }

                override fun onDenied() {
                    showToast("失败")
                }
            }, Manifest.permission.NFC, Manifest.permission.BLUETOOTH, Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO, Manifest.permission.CAMERA)
        })
    }
}
