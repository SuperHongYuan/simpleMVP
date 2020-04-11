package com.crazy.simplemvp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


import okhttp3.HttpUrl;

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
 * 网络测试工具
 */
public class NetWorkUtil {

    /**
     * 添加默认地址
     *
     * @param url
     * @return
     */
    private static String getUrl(String url) {
        if (!url.contains("http")) {
            url = "http://" + url;
        }
        XLog.d("getUrl : " + url);
        return url;
    }

    /**
     * @param url 检查URL是否正常
     * @return
     */
    public static boolean checkURL(String url) {
        HttpUrl parse = HttpUrl.parse(getUrl(url));
        return parse != null;
    }

    /**
     * * 判断wifi是否连接状态
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>}</p>
     *
     * @return {@code true}: 连接<br>{@code false}: 未连接
     */
    public static boolean isWifiConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm != null && cm.getActiveNetworkInfo() != null
                && cm.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;
    }

    /**
     * 检测当的网络（WLAN、3G/2G）状态
     *
     * @param context Context
     * @return true 表示网络可用
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    // 当前所连接的网络可用
                    return true;
                }
            }
        }
        return false;
    }

}
