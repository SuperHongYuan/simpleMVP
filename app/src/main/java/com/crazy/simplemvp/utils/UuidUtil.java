package com.crazy.simplemvp.utils;

import java.util.UUID;

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
 */
public class UuidUtil {
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
