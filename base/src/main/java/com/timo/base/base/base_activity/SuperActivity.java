package com.timo.base.base.base_activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.timo.base.base.BaseConstancts;
import com.timo.base.tools.permissions.PermissionUtils;
import com.timo.base.tools.permissions.permission_interface.PermissiOnGrantedListener;
import com.timo.base.tools.StatusBarCompat;

import java.io.Serializable;

/**
 * activity基础类：一般不做变动
 */

public abstract class SuperActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        StatusBarCompat.translucentStatusBar(this);
        setContentView(getContentResId());
        initEvent();
        initEvent(savedInstanceState);
        if (!this.isTaskRoot()) { //判断该Activity是不是任务空间的源Activity，“非”也就是说是被系统重新实例化出来
            //如果你就放在launcher Activity中话，这里可以直接return了
            Intent mainIntent = getIntent();
            String action     = mainIntent.getAction();
            if (mainIntent.hasCategory(Intent.CATEGORY_LAUNCHER) && action.equals(Intent.ACTION_MAIN)) {
                finish();
                return;//finish()之后该活动会继续执行后面的代码，你可以logCat验证，加return避免可能的exception
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    protected abstract int getContentResId();

    protected abstract void initEvent();

    protected void initEvent(Bundle savedInstanceState) {
    }

    public void startActivityNoFinish(Class<?> cls) {
        startActivity(new Intent(getApplicationContext(), cls));
    }

    public void startActivityNoFinish(Class<?> cls, Serializable params) {
        startActivity(new Intent(getApplicationContext(), cls).putExtra(BaseConstancts.base_params, params));
    }

    public void startActivityAddFinish(Class<?> cls) {
        startActivity(new Intent(getApplicationContext(), cls));
        finish();
    }

    public void startActivityAddFinish(Class<?> cls, Serializable params) {
        startActivity(new Intent(getApplicationContext(), cls).putExtra(BaseConstancts.base_params, params));
        finish();
    }


    /**
     * 返回键监听，主页退出监听
     *
     * @param keyCode
     * @param event
     * @return
     */
    private long mExitTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && isMain()) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                if ((System.currentTimeMillis() - mExitTime) > BaseConstancts.exit_time) {
                    showToast("再按一次，退出程序");
                    mExitTime = System.currentTimeMillis();
                } else {
                    if (BaseConstancts.exit_to_back) {
                        moveTaskToBack(false);
                    } else {
                        stopAndFinish();
                    }
                }
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 停止程序
     */
    protected void stopAndFinish() {
        finish();
        Process.killProcess(Process.myPid());
        System.exit(0);
    }

    /**
     * 判断是否是首页
     */
    protected boolean isMain() {
        return false;
    }

    public void showToast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

    /**
     * 请求权限的返回值：不操作
     */
    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionUtils.onRequestPermissionsResult(getPermissionlistener(), permissions, grantResults);
    }

    private PermissiOnGrantedListener mListener;

    public void setPermissionListener(PermissiOnGrantedListener listener) {
        mListener = listener;
    }

    private PermissiOnGrantedListener getPermissionlistener() {
        return mListener;
    }
}
