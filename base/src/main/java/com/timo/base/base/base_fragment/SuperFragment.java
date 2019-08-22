package com.timo.base.base.base_fragment;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.timo.base.base.BaseConstancts;
import com.timo.base.tools.permissions.PermissionUtils;
import com.timo.base.tools.permissions.permission_interface.PermissiOnGrantedListener;

import java.io.Serializable;


/**
 * Created by lykj on 2017/9/10.
 */

public abstract class SuperFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentResId(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initEvent(view);
    }

    protected abstract int getContentResId();

    protected abstract void initEvent(View view);

    public void startActivityNoFinish(Class<?> cls) {
        startActivity(new Intent(getActivity().getApplicationContext(), cls));
    }

    public void startActivityNoFinish(Class<?> cls, Serializable params) {
        startActivity(new Intent(getActivity().getApplicationContext(), cls).putExtra(BaseConstancts.base_params, params));
    }

    public void startActivityNoFinish(Class<?> cls, String intentTag, String params) {
        startActivity(new Intent(getActivity().getApplicationContext(), cls).putExtra(intentTag, params));
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

    public void showToast(String toast) {
        Toast.makeText(getActivity(), toast, Toast.LENGTH_SHORT).show();
    }

    private PermissiOnGrantedListener mListener;

    public void setPermissionListener(PermissiOnGrantedListener listener) {
        mListener = listener;
    }

    private PermissiOnGrantedListener getPermissionlistener() {
        return mListener;
    }
}
