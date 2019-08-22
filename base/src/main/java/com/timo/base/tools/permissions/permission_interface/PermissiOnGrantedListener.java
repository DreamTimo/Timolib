package com.timo.base.tools.permissions.permission_interface;

/**
 * Created by 45590 on 2018/7/13.
 */

public interface PermissiOnGrantedListener {
    /**
     * 权限申请通过的回调
     */
    void onGranted();

    void onDenied();
}
