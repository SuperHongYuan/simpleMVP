package com.crazy.simplemvp.utils;

import android.util.Log;

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
 * <p>
 * 日志封装
 */
public class XLog {

    private final static String TAG = "DEVICE_SDK：";

    public static void v(Object msg) {
        Log.v(defaultTag(), msg.toString());
    }

    public static void w(Object msg) {
        Log.w(defaultTag(), msg.toString());
    }


    public static void d(Object msg) {
        Log.d(defaultTag(), msg.toString());
    }

    public static void i(Object msg) {
        Log.i(defaultTag(), msg.toString());
    }

    public static void e(Object msg) {
        Log.e(defaultTag(), msg.toString());
    }


    public static void e(Object msg, Throwable throwable) {
        Log.e(defaultTag(), msg.toString(), throwable);
    }


    public static void wtf(Object msg) {
        Log.wtf(defaultTag(), msg.toString());
    }

    /**
     * 获得 类名·方法名
     *
     * @return className . methodName
     */
    private static String defaultTag() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement log = stackTrace[4];
//        Log.e("defaultTag", Arrays.toString(stackTrace));
        String tag = log.getClassName() + "." + log.getMethodName();
        return tag + " ";
    }
}
