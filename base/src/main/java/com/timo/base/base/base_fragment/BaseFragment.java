package com.timo.base.base.base_fragment;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.annotation.Size;

import com.timo.base.R;
import com.timo.base.tools.permissions.PermissionUtils;
import com.timo.base.tools.permissions.permission_interface.BasePermissionInterface;
import com.timo.base.tools.permissions.permission_interface.PermissiOnGrantedListener;

/**
 * Created by 45590 on 2018/7/13.
 */

public abstract class BaseFragment extends SuperFragment implements BasePermissionInterface {
    private String tag_phone;

    @Override
    public void toGetPermissions(PermissiOnGrantedListener listener, @Size(min = 1) @NonNull String... perms) {
        setPermissionListener(listener);
        if (PermissionUtils.hasPermissions(getActivity(), perms)) {
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
        if (PermissionUtils.hasPermissions(getActivity(), Manifest.permission.CAMERA)) {
            if (listener != null) {
                listener.onGranted();
            }
        } else {
            PermissionUtils.requestPermissions(this, getString(R.string.app_name), Manifest.permission.CAMERA);
        }
    }

    @Override
    public void toOpenStorage(PermissiOnGrantedListener grantedListener) {
        if (!PermissionUtils.hasPermissions(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            PermissionUtils.requestPermissions(this, "需要存储权限", Manifest.permission.WRITE_EXTERNAL_STORAGE);
        } else {
            if (grantedListener != null) {
                grantedListener.onGranted();
            }
        }
    }

    @Override
    public void toOpenCalendar(PermissiOnGrantedListener grantedListener) {
        if (!PermissionUtils.hasPermissions(getActivity(), Manifest.permission.WRITE_CALENDAR)) {
            PermissionUtils.requestPermissions(this, "需要日历权限", Manifest.permission.WRITE_CALENDAR);
        } else {
            if (grantedListener != null) {
                grantedListener.onGranted();
            }
        }
    }

    @Override
    public void toOpenContacts(PermissiOnGrantedListener grantedListener) {
        if (!PermissionUtils.hasPermissions(getActivity(), Manifest.permission.WRITE_CONTACTS)) {
            PermissionUtils.requestPermissions(this,"需要联系人权限", Manifest.permission.WRITE_CONTACTS);
        } else {
            if (grantedListener != null) {
                grantedListener.onGranted();
            }
        }
    }

    @Override
    public void toOpenLocation(PermissiOnGrantedListener grantedListener) {
        if (!PermissionUtils.hasPermissions(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)) {
            PermissionUtils.requestPermissions(this,"需要位置权限", Manifest.permission.ACCESS_FINE_LOCATION);
        } else {
            if (grantedListener != null) {
                grantedListener.onGranted();
            }
        }
    }

    @Override
    public void toOpenAudio(PermissiOnGrantedListener grantedListener) {
        if (!PermissionUtils.hasPermissions(getActivity(), Manifest.permission.RECORD_AUDIO)) {
            PermissionUtils.requestPermissions(this, "需要录音权限", Manifest.permission.RECORD_AUDIO);
        } else {
            if (grantedListener != null) {
                grantedListener.onGranted();
            }
        }
    }

    @Override
    public void toOpenSensors(PermissiOnGrantedListener grantedListener) {
        if (!PermissionUtils.hasPermissions(getActivity(), Manifest.permission.BODY_SENSORS)) {
            PermissionUtils.requestPermissions(this,"需要传感器权限", Manifest.permission.BODY_SENSORS);
        } else {
            if (grantedListener != null) {
                grantedListener.onGranted();
            }
        }
    }
}
