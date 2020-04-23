package com.timo.timolib.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.timo.timolib.R;
import com.timo.timolib.inter.OnPayPassClickListener;
import com.timo.timolib.mvp.BasePresenterImpl;
import com.timo.timolib.view.pin.PayPassDialog;
import com.timo.timolib.view.pin.PayPassView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MainPresenter extends BasePresenterImpl<MainContract.View> implements MainContract.Presenter{
    @Override
    public void passJson() {

    }

    @Override
    public void showDialog() {
        final PayPassDialog dialog = new PayPassDialog(mView.getContext(), R.style.loading_dialog);
        //弹框自定义配置
        dialog.setAlertDialog(false)
                .setWindowSize(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0)
                .setOutColse(false)
                .setGravity(R.style.dialogOpenAnimation, Gravity.BOTTOM);
        //组合控件自定义配置
        PayPassView payView = dialog.getPayViewPass();
        payView.setPayClickListener(new OnPayPassClickListener() {
            @Override
            public void onKeyDown(String passContent) {
                //6位输入完成回调
                dialog.dismiss();
                Log.e("timo",passContent);
            }

            @Override
            public void onPayClose() {
                dialog.dismiss();
            }

            @Override
            public void onDelete() {
                Log.e("timo","delete");
            }
        });
    }
}
