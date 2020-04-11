package com.crazy.simplemvp.utils;

import org.greenrobot.eventbus.EventBus;

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
 * eventBus 工具
 */
public class EventBusUtils {

    public static void post(Object event) {
        EventBus.getDefault().post(event);
    }

    public static void register(Object subscriber) {
        if (!isRegistered(subscriber)) EventBus.getDefault().register(subscriber);
    }

    public static void unregister(Object subscriber) {
        if (isRegistered(subscriber)) EventBus.getDefault().unregister(subscriber);
    }

    public static boolean isRegistered(Object subscriber) {
        return EventBus.getDefault().isRegistered(subscriber);
    }

    public static void removeEvent(){
        EventBus.getDefault().removeAllStickyEvents();

    }

    public static void cancel(Object event) {
        EventBus.getDefault().cancelEventDelivery(event);
    }

}
