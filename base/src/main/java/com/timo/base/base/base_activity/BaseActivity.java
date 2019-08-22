package com.timo.base.base.base_activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;

import com.timo.base.R;
import com.timo.base.tools.permissions.PermissionUtils;
import com.timo.base.tools.permissions.permission_interface.BasePermissionInterface;
import com.timo.base.tools.permissions.permission_interface.PermissiOnGrantedListener;
import com.timo.base.tools.utils.RegexUtil;

/**
 * 预留：设置布局
 */

public abstract class BaseActivity extends SuperActivity implements BasePermissionInterface {
    private String tag_phone;

    @Override
    public void toGetPermissions(PermissiOnGrantedListener listener, @Size(min = 1) @NonNull String... perms) {
        setPermissionListener(listener);
        if (PermissionUtils.hasPermissions(this, perms)) {
            if (listener != null) {
                listener.onGranted();
            }
        } else {
            PermissionUtils.requestPermissions(this, getString(R.string.timo_permission_need_apply), perms);
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
    public void toOpenCallPhone(String phone) {
        if (TextUtils.isEmpty(phone) || !RegexUtil.getInstance().isTel(phone)) {
            showToast(getString(R.string.timo_error_please_edit_right_phone));
            return;
        }
        this.tag_phone = phone;
        if (PermissionUtils.hasPermissions(this, Manifest.permission.CALL_PHONE)) {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            startActivity(intent);
        } else {
            PermissionUtils.requestPermissions(this, "需要拨打电话权限", Manifest.permission.CALL_PHONE);
        }
    }

    @Override
    public void toOpenSendSms(String phone) {
        if (TextUtils.isEmpty(phone) || !RegexUtil.getInstance().isTel(phone)) {
            showToast(getString(R.string.timo_error_please_edit_right_phone));
            return;
        }
        this.tag_phone = phone;
        if (PermissionUtils.hasPermissions(this, Manifest.permission.SEND_SMS)) {
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + tag_phone));
            startActivity(intent);
        } else {
            PermissionUtils.requestPermissions(this, getString(R.string.timo_permission_sms), Manifest.permission.SEND_SMS);
        }
    }

    @Override
    public void toOpenStorage(PermissiOnGrantedListener grantedListener) {
        setPermissionListener(grantedListener);
        if (!PermissionUtils.hasPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            PermissionUtils.requestPermissions(this, getString(R.string.timo_permission_storage), Manifest.permission.WRITE_EXTERNAL_STORAGE);
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
            PermissionUtils.requestPermissions(this, getString(R.string.timo_permission_calendar), Manifest.permission.WRITE_CALENDAR);
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
            PermissionUtils.requestPermissions(this, getString(R.string.timo_permission_contacts), Manifest.permission.WRITE_CONTACTS);
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
            PermissionUtils.requestPermissions(this, getString(R.string.timo_permission_location), Manifest.permission.ACCESS_FINE_LOCATION);
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
            PermissionUtils.requestPermissions(this, getString(R.string.timo_permission_audio), Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE);
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
            PermissionUtils.requestPermissions(this, getString(R.string.timo_permission_sensors), Manifest.permission.BODY_SENSORS);
        } else {
            if (grantedListener != null) {
                grantedListener.onGranted();
            }
        }
    }
}
