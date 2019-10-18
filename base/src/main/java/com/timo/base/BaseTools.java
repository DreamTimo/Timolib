package com.timo.base;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.timo.base.base.BaseConstancts;
import com.timo.base.tools.logger.AndroidLogAdapter;
import com.timo.base.tools.logger.Logger;
import com.timo.base.tools.utils.SPUtils;
import com.timo.base.tools.utils.MathUtils;
import com.timo.base.view.TitleBar;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 常用工具
 */
public class BaseTools {
    private static Context mContext;
    private static String data_format_HH_mm            = "HH:mm";
    private static String data_format_yyyy_MM_dd       = "yyyy-MM-dd";
    private static String data_format_yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";

    public BaseTools() {
    }

    public static void init(Context context, boolean log, String logTag) {
        init(context, log, logTag, false);
    }

    /**
     * 初始化
     *
     * @param context:应用上下文
     * @param log：是否打印日志
     * @param logTag：日志标识
     * @param exit_to_back：是否将应用退出到后台
     */
    public static void init(Context context, boolean log, String logTag, boolean exit_to_back) {
        mContext = context.getApplicationContext();
        BaseConstancts.log = log;
        BaseConstancts.TAG = logTag;
        BaseConstancts.exit_to_back = exit_to_back;
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    public static Context getContext() {
        return mContext;
    }

    public static void log(Throwable e) {
        if (BaseConstancts.log) {
            Logger.e(BaseConstancts.TAG, e);
        }
    }

    public static void log(Object bean) {
        if (BaseConstancts.log) {
            Logger.json(new Gson().toJson(bean));
        }
    }

    public static void log(String log) {
        if (BaseConstancts.log) {
            Logger.log(Logger.ERROR, BaseConstancts.TAG, log, null);
        }
    }

    /**
     * 设置标题
     *
     * @param titlebar
     * @param title
     * @param titleColor
     * @param bgColor
     * @param iconBackId
     * @param listener
     */
    public static void setTitlebar(TitleBar titlebar, String title, int titleColor, int bgColor, int iconBackId, View.OnClickListener listener) {
        titlebar.setLeftImageResource(iconBackId);
        titlebar.setBackgroundColor(bgColor);
        titlebar.setLeftClickListener(listener);
        titlebar.setTitle(title);
        titlebar.setTitleSize(17);
        titlebar.setTitleColor(titleColor);
    }

    /**
     * 设置标题
     *
     * @param titlebar
     * @param title
     * @param iconBackId
     * @param listener
     */
    public static void setTitlebar(TitleBar titlebar, String title, int iconBackId, View.OnClickListener listener) {
        titlebar.setLeftImageResource(iconBackId);
        titlebar.setBackgroundColor(Color.parseColor("#f1f1f1"));
        titlebar.setLeftClickListener(listener);
        titlebar.setTitle(title);
        titlebar.setTitleSize(17);
        titlebar.setTitleColor(Color.parseColor("#333333"));
    }

    /**
     * 常用工具
     */
    public static int px2dp(float pxValue) {
        return MathUtils.getInstance().px2dp(mContext, pxValue);
    }

    public static int dp2px(float pxValue) {
        return MathUtils.getInstance().dp2px(mContext, pxValue);
    }

    public static int px2sp(float pxValue) {
        return MathUtils.getInstance().px2sp(mContext, pxValue);
    }

    public static int sp2px(float pxValue) {
        return MathUtils.getInstance().sp2px(mContext, pxValue);
    }

    public static <T> T getRandom(List<T> readomWords) {
        return MathUtils.getInstance().getRandom(readomWords);
    }

    public static int getRandomInt(int start, int end) {
        return MathUtils.getInstance().getRandomInt(start, end);
    }

    /**
     * 获取布局,包括父布局
     *
     * @param parent：父布局
     */
    public static View getView(Context context, int layoutId, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(layoutId, parent, false);
    }

    /**
     * 获取Data时间
     */
    public static Date getData(String str, String formatString) {
        SimpleDateFormat format = new SimpleDateFormat(formatString);
        Date             parse  = null;
        try {
            parse = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    /**
     * 时间戳转换成字符串类型的时间
     */

    public static String getTime(String str, String formatString) {
        Long             timestamp = Long.parseLong(str) * 1000;
        SimpleDateFormat format    = new SimpleDateFormat(formatString);
        String           datetime  = format.format(new Date(timestamp));
        return datetime;
    }

    /**
     * 时间戳转换成字符串类型的时间
     */
    public static String getTime(long time, String formatString) {
        SimpleDateFormat format   = new SimpleDateFormat(formatString);
        String           datetime = format.format(new Date(time));
        return datetime;
    }

    /**
     * 时间戳转换成字符串类型的时间
     */
    public static String getTime(Date date, String formatString) {
        SimpleDateFormat format   = new SimpleDateFormat(formatString);
        String           datetime = format.format(date);
        return datetime;
    }

    /**
     * 设置文字
     *
     * @param textView:TextView
     * @param text:设置的文本，为空默认不设置
     */

    public static void setText(TextView textView, String text, String defaltText) {
        if (!TextUtils.isEmpty(text)) {
            textView.setText(text);
        } else {
            textView.setText(defaltText);
        }
    }

    /**
     * Sp存信息
     */
    public static void spSave(String key, Object value) {
        SPUtils.getInstance().save(key, value);
    }

    /**
     * Sp取信息
     */
    public static Object spGet(String key, Object defaultValue) {
        return SPUtils.getInstance().get(key, defaultValue);
    }


    /**
     * 获取手机号码
     */

    public static String getPhone(String phone, int startIndex, int endIndex, String replaceString) {
        return phone.substring(0, startIndex) + replaceString + phone.substring(endIndex);
    }


    public static Bitmap getScaleBitmap(Bitmap bitMap, int newWidth, int newHeight) {
        int width  = bitMap.getWidth();
        int height = bitMap.getHeight();
        // 计算缩放比例
        float scaleWidth  = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片
        Bitmap newBitMap = Bitmap.createBitmap(bitMap, 0, 0, width, height, matrix, true);
        return newBitMap;
    }

    public static byte[] getPixelsBGR(Bitmap image) {
        int        bytes  = image.getByteCount();
        ByteBuffer buffer = ByteBuffer.allocate(bytes);
        image.copyPixelsToBuffer(buffer);
        byte[] temp   = buffer.array();
        byte[] pixels = new byte[(temp.length / 4) * 3];
        for (int i = 0; i < temp.length / 4; i++) {

            pixels[i * 3] = temp[i * 4 + 2];
            pixels[i * 3 + 1] = temp[i * 4 + 1];
            pixels[i * 3 + 2] = temp[i * 4];
        }
        return pixels;
    }

    /**
     * 非空检验
     */
    public static boolean isNotEmpty(Object obj) {
        return MathUtils.getInstance().isNotEmpty(obj);
    }


    /**
     * 获取视频的第一帧
     *
     * @param filePath
     * @return
     */
    public static Bitmap getVideoFirshBitmap(String filePath) {
        Bitmap bitmap = null;
        //MediaMetadataRetriever 是android中定义好的一个类，提供了统一
        //的接口，用于从输入的媒体文件中取得帧和元数据；
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            //根据文件路径获取缩略图
            retriever.setDataSource(filePath);
            //获得第一帧图片
            bitmap = retriever.getFrameAtTime();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            retriever.release();
        }
        return bitmap;
    }

    /**
     * 获取mate信息
     */
    public static String getMeta(Context context, String name) {
        String          str = "";
        ApplicationInfo ai;
        try {
            ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            Object v = ai.metaData.get(name);
            if (v != null) {
                str = v.toString();
            }
        } catch (PackageManager.NameNotFoundException e) {

        }
        return str;
    }

    /**
     * 银行卡号，保留最后4位，其他星号替换
     */
    public static String getBankCard(String card) {
        return card.substring(0, 4) + "***********" + card.substring(15);
    }

    /**
     * 身份证号，中间10位星号替换
     */
    public static String getIdentity(String card) {
        return card.substring(0, 4) + "**********" + card.substring(14);
    }

    /**
     * 关闭流资源
     */
    public static boolean closeIo(Closeable io) {
        if (io != null) {
            try {
                io.close();
            } catch (IOException e) {
                log(e);
            }
        }
        return true;
    }

    /**
     * bitmap保存成文件
     *
     * @param bmp
     * @param bitName
     * @return
     * @throws IOException
     */
    public boolean saveBitmap(Context context, Bitmap bmp, String bitName) {
        try {
            String mSavePath = context.getCacheDir() + "/images";
            File   f         = new File(mSavePath, bitName);
            f.createNewFile();
            FileOutputStream fOut;
            fOut = new FileOutputStream(f);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
            return true;
        } catch (IOException e) {
            log(e);
            return false;
        }

    }
}
