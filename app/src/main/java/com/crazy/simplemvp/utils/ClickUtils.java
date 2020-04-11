package com.crazy.simplemvp.utils;

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
 * 防重复点击
 */
public class ClickUtils {
    // 两次点击按钮之间的点击间隔不能少于1000毫秒
    private int MIN_CLICK_DELAY_TIME = 1000;
    private long lastClickTime = 0L;

    public ClickUtils(int delayTime) {
        this.MIN_CLICK_DELAY_TIME = delayTime;
    }

    public boolean isFastClick() {
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - lastClickTime) >= MIN_CLICK_DELAY_TIME) {
            lastClickTime = curClickTime;
            return true;
        } else {
            return false;
        }
    }
}
