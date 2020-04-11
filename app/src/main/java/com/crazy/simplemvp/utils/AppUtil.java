package com.crazy.simplemvp.utils;


import com.crazy.simplemvp.BuildConfig;

import java.util.Calendar;

/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: App
 * Author: huang
 * Date: 2020/4/11 15:03
 * Description:
 * History:
 * 作者：<author>
 * 修改时间：<time>
 * 版本：<version>
 * If the implementation is hard to explain, it's a bad idea.
 * If the implementation is easy to explain, it may be a good idea.
 *
 * app 操作工具
 */
public class AppUtil {

    /**
     * 获取App版本号
     *
     * @return App版本号
     */
    public static String getAppVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    /**
     * 获取App版本号
     *
     * @return App版本号
     */
    public static int getAppVersionCode() {
        return BuildConfig.VERSION_CODE;
    }


    /**
     * @return 返回当前时间的毫秒值
     */
    public static long getNowDate(){
        return Calendar.getInstance().getTimeInMillis();
    }

    /**
     * 防止按钮快速点击
     */
    private static long lastClickTime;

    public static synchronized boolean isFastClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

}
