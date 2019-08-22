package com.timo.base.base;

/**
 * 常量类
 */
public class BaseConstancts {
    /**
     * log信息
     */
    public static boolean log = true;
    public static String  TAG = "timo";

    /**
     * 退出时设置：
     * 应用退出时是否进入后台
     * 按返回键应用相应退出的时间-毫秒
     */
    public static boolean exit_to_back = false;
    public static int     exit_time    = 2000;

    /**
     * sp保存名称
     * http缓存文件夹名称
     * 定义一个参数常量值
     * 开启相机的请求Code
     */
    public static final String base_params     = "base_params";
}

