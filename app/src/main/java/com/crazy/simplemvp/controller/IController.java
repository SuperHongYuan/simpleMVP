package com.crazy.simplemvp.controller;

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
 * 基础控制器 所有的控制器都应当继承至该控制器
 */
public interface IController {

    /**
     * 所有的页面都应该保活
     */
    interface IView {
        /**
         * 页面关闭
         */
        void finish();
    }
    interface IPresenter {

    }
}
