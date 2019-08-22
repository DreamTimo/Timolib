package com.timo.timolib.ui.fragment;

import android.Manifest;
import android.view.View;

import com.timo.base.base.base_fragment.BaseFragment;
import com.timo.base.tools.permissions.permission_interface.PermissiOnGrantedListener;
import com.timo.timolib.R;

/**
 * Created by 蔡永汪 on 2019/8/22.
 */

public class TestFragment extends BaseFragment {
    @Override
    protected int getContentResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEvent(View view) {
        toGetPermissions(new PermissiOnGrantedListener() {
            @Override
            public void onGranted() {
                showToast("通过");
            }

            @Override
            public void onDenied() {
                showToast("失败");
            }
        }, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE);
    }
}
