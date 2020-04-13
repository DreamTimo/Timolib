package com.timo.timolib.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.bigkoo.pickerview.lib.WheelView;
import com.timo.timolib.R;
import com.timo.timolib.inter.OnPopupConfirmListener;

import java.util.List;

/**
 * Created by caiyongwang on 2020/4/1.
 */

public class PopupUtils {
    public static void show(Context context, View root, final List<String> data, final OnPopupConfirmListener listener) {
        // 用于PopupWindow的View
        View            contentView = LayoutInflater.from(context).inflate(R.layout.layout_popup, null, false);
        final WheelView wheelView   = contentView.findViewById(R.id.wheelView);

        wheelView.setAdapter(new ArrayWheelAdapter(data));

        wheelView.setCyclic(false);
        wheelView.setCurrentItem(0);
        wheelView.setLineSpacingMultiplier(10);
        // 创建PopupWindow对象，其中：
        // 第一个参数是用于PopupWindow中的View，第二个参数是PopupWindow的宽度，
        // 第三个参数是PopupWindow的高度，第四个参数指定PopupWindow能否获得焦点
        final PopupWindow window = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        // 设置PopupWindow的背景
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // 设置PopupWindow是否能响应外部点击事件
        window.setOutsideTouchable(true);
        // 设置PopupWindow是否能响应点击事件
        window.setTouchable(true);
        // 显示PopupWindow，其中：
        // 第一个参数是PopupWindow的锚点，第二和第三个参数分别是PopupWindow相对锚点的x、y偏移
//        window.showAsDropDown(btn1);
        // 或者也可以调用此方法显示PopupWindow，其中：
        // 第一个参数是PopupWindow的父View，第二个参数是PopupWindow相对父View的位置，
        // 第三和第四个参数分别是PopupWindow相对父View的x、y偏移
//        window.showAtLocation(btn1, Gravity.BOTTOM, 0, 0);
        contentView.findViewById(R.id.tv_patientdetailcancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
            }
        });
        contentView.findViewById(R.id.tv_patientdetailsure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onConfirm(wheelView.getCurrentItem());
                window.dismiss();
            }
        });
        window.showAtLocation(root, Gravity.CENTER, 0, 0);
    }
}
