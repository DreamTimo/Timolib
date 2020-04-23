package com.timo.timolib;

import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;

import com.timo.base.base.base_activity.BaseActivity;
import com.timo.timolib.inter.MyEdittextChangeListener;

/**
 * 检查报告-身份验证
 */
public class IdAuthonActivity extends BaseActivity {
    private EditText et1, et2, et3, et4, et5, et6;

    @Override
    protected int getContentResId() {
        return R.layout.activity_id_authon;
    }

    @Override
    protected void initEvent() {
        et1 = findViewById(R.id.et_1);
        et2 = findViewById(R.id.et_2);
        et3 = findViewById(R.id.et_3);
        et4 = findViewById(R.id.et_4);
        et5 = findViewById(R.id.et_5);
        et6 = findViewById(R.id.et_6);
        et2.setEnabled(false);
        et3.setEnabled(false);
        et4.setEnabled(false);
        et5.setEnabled(false);
        et6.setEnabled(false);
        initEditTex();
    }

    private void initEditTex() {
        et1.addTextChangedListener(new MyEdittextChangeListener() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    //0代表删除操作
                    setEnable(1);
                    log("1+1");
                } else if (charSequence.length() == 1) {
                    //1代表填写
                    log("1+2");
                    setEnable(2);
                }
            }
        });
        et2.addTextChangedListener(new MyEdittextChangeListener() {
            @Override
            public void onTextChanged(CharSequence editable, int i, int i1, int i2) {
                if (editable.length() == 0) {
                    //0代表删除操作
                    setEnable(1);
                    log("2+1");
                } else if (editable.length() == 1) {
                    //1代表填写
                    log("2+3");
                    setEnable(3);
                }
            }
        });
        et3.addTextChangedListener(new MyEdittextChangeListener() {
            @Override
            public void onTextChanged(CharSequence editable, int i, int i1, int i2) {
                if (editable.length() == 0) {
                    //0代表删除操作
                    log("3+2");
                    setEnable(2);
                } else if (editable.length() == 1) {
                    //1代表填写
                    setEnable(4);
                    log("3+4");
                }
            }
        });
        et4.addTextChangedListener(new MyEdittextChangeListener() {
            @Override
            public void onTextChanged(CharSequence editable, int i, int i1, int i2) {
                if (editable.length() == 0) {
                    //0代表删除操作
                    setEnable(3);
                    log("4+3");
                } else if (editable.length() == 1) {
                    //1代表填写
                    setEnable(5);
                    log("4+5");
                }
            }
        });
        et5.addTextChangedListener(new MyEdittextChangeListener() {
            @Override
            public void onTextChanged(CharSequence editable, int i, int i1, int i2) {
                if (editable.length() == 0) {
                    //0代表删除操作
                    setEnable(4);
                    log("5+4");
                } else if (editable.length() == 1) {
                    //1代表填写
                    setEnable(6);
                    log("5+6");
                }
            }
        });
        et6.addTextChangedListener(new MyEdittextChangeListener() {
            @Override
            public void onTextChanged(CharSequence editable, int i, int i1, int i2) {
                if (editable.length() == 1) {
                    showToast("1111111111111");
                    log("1111111111");
                }
            }
        });

    }

    public void log(String key) {
        if (!TextUtils.isEmpty(key)) {
            Log.e("timo", key);
        }
    }

    private void setEnable(int type) {
        if (type == 1) {
            et1.setFocusable(true);
            et1.setEnabled(true);
            et1.requestFocus();
            et1.setFocusableInTouchMode(true);

            et2.setFocusable(false);
            et2.setEnabled(false);

            et3.setFocusable(false);
            et3.setEnabled(false);

            et4.setFocusable(false);
            et4.setEnabled(false);

            et5.setFocusable(false);
            et5.setEnabled(false);

            et6.setFocusable(false);
            et6.setEnabled(false);
        } else if (type == 2) {
            et2.setFocusable(true);
            et2.setEnabled(true);
            et2.requestFocus();
            et2.setFocusableInTouchMode(true);

            et1.setFocusable(false);
            et1.setEnabled(false);

            et3.setFocusable(false);
            et3.setEnabled(false);

            et4.setFocusable(false);
            et4.setEnabled(false);

            et5.setFocusable(false);
            et5.setEnabled(false);

            et6.setFocusable(false);
            et6.setEnabled(false);
        } else if (type == 3) {
            et3.setFocusable(true);
            et3.setEnabled(true);
            et3.requestFocus();
            et3.setFocusableInTouchMode(true);

            et2.setFocusable(false);
            et2.setEnabled(false);

            et1.setFocusable(false);
            et1.setEnabled(false);

            et4.setFocusable(false);
            et4.setEnabled(false);

            et5.setFocusable(false);
            et5.setEnabled(false);

            et6.setFocusable(false);
            et6.setEnabled(false);
        } else if (type == 4) {
            et4.setFocusable(true);
            et4.setEnabled(true);
            et4.requestFocus();
            et4.setFocusableInTouchMode(true);

            et2.setFocusable(false);
            et2.setEnabled(false);

            et3.setFocusable(false);
            et3.setEnabled(false);

            et1.setFocusable(false);
            et1.setEnabled(false);

            et5.setFocusable(false);
            et5.setEnabled(false);

            et6.setFocusable(false);
            et6.setEnabled(false);
        } else if (type == 5) {
            et5.setFocusable(true);
            et5.setEnabled(true);
            et5.requestFocus();
            et5.setFocusableInTouchMode(true);

            et2.setFocusable(false);
            et2.setEnabled(false);

            et3.setFocusable(false);
            et3.setEnabled(false);

            et4.setFocusable(false);
            et4.setEnabled(false);

            et1.setFocusable(false);
            et1.setEnabled(false);

            et6.setFocusable(false);
            et6.setEnabled(false);
        } else if (type == 6) {
            et6.setFocusable(true);
            et6.setEnabled(true);
            et6.requestFocus();
            et6.setFocusableInTouchMode(true);

            et2.setFocusable(false);
            et2.setEnabled(false);

            et3.setFocusable(false);
            et3.setEnabled(false);

            et4.setFocusable(false);
            et4.setEnabled(false);

            et5.setFocusable(false);
            et5.setEnabled(false);

            et1.setFocusable(false);
            et1.setEnabled(false);
        }

    }
}
