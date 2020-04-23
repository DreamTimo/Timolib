package com.timo.timolib.utils;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.timo.timolib.R;
import com.timo.timolib.inter.OnPayPassClickListener;
import com.timo.timolib.view.pin.PayPassDialog;
import com.timo.timolib.view.pin.PayPassView;

public class DialogUtils {
    public static void showIdentityDialog(Context context, OnPayPassClickListener listener) {
        final PayPassDialog dialog = new PayPassDialog(context);
        //弹框自定义配置
//        dialog.setAlertDialog(false)
//                .setWindowSize(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0)
//                .setOutColse(false)
//                .setGravity(R.style.dialogOpenAnimation, Gravity.BOTTOM);
        //组合控件自定义配置
        PayPassView payView = dialog.getPayViewPass();
        payView.setPayClickListener(listener);
    }
}
