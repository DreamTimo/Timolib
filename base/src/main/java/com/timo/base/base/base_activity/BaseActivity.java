package com.timo.base.base.base_activity;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.annotation.Size;

import com.timo.base.R;
import com.timo.base.tools.permissions.PermissionUtils;
import com.timo.base.tools.permissions.permission_interface.BasePermissionInterface;
import com.timo.base.tools.permissions.permission_interface.PermissiOnGrantedListener;

/**
 * 预留：设置布局
 */

public abstract class BaseActivity extends SuperActivity implements BasePermissionInterface {

    @Override
    public void toGetPermissions(PermissiOnGrantedListener listener, @Size(min = 1) @NonNull String... perms) {
        setPermissionListener(listener);
        if (PermissionUtils.hasPermissions(this, perms)) {
            if (listener != null) {
                listener.onGranted();
            }
        } else {
            PermissionUtils.requestPermissions(this, "缺少功能所需权限", perms);
        }
    }

    @Override
    public void toOpenCamera(PermissiOnGrantedListener listener) {
        setPermissionListener(listener);
        if (PermissionUtils.hasPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO, Manifest.permission.CAMERA)) {
            if (listener != null) {
                listener.onGranted();
            }
        } else {
            PermissionUtils.requestPermissions(this, getString(R.string.app_name), Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO, Manifest.permission.CAMERA);
        }
    }

    @Override
    public void toOpenStorage(PermissiOnGrantedListener grantedListener) {
        setPermissionListener(grantedListener);
        if (!PermissionUtils.hasPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            PermissionUtils.requestPermissions(this, "需要存储权限", Manifest.permission.WRITE_EXTERNAL_STORAGE);
        } else {
            if (grantedListener != null) {
                grantedListener.onGranted();
            }
        }
    }

    @Override
    public void toOpenCalendar(PermissiOnGrantedListener grantedListener) {
        setPermissionListener(grantedListener);
        if (!PermissionUtils.hasPermissions(this, Manifest.permission.WRITE_CALENDAR)) {
            PermissionUtils.requestPermissions(this, "需要日历权限", Manifest.permission.WRITE_CALENDAR);
        } else {
            if (grantedListener != null) {
                grantedListener.onGranted();
            }
        }
    }

    @Override
    public void toOpenContacts(PermissiOnGrantedListener grantedListener) {
        setPermissionListener(grantedListener);
        if (!PermissionUtils.hasPermissions(this, Manifest.permission.WRITE_CONTACTS)) {
            PermissionUtils.requestPermissions(this, "需要联系人权限", Manifest.permission.WRITE_CONTACTS);
        } else {
            if (grantedListener != null) {
                grantedListener.onGranted();
            }
        }
    }

    @Override
    public void toOpenLocation(PermissiOnGrantedListener grantedListener) {
        setPermissionListener(grantedListener);
        if (!PermissionUtils.hasPermissions(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            PermissionUtils.requestPermissions(this, "需要位置权限", Manifest.permission.ACCESS_FINE_LOCATION);
        } else {
            if (grantedListener != null) {
                grantedListener.onGranted();
            }
        }
    }

    @Override
    public void toOpenAudio(PermissiOnGrantedListener grantedListener) {
        setPermissionListener(grantedListener);
        if (!PermissionUtils.hasPermissions(this, Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            PermissionUtils.requestPermissions(this, "需要录音权限", Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        } else {
            if (grantedListener != null) {
                grantedListener.onGranted();
            }
        }
    }

    @Override
    public void toOpenSensors(PermissiOnGrantedListener grantedListener) {
        setPermissionListener(grantedListener);
        if (!PermissionUtils.hasPermissions(this, Manifest.permission.BODY_SENSORS)) {
            PermissionUtils.requestPermissions(this, "需要传感器权限", Manifest.permission.BODY_SENSORS);
        } else {
            if (grantedListener != null) {
                grantedListener.onGranted();
            }
        }
    }
}
