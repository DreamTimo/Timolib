package com.timo.base.tools.permissions.permission_interface;

import android.support.annotation.NonNull;
import android.support.annotation.Size;

/**
 * Created by 45590 on 2018/7/13.
 */

public interface BasePermissionInterface {
    /**
     * 基类方法定义接口
     */
    void toGetPermissions(PermissiOnGrantedListener listener, @Size(min = 1) @NonNull String... perms);
    /**
     * 打开相机
     */
    void toOpenCamera(PermissiOnGrantedListener listener);

    /**
     * 打电话
     *
     * @param phone
     */
    void toOpenCallPhone(String phone);

    /**
     * 发短信
     *
     * @param phone
     */
    void toOpenSendSms(String phone);

    /**
     * 打开外置sd卡权限
     */
    void toOpenStorage(PermissiOnGrantedListener listener);

    /**
     * 查看日历权限
     */
    void toOpenCalendar(PermissiOnGrantedListener listener);

    /**
     * 打开联系人权限
     */
    void toOpenContacts(PermissiOnGrantedListener listener);

    /**
     * 打开获取位置权限
     */
    void toOpenLocation(PermissiOnGrantedListener listener);

    /**
     * 打开获取声音的权限
     */
    void toOpenAudio(PermissiOnGrantedListener listener);

    /**
     * 打开获取传感器权限
     */
    void toOpenSensors(PermissiOnGrantedListener listener);
}
