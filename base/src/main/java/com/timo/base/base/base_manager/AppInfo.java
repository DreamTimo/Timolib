package com.timo.base.base.base_manager;

import android.content.Context;
import android.util.Base64;

import com.timo.base.base.BaseConstancts;
import com.timo.base.tools.utils.SPUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 应用信息
 */

public class AppInfo {
    private AppInfo() {
    }

    public static final String isFirst = "isFirst_base";

    /**
     * 得到应用程序包名
     *
     * @return
     */
    public static String getPackageName(Context context) {
        String packageName = context.getApplicationContext().getPackageName();
        return packageName;
    }

    public static void setIsFirst() {
        SPUtils.getInstance().save(isFirst, false);
    }

    public static boolean isFirst() {
        return (boolean) SPUtils.getInstance().get(isFirst, true);
    }

    public static boolean isLogin(Class userBean) {
        return getUser(userBean) == null ? false : true;
    }

    /**
     * 注销登陆逻辑
     */
    public static void clearUser(Class userBean) {
        SPUtils.getInstance().save(userBean.getSimpleName(), "");
    }

    /**
     * 保存用户信息
     */
    public static void saveUser(Object userBean) {
        saveCacheData(userBean);
    }

    /**
     * 保存数据
     */
    public static void saveData(Object data) {
        saveUser(data);
    }

    /**
     * 保存数据
     */

    public static void clearData(Class data) {
        clearUser(data);
    }

    /**
     * 获取用户信息
     */
    public static Object getData(Class data) {
        return getUser(data);
    }


    /**
     * 保存密码
     */
    public static void savePass(Object pass) {
        saveUser(pass);
    }

    public static Object getPass(Class clazz) {
        return getUser(clazz);
    }

    /**
     * 获取用户信息
     */
    public static Object getUser(Class userBean) {
        return getCacheData(userBean.getSimpleName());
    }

    /**
     * 保存缓存数据
     */
    public static void saveCacheData(Object obj) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            String objString = new String(Base64.encode(
                    byteArrayOutputStream.toByteArray(), Base64.DEFAULT));
            SPUtils.getInstance().save(obj.getClass().getSimpleName(), objString);
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取缓存数据
     */
    public static Object getCacheData(String key) {
        Object obj = null;
        try {
            String str = SPUtils.getInstance().get(key, "").toString();
            if (str.length() <= 0)
                return null;
            obj = null;
            byte[] mobileBytes = Base64.decode(str.toString().getBytes(),
                    Base64.DEFAULT);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                    mobileBytes);
            ObjectInputStream objectInputStream;
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            obj = objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {

        }
        return obj;
    }
}
